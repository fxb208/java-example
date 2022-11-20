package com.margo.project.designpattern.chain;

public class MargoProcessor {
	
	private StringBuffer buffer;

	public MargoProcessor() {
		super();
		this.buffer = new StringBuffer();
	}

	public void addBuffer(String name) {
		buffer.append(name);
	}
	
	public String say() {
		return buffer.toString();
	}
}
