package com.codingcompetition.statefarm;

public class SearchCriteria {

	private Category cat;
	private String value;
	
	public SearchCriteria(Category cat, String value) {
		this.cat = cat;
		this.value = value;
	}
	
	public Category getCat() {
		return this.cat;
	}
	
	public String getValue() {
		return this.value;
	}
}
