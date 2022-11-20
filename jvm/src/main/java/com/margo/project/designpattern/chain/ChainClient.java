package com.margo.project.designpattern.chain;

public class ChainClient {
	public static void main(String[] args) {
		MargoChainImpl margoInterceptChain=new MargoChainImpl();
		margoInterceptChain.addInterceptor(new MargoInterceptingImpl());
		margoInterceptChain.addInterceptor(new MargoInterceptingImpl2());
		MargoProcessor margoProcessor=new MargoProcessor();
		margoInterceptChain.execute(margoProcessor);
		System.out.println(margoProcessor.say());
	}
}
