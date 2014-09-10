package com.ubpartner.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class TestEntity {

	
	private String field;
	@XmlElement
	public String getField() {
		return field;
	}
public TestEntity() {}
	public void setField(String field) {
		this.field = field;
	}
	
	public TestEntity (String f) {
		field = f;
	}
}
