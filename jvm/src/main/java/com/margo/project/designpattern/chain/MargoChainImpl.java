package com.margo.project.designpattern.chain;

import java.util.ArrayList;
import java.util.List;

public class MargoChainImpl implements MargoChain{

	private int index=0;

	private List<MargoIntercepting> interceptors;


	public MargoChainImpl() {
		super();
		interceptors=new ArrayList<>();
	}

	public MargoChainImpl(List<MargoIntercepting> interceptors) {
		super();
		this.interceptors = interceptors;
	}
	
	public void addInterceptor(MargoIntercepting intercepting) {
		interceptors.add(intercepting);
	}

	
	@Override
	public void execute(MargoProcessor handle) {
		if(index<interceptors.size()) {
			MargoIntercepting interceptor=interceptors.get(index);
			index++;
			interceptor.handle(handle, this);
			return;
		}
	}
}
