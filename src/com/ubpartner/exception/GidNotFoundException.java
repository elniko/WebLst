package com.ubpartner.exception;

public class GidNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String guid;

	private String tool;

	private String version;

	public GidNotFoundException() {
		super();
	}

	public GidNotFoundException(String msg) {
		super(msg);
	}

	public GidNotFoundException(String msg, Exception e) {
		super(msg, e);
	}

	public GidNotFoundException(String msg, String guid, String tool,
			String version) {

		super(msg);
		this.guid = guid;
		this.tool = tool;
		this.version = version;
	}

	public GidNotFoundException(String msg, Exception e, String guid, String tool,
			String version) {

		super(msg, e);
		this.guid = guid;
		this.tool = tool;
		this.version = version;
	}

}
