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
        return null;
    }

    @Override
    public List<PointOfInterest> interpret(Map<Integer, SearchCriteria> prioritizedCriteria) {
        return null;
    }

    @Override
    public List<PointOfInterest> findByCriterias(List<SearchCriteria> criterias) {
        return null;
    }
}
