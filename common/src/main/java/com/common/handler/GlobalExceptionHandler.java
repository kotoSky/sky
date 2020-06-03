package com.common.handler;

import com.common.enums.ResultCode;
import com.common.exception.CustomException;
import com.common.util.ExceptionUtil;
import com.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kell
 * @date 2020-05-31 11:56
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**-- 通用异常处理方法 --**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error();	// 通用异常结果
    }

    /**-- 指定异常处理方法 --**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().status(ResultCode.NULL_POINTER);
    }

    /**-- 自定义定异常处理方法 --**/
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result error(CustomException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().msg(e.getMessage()).code(e.getCode());
    }

    // 处理ajax请求的
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        System.out.println("出错啦：" + e.getMessage());
        // 判断是同步请求还是ajax请求
        String header = request.getHeader("X-Requested-With");
        if (header != null && header.equals("XMLHttpRequest")) {
            return Result.error().msg("服务器繁忙！");
        } else {
            // 跳转错误页面
            return new ModelAndView("error/sorry");
        }
    }

}
