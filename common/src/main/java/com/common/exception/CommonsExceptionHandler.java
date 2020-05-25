package com.common.exception;

import com.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kell
 * @date 2020-05-23 16:05
 * 统一异常处理
 */

@ControllerAdvice
public class CommonsExceptionHandler {

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
