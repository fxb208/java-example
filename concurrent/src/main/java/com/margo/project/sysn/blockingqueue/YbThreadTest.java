package com.margo.project.sysn.blockingqueue;

public class YbThreadTest {
    public static void main(String[] args) throws InterruptedException {
        YbBlockingQueue<Integer> blockingQueue=new YbBlockingQueue<>();

        Thread t1 = new Thread(()->{
            int idx = 10;
            while (idx>0){
                try {
                    System.out.println("***");
                    blockingQueue.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                idx--;
            }
        });

        Thread t2 = new Thread(()->{
            int idx = 10;
            while (idx>0){
                try {
                    System.out.println("####:"+idx);
                    blockingQueue.pop();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                idx--;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

//        blockingQueue.add(1);
//        blockingQueue.add(2);
//        System.out.println("***");
//        blockingQueue.add(3);  //阻塞
//        System.out.println("###");
    }
}
