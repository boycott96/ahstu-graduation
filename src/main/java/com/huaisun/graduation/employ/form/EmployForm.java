package com.huaisun.graduation.employ.form;

import com.huaisun.graduation.common.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huaisun
 * @date 2019/2/22 18:27
 */

@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class EmployForm extends PageForm {

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

    @ApiModelProperty(value = "启用状态", dataType = "Integer")
    private Integer valid;
}
