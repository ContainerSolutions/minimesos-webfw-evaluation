package com.containersol.minivertx;

public class HelloData {

	private String someParam;

	private String otherParam;

	private Long usedMemory;

	public HelloData() {
	}

	public HelloData(String someParam, String otherParam, Long usedMemory) {
		this.someParam = someParam;
		this.otherParam = otherParam;
		this.usedMemory = usedMemory;
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

	public Long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(Long usedMemory) {
		this.usedMemory = usedMemory;
	}
}
