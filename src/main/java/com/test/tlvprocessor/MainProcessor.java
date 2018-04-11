package com.test.tlvprocessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class MainProcessor {
	
	public void doProcess(Reader in, Writer out) throws IOException {
		BufferedReader br = new BufferedReader(in);
		BufferedWriter bw = new BufferedWriter(out);
		while(true) {
			String str = br.readLine();
			List<TLV> tlvs = TLVHelper.convertToTLV(str);
			if(tlvs != null && !tlvs.isEmpty()) {
				for (TLV tlv : tlvs) {
					TLVConstants tlvConstants = TLVConstants.fromString(tlv.getType());
					if(tlvConstants != null) {
						bw.write(tlv.getType() + "-" + tlvConstants.processor.process(tlv.getValue()));
					} else {
						bw.write("Type not valid");
					}
					bw.newLine();
				}
				bw.flush();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		MainProcessor mainProcessor = new MainProcessor();
		mainProcessor.doProcess(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
	}
	
}
