package com.margo.project.sysn.cancelled;

/**
 * 响应中断
 * @author fxb208
 *
 */
public class SleepInterrupt {
	public static void main(String[] args) {
		Thread man=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("man:");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("中断了");
				}
			}
		});
		
		Thread girl=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("girl:"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//中断
				man.interrupt();
			}
		});
		
		man.start();
		girl.start();
	}
	
	
}
