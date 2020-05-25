package com.sky.application.light.controller;

import com.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HJH
 * @Date: 2019/8/23
 * @Description: TODO
 */

@RestController
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping(path = "/success", method = RequestMethod.GET)
    Result success() {
        return Result.success().data("请求成功咯！").isSuccess(false);
    }
}
