package com.margo.project.sysn.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class YbBlockingQueue<T> {

    private final Queue<T> queue;
    private int len=2;
    public YbBlockingQueue(){
        this.queue = new LinkedList<>();
    }

    public synchronized void add(T t) throws InterruptedException {
        while(queue.size()==2){
            wait();
        }
        queue.add(t);
        notifyAll();
//        if(queue.size()<2){
//            queue.add(t);
//            return;
//        }
//        wait();
//        queue.add(t);
    }

    public synchronized T pop() throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }
        T res = queue.poll();
        notifyAll();
        return res;
    }
}
