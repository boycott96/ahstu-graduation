package com.huaisun.graduation.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sunruiguang
 * @date 2019/3/20
 * Updated by sunruiguang on 2019/3/20.
 */
@ApiModel
@Data
public class MilkMenuForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "奶茶id", dataType = "Integer")
    private Integer id;

    @ApiModelProperty(value = "奶茶名", dataType = "String")
    private String milkName;

    @ApiModelProperty(value = "奶茶价格", dataType = "BigDecimal")
    private BigDecimal milkPrice;

    @ApiModelProperty(value = "图片地址", dataType = "String")
    private String milkAddress;

    @ApiModelProperty(value = "下架", dataType = "Integer", allowableValues = "0,1")
    private Integer isShelf;

    @ApiModelProperty(value = "图片", dataType = "MultipartFile")
    private MultipartFile milkImg;
}