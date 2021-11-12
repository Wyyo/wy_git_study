package com.qs.mapper;

import com.qs.javabean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Mapper
public interface ProductMapper {
    List<Product> getList();
    List<Product> getList2(int pid);
    int insertProduct(Map<String, Object> mapVal);
    List<Product> fenye(Map<String, Object> condition);
}
