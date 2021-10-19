package com.qs.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
//    TODO AtomicInteger:5000000
    static AtomicInteger num = new AtomicInteger(0);
//    TODO INT:4113616
    static int number = 0;
    public static void main(String[] args) throws InterruptedException {

        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            list.add(new Thread(() -> {
                for (int x = 0; x < 1000000; x++) {
                    num.incrementAndGet();
                    number++;
                }
            }));
        }
        for (Thread t : list) {
            t.start();
        }

        Thread.sleep(1000L);
        System.out.println(num);
        System.out.println(number);

        calendarTest();
    }

    public static void calendarTest(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(cal.getTime());
        System.out.println("第一次回退版本");
    }
}
