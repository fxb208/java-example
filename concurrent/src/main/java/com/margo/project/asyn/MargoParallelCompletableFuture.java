package com.margo.project.asyn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * parallel 并行
 * @author fangxingbang
 *
 */
public class MargoParallelCompletableFuture {
    public static void main(String[] args) {
        parallel();
    }
    public static void parallel(){
        Map<String, Object> map = new HashMap<>();
        CompletableFuture cfFetch= CompletableFuture.supplyAsync(()->{
            return queryCode("中国石化");
        }).thenAccept((code)->{
            map.put(code,fetchPrice(code));
        });

        CompletableFuture dfFetch=CompletableFuture.supplyAsync(()->{
            return queryCode("中国石油");
        }).thenAccept((code)->{
            map.put(code,fetchPrice(code));
        });


        CompletableFuture all = CompletableFuture.allOf(cfFetch,dfFetch).thenApply((result) -> {
            return map;
        });
        all.join();
        for(String str:map.keySet()){
            System.out.println(str+":"+map.get(str));
        }

    }

    private static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "601857";
    }

    public static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        if(Math.random()<0.3) {
//            throw new RuntimeException("fetchPrice fail");
//        }
        return 5+Math.random()*20;
    }
}
