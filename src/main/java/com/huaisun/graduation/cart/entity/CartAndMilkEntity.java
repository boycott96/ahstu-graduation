package com.huaisun.graduation.cart.entity;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartAndMilkEntity extends TMilkMenu {

    private String kind;

    private Integer number;
}
