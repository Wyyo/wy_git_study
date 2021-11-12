package com.qs.service.impl;

import com.qs.javabean.PageData;
import com.qs.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    /**
     * 测试POI导出用户列表来
     * @return
     */
    public List<PageData> serviceList() {
        List<PageData> list = new ArrayList<>();
        PageData data = new PageData();
        data.setId(1);
        data.setUsername("张三");
//        data.setPassword("123456");
//        data.setPhone("123");
//        data.setCreateTime(new Date());
//        list.add(data);
        data.setId(2);
        data.setUsername("李四");
//        data.setPassword("223456");
//        data.setPhone("456");
//        data.setCreateTime(new Date());
        list.add(data);
        return list;
    }
}
