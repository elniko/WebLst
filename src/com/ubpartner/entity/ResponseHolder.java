package com.ubpartner.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseHolder<T> {

	public ResponseHolder() {}
	private T responseObject;
	
	public T getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}

	public ResponseHolder(T obj) {
		
		responseObject = obj;
	}
}
