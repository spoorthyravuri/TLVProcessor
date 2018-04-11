package com.test.tlvprocessor;

public enum TLVConstants {
	
	UPPRCS("UPPRCS", new Processor() {

		public String process(String input) {
			return input.toUpperCase();
		}
		
	}),
	
	REPLCE("REPLCE", new Processor() {

		public String process(String input) {
			return "THIS STRING";
		}
		
	});
	
	public String type;
	public Processor processor;
	
	private TLVConstants(String type, Processor processor) {
		this.type = type;
		this.processor = processor;
	}
	
	public static TLVConstants fromString(String type) {
		for (TLVConstants tlvConstants : TLVConstants.values()) {
			if(tlvConstants.type.equalsIgnoreCase(type)) {
				return tlvConstants;
			}
		}
		return null;
	}
	
}
