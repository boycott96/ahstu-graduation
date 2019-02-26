package com.huaisun.graduation.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huaisun
 * @date 2019/2/22 18:27
 */

@ApiModel
@Data
public class EmployForm {

    @ApiModelProperty(value = "员工id", dataType = "Integer")
    private Integer id;

    @ApiModelProperty(value = "邮箱", dataType = "String")
    private String email;

    @ApiModelProperty(value = "员工姓名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "员工密码", dataType = "String")
    private String password;

    @ApiModelProperty(value = "手机号码", dataType = "String")
    private String phone;

    @ApiModelProperty(value = "地址", dataType = "String")
    private String address;
}
