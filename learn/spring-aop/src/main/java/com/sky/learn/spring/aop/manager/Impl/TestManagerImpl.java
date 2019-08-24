package com.sky.learn.spring.aop.manager.Impl;

import com.sky.learn.spring.aop.manager.ITestManager;
import org.springframework.stereotype.Service;

/**
 * @Auther: HJH
 * @Date: 2019/8/24
 * @Description: TODO
 */
@Service
public class TestManagerImpl implements ITestManager {
    @Override
    public void share(String articleUrl) {
        System.out.println(articleUrl);
    }
}
