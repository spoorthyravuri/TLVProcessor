package com.test.tlvprocessor;

import java.util.ArrayList;
import java.util.List;

public class TLVHelper {

	public static List<TLV> convertToTLV(String str) {
		
		if(str == null || str.isEmpty()) {
			return null;
		}
		List<TLV> tlvs = new ArrayList<TLV>();
		while(str.length() > 0) {
			int index = 0;
			String type = str.substring(index, str.indexOf("-"));
			index = str.indexOf("-") + 1;
			String lengthStr = str.substring(index, index + 4);
			int length = Integer.parseInt(lengthStr);
			index = index + 5;
			String value = str.substring(index, index + length);			
			tlvs.add(new TLV(type, length, value));
			str = str.substring(index + length);
		}
		return tlvs;
	}
	
	public static void main(String[] args) {
		System.out.println(convertToTLV("UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z"));
	}
	
}
