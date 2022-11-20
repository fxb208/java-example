package com.margo.project.designpattern.composite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



public class CompositeDemo {
	
	@Test
	public void resolver() {
		List<MargoComponent> composite=new ArrayList<MargoComponent>();
		composite.add(new MargoComponentGirlImpl());
		composite.add(new MargoComponentWifeImpl());
		MargoResolverComposite margoResolverComposite=new MargoResolverComposite(composite);
		Object result= margoResolverComposite.resolver("girl");
		System.out.println(result);	
	}
}
