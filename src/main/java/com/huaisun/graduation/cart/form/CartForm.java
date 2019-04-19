package com.huaisun.graduation.cart.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author sunruiguang
 * @date 2019/4/10
 * Updated by sunruiguang on 2019/4/10.
 */
@ApiModel
@Data
public class CartForm {
    /**
     * 商品id
     */
    private Integer mId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 品种
     */
    private String kind;
}
