package com.codingcompetition.statefarm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingcompetition.statefarm.Category;

public class PointOfInterest {
	private class Tag {
		private Category key;
		private String value;
		
		public Tag(Category key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public Category getKey() {
			return this.key;
		}
		
		public String getValue() {
			return this.value;
		}
	}
	
	private int id, version, changeset, uid;
	private double lat, lon;
	private String timestamp, user;
	private List<Tag> tags;
	
	public PointOfInterest(int id, int version, int changeset, int uid, double lat, double lon, String timestamp, String user, List<Tag> tags) {
		this.id = id;
		this.version = version;
		this.changeset = changeset;
		this.uid = changeset;
		this.lat = lat;
		this.lon = lon;
		this.timestamp = timestamp;
		this.user = user;
		this.tags = tags;
	}

    public Map<Object,String> getDescriptors() {
    return new HashMap<>();
    }

    public String getLatitude() {
        return "";
    }

    public String getLongitude() {
        return "";
    }
}