package com.sky.learn.spring.aop.controller;

import com.sky.learn.spring.aop.manager.ITestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: HJH
 * @Date: 2019/8/24
 * @Description: TODO
 */
@Controller
@RequestMapping(path = "/spring")
public class SpringAopController {

    @Autowired
    private ITestManager testManager;

    @RequestMapping(value = "/aop", method = RequestMethod.GET)
    public void aop() {
        testManager.share("www.baidu.com");
    }
}
