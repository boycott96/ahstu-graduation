package com.huaisun.graduation.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huaisun
 * @date 2019/2/26 12:33
 */
@ApiModel
@Data
public class OrderForm {

    @ApiModelProperty(value = "用户Id", dataType = "Integer")
    private Integer uId;

    @ApiModelProperty(value = "是否有日期限制", dataType = "String", allowableValues = "1,0")
    private String isDate;

    @ApiModelProperty(value = "订单方式", dataType = "String")
    private String mode;

    @ApiModelProperty(value = "订单是否有效", dataType = "String")
    private String valid;
}
