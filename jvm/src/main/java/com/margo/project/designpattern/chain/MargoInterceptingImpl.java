package com.margo.project.designpattern.chain;

public class MargoInterceptingImpl implements MargoIntercepting{

	@Override
	public void handle(MargoProcessor handle, MargoChain chain) {
		handle.addBuffer("hello");
		chain.execute(handle);
	}

}
