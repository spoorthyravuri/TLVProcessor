package com.test.tlvprocessor;

public class TLV {
	
	public TLV() {
		
	}
	
	public TLV(String type, int length, String value) {
		this.type = type;
		this.length = length;
		this.value = value;
	}

	private String type;
	private int length;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Type: "+ type + ", Length: "+length + ", Value:"+value;
	}

}
