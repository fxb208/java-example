package com.margo.project.designpattern.chain;

public interface MargoIntercepting {
	void handle(MargoProcessor handle,MargoChain chain);
}
