package com.distribuida.db;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
	public class Author {
	private Long id;
	private String first_name;
	private String last_name;
	
	public Author() {
	
	}
	
	public Author(Long id, String first_name, String last_name) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public String getFirst_name() {
		
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}