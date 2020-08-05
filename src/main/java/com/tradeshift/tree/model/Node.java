package com.tradeshift.tree.model;

import javax.persistence.*;

/*
 This tree structured Node data has one root and multiple children nodes
 */

@Entity
public class Node {
	
	@Id
	private Long id;
	
	private String name;
	
	private String path;
	
	public Node(Long id, String name, String path) {
		this.id = id;
		this.name = name;
		this.path = path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
