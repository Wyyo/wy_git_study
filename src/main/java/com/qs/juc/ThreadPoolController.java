package com.qs.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolController {
//    public static void main(String[] args) {
////        Executors.newSingleThreadExecutor();
////        Executors.newFixedThreadPool(5);
////        Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,2, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(5),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//        try {
//            for (int i = 0; i < 18; i++) {
//                executor.execute(()->{
//                    line();
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executor.shutdown();
//        }
//    }

    public static void line() {
        System.out.println(Thread.currentThread().getName() + "办业务ing");
    }
}
