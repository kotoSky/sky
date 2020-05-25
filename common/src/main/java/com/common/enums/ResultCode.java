package com.common.enums;


import lombok.Getter;

@Getter
public enum ResultCode {

    success(200,"操作成功"),
    error(400,"操作失敗");

    // 响应状态码
    private Integer code;
    // 响应信息
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
