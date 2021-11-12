package com.qs.controller;

import com.exception.DataFormatError;

import java.util.HashMap;
import java.util.Map;

public class ExceptionTestController {
    public static void main(String[] args){
        try {
            String name = "";
            errorTest(name);
        } catch (DataFormatError dataFormatError) {
            Map<String, String> result = new HashMap<>();
            result.put("code" , "500");
            result.put("data" , dataFormatError.getMessage());
            System.out.println(result);
        }
    }
    public static void errorTest(String str) throws DataFormatError {
       if(str == "") {
           throw new DataFormatError("入参不能为空!");
       }
    }

}
