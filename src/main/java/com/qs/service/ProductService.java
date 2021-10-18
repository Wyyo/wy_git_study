package com.qs.service;

import com.qs.javabean.Product;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getList();
    int insertProduct(Map<String, Object> mapVal);
    List<Product> fenye(Map<String,Object> condition);
}
