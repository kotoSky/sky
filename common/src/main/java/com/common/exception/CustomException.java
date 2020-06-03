package com.common.exception;

import com.common.enums.ResultCode;
import lombok.Data;

/**
 * @author kell
 * @date 2020-05-23 16:05
 * 统一异常处理
 */

@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCode resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }

}
