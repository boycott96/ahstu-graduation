package com.huaisun.graduation.order.form;

import com.huaisun.graduation.common.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huaisun
 * @date 2019/2/26 12:33
 */
@ApiModel
@Data
public class OrderForm extends PageForm {

    @ApiModelProperty(value = "用户姓名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "订单id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "用户id", dataType = "Integer")
    private Integer uId;

    @ApiModelProperty(value = "详情", dataType = "List")
    private List<OrderDetailForm> orderDetail;

    @ApiModelProperty(value = "有效", dataType = "Integer")
    private Integer valid;

    @ApiModelProperty(value = "总费用", dataType = "BigDecimal")
    private BigDecimal cost;
}
