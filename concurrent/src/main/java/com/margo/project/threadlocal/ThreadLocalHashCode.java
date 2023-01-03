package com.margo.project.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * hashcode
 */
public class ThreadLocalHashCode {
    private static AtomicInteger nextHashCode = new AtomicInteger();

    // 1640531527
    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    /**
     * 0
     * 1640531527
     * -1013904242
     * 626627285
     * -2027808484
     * -387276957
     * 1253254570
     * -1401181199
     * 239350328
     * 1879881855
     *
     * @param args
     */
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(nextHashCode());
        }

    }
}
