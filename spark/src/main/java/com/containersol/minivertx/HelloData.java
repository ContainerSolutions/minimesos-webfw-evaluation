package com.containersol.minivertx;

public class HelloData {

	private String someParam;

	private String otherParam;

	public HelloData() {
	}

	public HelloData(String someParam, String otherParam) {
		this.someParam = someParam;
		this.otherParam = otherParam;
	}

	public String getSomeParam() {
		return someParam;
	}

	public void setSomeParam(String someParam) {
		this.someParam = someParam;
	}

	public String getOtherParam() {
		return otherParam;
	}

	public void setOtherParam(String otherParam) {
		this.otherParam = otherParam;
	}
}
