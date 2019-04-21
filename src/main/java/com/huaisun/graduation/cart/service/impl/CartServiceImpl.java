package com.huaisun.graduation.cart.service.impl;

import com.huaisun.graduation.auto.dao.TCart;
import com.huaisun.graduation.auto.dao.TCartExample;
import com.huaisun.graduation.auto.dao.TCartKey;
import com.huaisun.graduation.auto.mapper.TCartMapper;
import com.huaisun.graduation.cart.entity.CartAndMilkEntity;
import com.huaisun.graduation.cart.form.CartForm;
import com.huaisun.graduation.cart.mapper.CartMapper;
import com.huaisun.graduation.cart.service.CartService;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunruiguang
 * @date 2019/4/10
 * Updated by sunruiguang on 2019/4/10.
 */
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private TCartMapper tCartMapper;

    @Resource
    private CartMapper cartMapper;

    @Override
    public Result addCart(CartForm form) {
        if (Tools.isEmpty(form.getMId()) || Tools.isEmpty(form.getKind())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }
        TCartKey tCartKey = new TCartKey();
        tCartKey.setmId(form.getMId());
        tCartKey.setKind(form.getKind());

        TCart tCart = tCartMapper.selectByPrimaryKey(tCartKey);
        if (Tools.isEmpty(tCart)) {
            tCart = new TCart();
            tCart.setmId(form.getMId());
            tCart.setNumber(form.getNumber());
            tCart.setKind(form.getKind());
            return tCartMapper.insert(tCart) > 0 ? Result.success() : Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        tCart.setNumber(tCart.getNumber() + form.getNumber());
        return tCartMapper.updateByPrimaryKey(tCart) > 0 ? Result.success() : Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }

    @Override
    public Result getCart() {
        TCartExample example = new TCartExample();
        Long number = tCartMapper.countByExample(example);
        return Result.success(number);
    }

    @Override
    public Result getDetailCart() {
        List<CartAndMilkEntity> cartAndMilkEntities = cartMapper.queryDetailCart();
        return Result.success(cartAndMilkEntities);
    }

    @Override
    public Result deleteCart(CartForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getMId()) || Tools.isEmpty(form.getKind())) {
            TCartExample example = new TCartExample();
            return tCartMapper.deleteByExample(example) > 0 ? Result.success() : Result.failure(ResultCode.CART_DELETE_ERROR);
        }
        TCartKey key = new TCartKey();
        key.setKind(form.getKind());
        key.setmId(form.getMId());
        return tCartMapper.deleteByPrimaryKey(key) > 0 ? Result.success(): Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }
}
