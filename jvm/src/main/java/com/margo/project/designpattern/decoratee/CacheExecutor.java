package com.margo.project.designpattern.decoratee;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CacheExecutor implements Executor{
	
	Map<Integer, String> cache=new HashMap<Integer, String>();

	private Executor delegate;

	public CacheExecutor(Executor delegate) {
		super();
		this.delegate = delegate;
		cache.put(1, "东方不败");
	}


	@Override
	public String exec(int type) {
		String result=cache.get(type);
		if(StringUtils.isNotBlank(result)) {
			return result;
		}
		// TODO Auto-generated method stub
		return delegate.exec(type);
	}

}
