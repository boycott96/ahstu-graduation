package com.huaisun.graduation.user.form;

import com.huaisun.graduation.common.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huaisun
 * @date 2019/2/25 15:38
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class UserForm extends PageForm {

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
}
