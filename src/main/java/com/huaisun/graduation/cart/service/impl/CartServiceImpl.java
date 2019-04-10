package com.huaisun.graduation.cart.service.impl;

import com.huaisun.graduation.auto.dao.TCart;
import com.huaisun.graduation.auto.mapper.TCartMapper;
import com.huaisun.graduation.cart.form.CartForm;
import com.huaisun.graduation.cart.service.CartService;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunruiguang
 * @date 2019/4/10
 * Updated by sunruiguang on 2019/4/10.
 */
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private TCartMapper tCartMapper;

    @Override
    public Result addCart(CartForm form) {

        TCart tCart = new TCart();
        if (Tools.isNotEmpty(form.getMId())) {
            tCart.setmId(form.getMId());
        }
        if (Tools.isNotEmpty(form.getUId())) {
            tCart.setuId(form.getUId());
        }
        if (Tools.isNotEmpty(tCartMapper.selectByPrimaryKey(tCart))) {
            return Result.failure(ResultCode.DATA_ALREADY_EXISTED);
        }
        if (Tools.isNotEmpty(form.getNumber())) {
            tCart.setNumber(form.getNumber());
        }
        if (tCartMapper.insert(tCart) == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }
}
