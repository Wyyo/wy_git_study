package com.qs.service;

import com.qs.javabean.PageData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 测试POI导出用户列表来
     * @return
     */
    public List<PageData> serviceList();
}
