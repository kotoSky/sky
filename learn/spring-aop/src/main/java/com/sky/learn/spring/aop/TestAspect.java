package com.sky.learn.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 面向切面编程（也叫面向方面编程），是目前软件开发中的一个热点，也是Spring框架中的一个重要内容。
 * 利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
 */
@Aspect //将其标记为一个切面
@Component //将其标记为一个 Bean
public class TestAspect {

    // 定义切点： target目标和execution执行方法不为false则切入
    @Pointcut("target(com.sky.learn.spring.aop.manager.Impl.TestManagerImpl)" + "&& execution(* share(String))")
    public void shareCut() {

    }

    /*
     *   执行顺序：
     *   around > before > around > after > afterReturning
     * */

    // around(环绕通知)： 在方法执行前和执行后都会执行
    @Before("shareCut()")
    public void around(JoinPoint joinPoint) {
        System.out.println("around(环绕通知)： 在方法执行前和执行后都会执行");
    }

    // before(前置通知)： 在方法开始执行前执行
    @Before("shareCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before(前置通知)： 在方法开始执行前执行");
    }

    // after(后置通知)： 在方法执行后执行
    @After("shareCut()")
    public void after() {
        System.out.println("after(后置通知)： 在方法执行后执行");
    }

    // afterReturning(返回后通知)： 在方法返回后执行
    @AfterReturning("shareCut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " afterReturning(返回后通知)： 在方法返回后执行");
    }

    // afterThrowing(异常通知)： 在抛出异常时执行
    @AfterReturning("shareCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("afterThrowing(异常通知)： 在抛出异常时执行");
    }

}