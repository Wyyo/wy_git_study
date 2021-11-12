package com.qs.controller;

import com.qs.javabean.PageData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;

public class LambdaTestController {
    public static void main(String[] args) {
         List<PageData> page = Arrays.asList(
                 new PageData(1, "张三"),
                 new PageData(2, "李四"),
                 new PageData(3, "王五")
         );
         String a = "a";
         final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        System.out.println("df.get()===" + df.get());
        //TemporalAdjusters：时间校正器
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        //指定日期时间中的 年 月 日 ...
        LocalDateTime ldt2 = ldt1.withDayOfMonth(11);
        System.out.println(ldt2);
        //指定时间校正器
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);
    }
}
