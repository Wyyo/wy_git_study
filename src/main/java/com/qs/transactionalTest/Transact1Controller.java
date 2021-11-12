package com.qs.transactionalTest;

import com.qs.javabean.PageData;
import com.qs.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
@Controller
public class Transact1Controller {

    @Transactional(rollbackFor = Exception.class)
    public void transac(ProductMapper mapper) {
        try {
            Map<String, Object> mapVal = new HashMap<>();
            mapVal.put("mapId","9999999999");
            mapVal.put("mapName", "事务");
            mapVal.put("mapPri", 1111.22);
            int i2 = mapper.insertProduct(mapVal);
            System.out.println("====i=" + i2);
            String string  = null;
            if(string.equals("")) {
                int i = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("函数执行有异常!");
        }
    }

    public void no_transac(ProductMapper mapper) {
        try {
            Map<String, Object> mapVal = new HashMap<>();
            mapVal.put("mapId","888888888");
            mapVal.put("mapName", "没事务");
            mapVal.put("mapPri", 1111.22);
            int i3 = mapper.insertProduct(mapVal);
            System.out.println("====i=" + i3);
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException("函数执行有异常!");
        }
    }
}
