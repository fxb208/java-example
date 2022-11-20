package com.margo.project.jvm.reference;



/**
 * https://blog.csdn.net/dayang0307/article/details/101382012
 * @return
 */
public class StudentCache {
	
	private static class InnerClassStudentCache {
		public static final StudentCache _INSTANCE=new StudentCache();
	}
	
	public static StudentCache getInstance() {
		return InnerClassStudentCache._INSTANCE;
	}

}
