package com.huaisun.graduation.constants;

/**
 * @author huaisun
 * @date 2019/2/22 19:15
 */
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误：20001-29999*/
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_HAS_EXISTED(20002, "用户已存在"),
    USER_SAVE_ERROR(20003, "用户注册失败"),
    USER_UPDATE_ERROR(20004, "用户更新失败"),
    USER_DELETE_ERROR(20005, "用户删除失败"),
    USER_BALANCE_ERROR(20006, "用户余额不足,请充值"),

    /* 员工错误：30001-39999*/
    EMPLOY_NOT_LOGGED_IN(30001, "员工未登录"),
    EMPLOY_NOT_DELETE_ADMIN(30001, "管理员账号无法删除"),
    EMPLOY_LOGIN_ERROR(30002, "账号不存在或密码错误"),
    EMPLOY_ACCOUNT_FORBIDDEN(30003, "账号已被禁用"),
    EMPLOY_NOT_EXIST(30004, "员工不存在"),
    EMPLOY_HAS_EXISTED(30005, "员工已存在"),
    EMPLOY_SAVE_ERROR(30006, "员工注册失败"),
    EMPLOY_UPDATE_ERROR(30007, "员工更新失败"),
    EMPLOY_DELETE_ERROR(30008, "员工删除失败"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),

    /* 注册错误：80001-89999 */
    SIGN_SAME_NAME(80001, "姓名重复"),
    SIGN_SAME_EMAIL(80001, "邮箱已注册"),
    SIGN_SAME_PHONE(80001, "手机号已注册"),

    /* 注册错误：90001-99999 */
    ORDER_NOT_EXIST(90001, "订单不存在"),

    /* 奶茶错误: 100001-109999 */
    MILK_DELETE_ERROR(100001, "奶茶删除失败"),

    /* 文件上传错误：110001-119999*/
    FILE_UPLOAD_ERROR(110001, "文件上传失败"),

    CART_DELETE_ERROR(120001, "购物车为空");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {

        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
