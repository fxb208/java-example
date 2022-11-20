package com.margo.project.designpattern.chain;

public class MargoInterceptingImpl2 implements MargoIntercepting{

	@Override
	public void handle(MargoProcessor handle, MargoChain chain) {
		int a=(int) (Math.random()*100+1);
		if(a%2==1) {
			handle.addBuffer("word");
			chain.execute(handle);	
		}
		return;
		
	}

}
