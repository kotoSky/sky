/*
package com.sky.robot.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AfterServiceStarted implements ApplicationRunner {

    */
/**
     * 会在服务启动完成后立即执行
     *//*

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //List<ExchangeCoin> coins = ExchangeUtils.findExchangeCoins();
        Map<String,Integer> map = RobotOrderRunnable.robotStatusMap;
        coins.stream().forEach(coin -> {
            if(coin.getRobotStatus()!=null&&coin.getRobotStatus()==1){
                map.put(coin.getSymbol(),coin.getRobotStatus());
                exchangeOrderService.robotAddOrder(coin.getSymbol());
                RobotOrderRunnable.robotStatusMap=map;
            }else{
                coin.setRobotStatus(0);
                map.put(coin.getSymbol(),coin.getRobotStatus());
                RobotOrderRunnable.robotStatusMap=map;
            }
        });
    }
}*/
