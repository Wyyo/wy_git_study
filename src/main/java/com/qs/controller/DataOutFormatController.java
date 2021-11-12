package com.qs.controller;

import com.qs.javabean.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class DataOutFormatController {
    List<PageData> pageDataList = Arrays.asList(new PageData(1, "张三"), new PageData(2, "李四"), new PageData(3, "王五"));

    @GetMapping("/dataformat")
    public List<PageData> main(String[] args, HttpServletResponse response) {
        Map<String, List<PageData>> mapList = new HashMap<>();
        mapList.put("first", pageDataList);
        mapList.put("second", pageDataList);
        System.out.println("mapList==" + mapList);
        System.out.println("pageDataList==" + pageDataList);
        return pageDataList;
    }

    @GetMapping("/String")
    public Set<String> main() {
        Set<String> strings = new HashSet<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        System.out.println("strings==" + strings);
        return strings;
    }

    @GetMapping("/setEmpty")
    public Set<PageData> setTest() {
        Set<PageData> pageDataListSet = new TreeSet<>();
        pageDataListSet.add(new PageData(1, "张三"));
        pageDataListSet.add(new PageData(2, "李四"));
        pageDataListSet.add(new PageData(3, "王五"));
        System.out.println(pageDataListSet);
        return pageDataListSet;
    }

    @GetMapping("/setMap")
    public Map<String,Set<PageData>> setTest2() {
        Map<String,Set<PageData>> setMap = new HashMap<>();
        Set<PageData> pageDataListSet = new TreeSet<>();
        pageDataListSet.add(new PageData(1, "张三"));
        System.out.println("50---" + pageDataListSet);
        pageDataListSet.add(new PageData(2, "李四"));
        System.out.println("51---" + pageDataListSet);
        pageDataListSet.add(new PageData(3, "王五"));
        setMap.put("a", pageDataListSet);
        pageDataListSet.add(new PageData(4, "赵柳"));
        setMap.put("b", pageDataListSet);
        setMap.put("c", pageDataListSet);
        System.out.println("setMap==" + setMap);
        return setMap;
    }
//-------------------
    @GetMapping("/mapInMap")
    public Map<String,Map<String, Set<PageData>>> setTest3() {
        Map<String,Map<String, Set<PageData>>> mapInMap = new HashMap<>();
        Map<String,Set<PageData>> setMap = new HashMap<>();
        Set<PageData> pageDataListSet = new TreeSet<>();
        pageDataListSet.add(new PageData(1, "张三"));
        pageDataListSet.add(new PageData(2, "李四"));
        pageDataListSet.add(new PageData(3, "王五"));
        setMap.put("a", pageDataListSet);
        pageDataListSet.add(new PageData(4, "赵柳"));
        setMap.put("b", pageDataListSet);
        setMap.put("c", pageDataListSet);
        mapInMap.put("1", setMap);
        mapInMap.put("2", setMap);
        mapInMap.put("3", setMap);
        System.out.println("mapInMap==" + mapInMap);
        return mapInMap;
    }

    @GetMapping("/mapInMap_string")
    public Map<String,Map<String, String>> setTest4() {
        Map<String,Map<String, String>> mapInMap_string = new HashMap<>();
        Map<String,String> setMap = new HashMap<>();
        setMap.put("b", "张三");
        setMap.put("c", "李四");
        setMap.put("c", "王五");
        mapInMap_string.put("1", setMap);
        mapInMap_string.put("2", setMap);
        mapInMap_string.put("3", setMap);
        System.out.println("mapInMap_string==" + mapInMap_string);
        return mapInMap_string;
    }

    @GetMapping("mapIn")
    public Map<String,Set<PageData>> mapIn(@RequestBody Map<String,Set<PageData>> in) {
        System.out.println("in==" + in);

//        List<String> list = new ArrayList<>();
//        list.get(1);
        return in;
    }

}
