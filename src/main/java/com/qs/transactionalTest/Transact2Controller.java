package com.qs.transactionalTest;

import com.qs.javabean.PageData;
import com.qs.mapper.ProductMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("transact2")
public class Transact2Controller {

    @Autowired
    private ProductMapper mapper;
    int num1;
    PageData pageData2 = new PageData();
    PageData pageData = new PageData();

    @GetMapping("/print")
    public void print() {
        System.out.println("num1=" + num1);
        System.out.println("pageData2" + pageData2);
        System.out.println("pageData=" + pageData);
    }

//    本类有事务
    @GetMapping("/test1")
    @Transactional(rollbackFor = Exception.class)
    public void test1() {
        transac();
    }

//    其他类有事务
    @GetMapping("/test2")
    @Transactional(rollbackFor = Exception.class)
    public void test2() {
        System.out.println("in");
        System.out.println("==========pageData2==========" + pageData2);
        Transact1Controller transact1 = new Transact1Controller();
        transact1.transac(mapper);
    }

    //    其他类没有事务
    @GetMapping("/test3")
    public void test3() {
        System.out.println("in");
        System.out.println("==========pageData==========" + pageData);
        Transact1Controller transact1 = new Transact1Controller();
        transact1.no_transac(mapper);
    }

    @Transactional(rollbackFor = Exception.class)
    public void transac() {
        try {
            Map<String, Object> mapVal = new HashMap<>();
            mapVal.put("mapId","5555555");
            mapVal.put("mapName", "没事务");
            mapVal.put("mapPri", 1111.22);
            int i = mapper.insertProduct(mapVal);
            System.out.println("===i=" + i);
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("函数执行有异常!");
        }
    }
}
