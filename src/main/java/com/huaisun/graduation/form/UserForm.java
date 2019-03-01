package com.huaisun.graduation.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huaisun
 * @date 2019/2/25 15:38
 */
@ApiModel
@Data
public class UserForm {

    @ApiModelProperty(value = "用户id", dataType = "Integer")
    private Integer id;

    @ApiModelProperty(value = "用户名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "邮箱", dataType = "String")
    private String email;

    @ApiModelProperty(value = "手机号码", dataType = "String")
    private String phone;

    @ApiModelProperty(value = "积分", dataType = "Integer")
    private Integer integral;

    @ApiModelProperty(value = "余额", dataType = "Float")
    private Float balance;

    @ApiModelProperty(value = "消费总额", dataType = "Float")
    private Float cost;

    @ApiModelProperty(value = "是否有日期限制", dataType = "String", allowableValues = "1,0")
    private String isDate;
}
