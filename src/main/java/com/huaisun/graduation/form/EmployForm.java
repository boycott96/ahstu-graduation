package com.huaisun.graduation.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huaisun
 * @date 2019/2/22 18:27
 */

@ApiModel
@Data
public class EmployForm {

    private Integer id;

    private String email;

    private String name;

    private String password;

    private String phone;

    private String address;
}
