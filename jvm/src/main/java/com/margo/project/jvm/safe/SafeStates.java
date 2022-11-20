package com.margo.project.jvm.safe;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * final关键字可见性：被final修饰的字段在构造器中一旦初始化完成，并且构造器没有把this引用传递出去，那么在其他线程就能看见final的值
 * 不可变对象 Integer String
 * 
 * @author fxb208
 *
 */
public class SafeStates {
	private final Map<String, String> states;
	
	/**
	 * 不可变对象初始化安全性
	 * 对于final域对象，初始化安全性可以防止对对象的初始化引用被重排序到构造过程之前
	 */
	public SafeStates() {
		states=new HashMap<String, String>();
		states.put("name", "margo");
		states.put("age", "28");
	}
	
	public String getAbbreviation(String a) {
		return states.get(a);
	}
	
	
	
}
