package com.codingcompetition.statefarm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingcompetition.statefarm.Category;
import com.codingcompetition.statefarm.SearchCriteria;

public class PointOfInterest {
	
	private String id, version, changeset, uid;
	private String lat, lon;
	private String timestamp, user;
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
	
	public PointOfInterest() {
		this.id = null;
		this.version = null;
		this.changeset = null;
		this.uid = null;
		this.lat = null;
		this.lon = null;
		this.timestamp = null;
		this.user = null;
		this.desc = new HashMap<>();
	}

    public Map<Object,String> getDescriptors() {
    		return desc;
    }
    
    public void setDescriptors(String key, String val) {
		this.desc.put(key, val);
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
    
    
    public void setLatitude(String lat) {
        this.lat = lat;
    }

    public void setLongitude(String lon) {
        this.lon = lon;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setVersion(String version) {
    		this.version = version;
    }
    
    public void setChangeset(String changeset) {
    		this.changeset = changeset;
    }
    
    public void setUid(String uid) {
		this.uid = uid;
    }
    
    public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
    }
    
    public void setUser(String user) {
		this.user = user;
    }
}