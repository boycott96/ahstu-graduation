package com.huaisun.graduation.order.entity;

import com.huaisun.graduation.auto.dao.TOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 返回订单实体
 *
 * @author huaisun
 * @date 2019/3/11 12:57
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class OrderEntity extends TOrder {

    @ApiModelProperty(value = "员工姓名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "详情", dataType = "List")
    private List<DetailOrder> details;
}

