package com.qs.javabean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "产品", description = "查询产品")
public class Product {
    @ApiModelProperty(value = "产品id")
    private String pid;
    @ApiModelProperty(value = "产品名称")
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
