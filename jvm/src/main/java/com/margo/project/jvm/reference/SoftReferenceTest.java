package com.margo.project.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import com.margo.project.jvm.reference.model.Student;

/**
 * https://blog.csdn.net/dayang0307/article/details/101382012
 * @author fxb20
 *
 */
public class SoftReferenceTest {
	public static void main(String[] args) {

	}
	
	public void softReference() {
		Student stu = new Student();
		SoftReference<Student> softRef = new SoftReference<Student>(stu);
		/*此时若发生GC，Student对象只有一个软引用softRef指向它，若内存此时即将OOM，则该Student实例将被回收*/
		stu = null;	
	}
	
	/**
	 * 若SoftReference构造方法传入了ReferenceQueue，则在回收该对象之后，相应的SoftReference实例会被add进referenceQueue：
	 */
	public void referenceQueue() {
		Student stu = new Student();
		ReferenceQueue<Student> studentReferenceQue = new ReferenceQueue<Student>();
		SoftReference<Student> softRef = new SoftReference<Student>(stu, studentReferenceQue );
		/*在内存不足GC，该Student实例被回收时，SoftReference实例softRef将被add进referenceQueue*/
		//SoftReference<Student> softRefFromQueue = (SoftReference<Student>)studentReferenceQue.poll(); 

		stu = null; 	
	}
}
