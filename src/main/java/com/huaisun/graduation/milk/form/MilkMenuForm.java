package com.huaisun.graduation.milk.form;

import com.huaisun.graduation.common.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sunruiguang
 * @date 2019/3/20
 * Updated by sunruiguang on 2019/3/20.
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class MilkMenuForm extends PageForm {

    @ApiModelProperty(value = "奶茶id", dataType = "String")
    private Integer id;

    @ApiModelProperty(value = "奶茶名", dataType = "String")
    private String milkName;

    @ApiModelProperty(value = "奶茶详情", dataType = "String")
    private String milkDetail;

    @ApiModelProperty(value = "奶茶图片地址", dataType = "String")
    private String milkPhoto;

    @ApiModelProperty(value = "奶茶是否上架", dataType = "Integer")
    private Integer shelf;

    @ApiModelProperty(value = "奶茶价格", dataType = "BigDecimal")
    private BigDecimal milkPrice;

    @ApiModelProperty(value = "奶茶图片", dataType = "MultipartFile")
    private MultipartFile file;

}
