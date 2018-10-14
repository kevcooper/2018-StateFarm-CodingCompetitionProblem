package com.codingcompetition.statefarm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingcompetition.statefarm.Category;
import com.codingcompetition.statefarm.SearchCriteria;

public class PointOfInterest {
	
	private String id, version, changeset, uid;
	private final String lat, lon;
	private String timestamp, user;
	private SearchCriteria searchCrit;
	private HashMap<Object, String> desc;
	
	public PointOfInterest(String id, String version, String changeset, String uid, String lat, String lon, String timestamp, String user) {
		this.id = id;
		this.version = version;
		this.changeset = changeset;
		this.uid = uid;
		this.lat = lat;
		this.lon = lon;
		this.timestamp = timestamp;
		this.user = user;
		this.desc = new HashMap<>();
	}

    public Map<Object,String> getDescriptors() {
    		return desc;
    }

    public String getLatitude() {
        return lat;
    }

    public String getLongitude() {
        return lon;
    }
    
    public String getId() {
        return id;
    }
    
    public String getVersion() {
    		return version;
    }
    
    public String getChangeset() {
    		return changeset;
    }
    
    public String getUid() {
		return uid;
    }
    
    public String getTimestamp() {
		return timestamp;
    }
    
    public String getUser() {
		return user;
    }
    
}