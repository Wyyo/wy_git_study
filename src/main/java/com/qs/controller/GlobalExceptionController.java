package com.qs.controller;

import com.google.common.collect.Lists;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GlobalExceptionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

    public static void main(String[] args) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error(() -> e.getMessage() + "========================");
            System.out.println("iiii");
        }


    }
    @GetMapping("exception")
    public String exceptionController(){
//        System.out.println("innnn");
        int b = 10 / 0;
//        try{
//            int a = 1/0;
//        }catch (Exception e){
//            e.printStackTrace();
//            LOGGER.error(()->e.getMessage()+"========================");
////            throw e;
//        }
        return "~~~~~";
    }

    @GetMapping("arrayOutOfRange")
    public void arrayOutOfRangeExceptionController() {
        List<String> list = Lists.newArrayList("a", "b", "v");
        System.out.println(list);
        System.out.println(list.get(4));

    }
}
