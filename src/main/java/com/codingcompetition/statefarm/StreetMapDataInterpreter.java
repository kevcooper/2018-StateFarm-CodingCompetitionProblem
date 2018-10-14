package com.codingcompetition.statefarm;

import com.codingcompetition.statefarm.model.PointOfInterest;
import com.codingcompetition.statefarm.utility.PointOfInterestParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreetMapDataInterpreter implements Interpreter {

	List<PointOfInterest> list;

    public StreetMapDataInterpreter(String fn) {
    		
    		PointOfInterestParser point = new PointOfInterestParser();
    		try {
    			list = point.parse(fn);
    		}catch (Exception e){
    			e.printStackTrace();
    		}
    }

    @Override
    public List<PointOfInterest> interpret() {
        return list;
    }

    @Override
    public List<PointOfInterest> interpret(SearchCriteria criteria) {
    	
    		List<PointOfInterest> list = new ArrayList<PointOfInterest>();
    		
    		if (criteria == null) {
    			return list;
    		}
    		
    		
    		
        return null;
    }

    @Override
    public List<PointOfInterest> interpret(Map<Integer, SearchCriteria> prioritizedCriteria) {
        return null;
    }

    @Override
    public List<PointOfInterest> findByCriterias(List<SearchCriteria> criterias) {
    	
    		List<PointOfInterest> find = new ArrayList<PointOfInterest>();
    		
    		if(criterias == null) {
    			return find;
    		}
    		for (PointOfInterest l : list ) {
	    		for(SearchCriteria criteria : criterias) {
	    			
	    			Map<Object, String> descript = l.getDescriptors();
	    			
	    			Category category = criteria.getCat();
	    			String val = criteria.getValue(); 
	    			
	    			if (category == Category.NAMESTARTSWITH) {
	    				
	    			}
	    			
	    		}
    		}
    		
        return null;
    }
}
