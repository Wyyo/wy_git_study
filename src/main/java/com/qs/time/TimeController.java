package com.qs.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeController {
    private static String formatString = "yyyyMMddHHmm";
    private static DateTimeFormatter format = DateTimeFormat.forPattern(formatString);
    public static void main(String[] args) {
//        DateTime statisMinDt = format.parseDateTime("202111050850"); // 统计分钟作为终止时间
//        System.out.println("statisMinDt==" + statisMinDt);
//        System.out.println("statisMinDt.minusDays(1)==" + statisMinDt.minusDays(1));
//        System.out.println("statisMinDt.withHourOfDay(0)==" + statisMinDt.withHourOfDay(0));
//        System.out.println("statisMinDt.minusDays(1).withHourOfDay(0)==" + statisMinDt.minusDays(1).withHourOfDay(0));
//        DateTime cursorDt = statisMinDt.minusDays(1).withHourOfDay(0).withMinuteOfHour(0); // 从昨日0点开始
//        System.out.println("cursorDt==" + cursorDt);

        test();
    }

    public static void test() {
//        String formatString = "yyyyMMddHHmmss";
//        DateTimeFormatter format = DateTimeFormat.forPattern(formatString);
//        DateTime dateTime = format.parseDateTime("202111050850");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
        String format1 = dateFormat.format(new Date());
        System.out.println("format1==" + format1);
        System.out.println("data==" + new Date());
    }
}
