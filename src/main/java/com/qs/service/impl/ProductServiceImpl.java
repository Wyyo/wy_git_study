package com.qs.service.impl;

import com.qs.javabean.Product;
import com.qs.mapper.ProductMapper;
import com.qs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> getList() {
        List<Product> list = mapper.getList();
        return list;
    }

    @Override
    public List<Product> getList2(int pid) {
        List<Product> list = mapper.getList2(pid);
        return list;
    }

    @Override
    public int insertProduct(Map<String, Object> mapVal) {
        int insertProduct = mapper.insertProduct(mapVal);
        return insertProduct;
    }

    @Override
    public List<Product> fenye(Map<String, Object> condition) {
        return mapper.fenye(condition);
    }
}
