package role.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huaisun
 * @date 2019/2/26 12:33
 */
@ApiModel
@Data
public class OrderForm {

    @ApiModelProperty(value = "用户姓名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "订单id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "是否有日期限制", dataType = "String", allowableValues = "1,0")
    private String isDate;

    @ApiModelProperty(value = "订单方式", dataType = "String")
    private String mode;
}
