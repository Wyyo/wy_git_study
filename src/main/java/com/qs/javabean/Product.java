package com.qs.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String pid;
    private String pname;
    private String pimage;
    private String pdate;
    private String pdesc;
    private String cid;
    private Integer is_hot;
    private Integer pflag;
    private Double market_price;
    private Double shop_price;
}
