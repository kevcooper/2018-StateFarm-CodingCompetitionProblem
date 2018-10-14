package com.codingcompetition.statefarm.utility;

import com.codingcompetition.statefarm.model.PointOfInterest;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PointOfInterestParser {
	
	private class POIHandler extends DefaultHandler {
	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	    {
	        //Push it in element stack
	        elements.push(qName.toLowerCase());
	 
	        //If this is start of 'user' element then prepare a new User instance and push it in object stack
	        if ("node".equals(qName.toLowerCase()))
	        {
	            //New User instance
	            PointOfInterest poi = new PointOfInterest();
	 
	            poi.setId(attributes.getValue("id"));
	            poi.setVersion(attributes.getValue("version"));
	        	poi.setChangeset(attributes.getValue("changeset"));
	        	poi.setUid(attributes.getValue("uid"));
	        	poi.setLatitude(attributes.getValue("lat"));
	        	poi.setLongitude(attributes.getValue("lon"));
	        	poi.setTimestamp(attributes.getValue("timestamp"));
	        	poi.setUser(attributes.getValue("user"));
		        	
	            objects.push(poi);
	        } else if ("tag".equals(qName)) {
	        	objects.peek().setDescriptors(attributes.getValue("k"), attributes.getValue("V"));
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException
	    {
	        //Remove last added  element
	        elements.pop();
	 
	        //User instance has been constructed so pop it from object stack and push in userList
	        if ("node".equals(qName))
	        {
	            PointOfInterest poi = objects.pop();
	            poiList.add(poi);
	        }
	    }

	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException
	    {

	    }
		
	}

    // Stacks for storing the elements and objects.
    private Stack<String> elements = new Stack<String>();
    private Stack<PointOfInterest> objects = new Stack<PointOfInterest>();
    private ArrayList<PointOfInterest> poiList = new ArrayList<PointOfInterest>();


    public List<PointOfInterest> parse(String fileName) throws IOException, SAXException, ParserConfigurationException {
    	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    	SAXParser saxParser = saxParserFactory.newSAXParser();
    	POIHandler handler = new POIHandler();
        saxParser.parse(getClass().getResource(fileName).getFile(), handler);
        
    	return poiList;
    }

}
