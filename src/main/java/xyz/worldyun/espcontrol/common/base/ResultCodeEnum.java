package xyz.worldyun.espcontrol.common.base;

import lombok.Getter;
import lombok.ToString;

/**
 * @author WorldYun
 * @since 2020/06/29
 */
@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),

    PARAM_ERROR(false, 21001, "参数不正确"),

    LOGIN_ERROR(false, 22001,"登录失败"),
    LOGIN_USERNAME_OR_PASSWORD_ERROR(false, 22002, "用户名或密码错误"),
    PASSWORD_ERROR(false, 22003, "密码错误"),
    LOGIN_AUTH(false, 22004, "需要登录"),
    SIGN_UP_USERNAME_USED(false, 22005, "用户已存在"),
    SIGN_UP_ERROR(false, 22006, "注册失败"),
    NO_PERMISSION(false, 22007, "没有权限"),

    CODE_ERROR(false, 23001, "验证码错误"),

    BUTTON_NO_RAW(false, 24001, "按钮尚未学习"),
    NO_DEVICE(false, 24002, "设备不存在"),
    DEVICE_ALREADY_EXISTS(false, 24003, "设备已存在");




    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}