package com.common.result;

import com.common.enums.ResultCode;
import lombok.Data;

@Data
public class Result {

    private Boolean success = Boolean.TRUE;

    private Integer code;

    private String msg;

    private Object data;

    // 构造器私有
    private Result() {
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.success.getCode());
        result.setMsg(ResultCode.success.getMsg());
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(Boolean.FALSE);
        result.setCode(ResultCode.error.getCode());
        result.setMsg(ResultCode.error.getMsg());
        return result;
    }

    /**
     * 使用链式编程，返回类本身
     **/

    // 自定义返回数据
    public Result data(Object obj) {
        this.setData(obj);
        return this;
    }

    // 自定义状态
    public Result status(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    // 自定义状态信息
    public Result msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    // 自定义状态码
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public Result isSuccess(Boolean success) {
        this.setSuccess(success);
        return this;
    }

}
