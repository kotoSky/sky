package com.sky.application.light;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: HJH
 * @Date: 2019/8/23
 * @Description: TODO
 */

@SpringBootApplication
@EnableAspectJAutoProxy
public class LightConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(LightConfiguration.class, args);
    }
}
