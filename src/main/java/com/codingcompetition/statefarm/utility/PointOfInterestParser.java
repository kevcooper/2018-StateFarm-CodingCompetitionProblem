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
	        elements.push(qName);
	 
	        //If this is start of 'user' element then prepare a new User instance and push it in object stack
	        if ("node".equals(qName))
	        {
	            //New User instance
	            PointOfInterest poi = new PointOfInterest();
	 
	            //Set all required attributes in any XML element here itself
	            if(attributes != null && attributes.getLength() == 1)
	            {
//	                poi.setId(Integer.parseInt(attributes.getValue(0)));
	            }
	            objects.push(poi);
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
	        String value = new String(ch, start, length).trim();
	 
	        if (value.length() == 0)
	        {
	            return; // ignore white space
	        }
	        
	        PointOfInterest poi = (PointOfInterest) objects.peek();
	        System.out.println(elements.peek());;
	        switch (elements.peek()) {
	        case "id":
	            poi.setId(value);
	        	break;
	        case "version":
	            poi.setVersion(value);
	        	break;
	        case "changeset":
	        	poi.setChangeset(value);
	        	break;
	        case "uid":
	        	poi.setUid(value);
	        	break;
	        case "lat":
	        	poi.setLatitude(value);
	        	break;
	        case "lon":
	        	poi.setLongitude(value);
	        	break;
	        case "timestamp":
	        	poi.setTimestamp(value);
	        	break;
	        case "user":
	        	poi.setUser(value);
	        	break;
	        }
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
        saxParser.parse(new File(fileName), handler);
        
        for(PointOfInterest poi : poiList)
            System.out.println(poi);
    	return poiList;
    }

}
