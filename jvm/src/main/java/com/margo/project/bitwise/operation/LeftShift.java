package com.margo.project.bitwise.operation;





import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;



/**
 * 左移
 * @author fxb20
 *
 */
public class LeftShift {

//	@Native public static final int SIZE = 32;
//    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
//    private static final int COUNT_BITS = Integer.SIZE - 3;
//    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
//
//    // runState is stored in the high-order bits
//    private static final int RUNNING    = -1 << COUNT_BITS;
//    private static final int SHUTDOWN   =  0 << COUNT_BITS;
//    private static final int STOP       =  1 << COUNT_BITS;
//    private static final int TIDYING    =  2 << COUNT_BITS;
//    private static final int TERMINATED =  3 << COUNT_BITS;
//
//    // Packing and unpacking ctl
//    private static int runStateOf(int c)     { return c & ~CAPACITY; }
//    private static int workerCountOf(int c)  { return c & CAPACITY; }
//    private static int ctlOf(int rs, int wc) { return rs | wc; }
	
	@Test
	public void state() {
		
		//11100000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(-1 << 29));   //RUNNING  -536870912
		
		//00000000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(0 << 29));   //shutdown=0
		
		//00100000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(1 << 29));   //STOP=1
		
		//01000000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(2 << 29));   //TIDYING=2
		
		//01100000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(3 << 29));   //TERMINATED=3
	}
	
	//@Test
	public void capacity() {
		//CAPACITY   = (1 << COUNT_BITS) - 1;
		int capacity=(1<<29)-1;
		
		//00011111 11111111 11111111 11111111
		System.out.println(Integer.toBinaryString(capacity));     //capacity
		
		//11100000 00000000 00000000 00000000
		System.out.println(Integer.toBinaryString(~capacity));   // ~capacity
		
		//System.out.println( 4 & ~capacity);   // runStateOf   0
		
	}
	
	//@Test
	public void getctl() {
		int running=(-1) << 29;   //11100000 00000000 00000000 00000000   ctl
		System.out.println(this.ctlOf(running,0));
		
		AtomicInteger ctl = new AtomicInteger(ctlOf(running, 0));    //ct1 默认值
		System.out.println(workerCountOf(ctl.get()));
	}
	
	/**
	 * 高三位 与运算   int类型32位
	 * @param c
	 * @return
	 */
	public int runStateOf(int c)     {
		int CAPACITY=(1<<29)-1; 
		return c & ~CAPACITY; }
	
	/**
	 * 低三位 与运算   int类型32位
	 * @param c
	 * @return
	 */
	public int workerCountOf(int c)  { 
		int CAPACITY=(1<<29)-1;
		return c & CAPACITY; }
	
	public  int ctlOf(int rs, int wc) { return rs | wc; }
	

	/**
	 * 
	 */
	//@Test
	public void positiveNumber() {
		/**
		 * 0001  左移 一位0010
		 */
		System.out.println(1<<1);
	}
	
	//@Test
	public void negativeNumber() {
		/**
		 * 0001  左移 一位0010
		 */
		System.out.println((-1)<<1);
	}
}
