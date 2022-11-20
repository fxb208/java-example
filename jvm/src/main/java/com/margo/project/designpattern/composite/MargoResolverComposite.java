package com.margo.project.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class MargoResolverComposite implements MargoComponent{

	private List<MargoComponent> composite;
	
	public MargoResolverComposite(List<MargoComponent> composite) {
		super();
		this.composite = composite;
	}
	
	public MargoResolverComposite() {
		super();
		this.composite = new ArrayList<MargoComponent>();
	}
	

	@Override
	public boolean supports(String role) {
		for(MargoComponent margoComponent:composite) {
			if(margoComponent.supports(role)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object resolver(String role) {
		for(MargoComponent margoComponent:composite) {
			if(margoComponent.supports(role)) {
				return margoComponent.resolver(role);
			}
		}
		return null;
	}

}
