package com.sky.robot.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeOrder {

    /**
     * 挂单类型
     */
    private String type;

    /**
     * 挂单价格
     */
    private BigDecimal price = BigDecimal.ZERO;

    /**
     * 买入或卖出量，对于市价买入单表
     */
    private BigDecimal amount = BigDecimal.ZERO;

    /**
     * 订单方向
     */
    private String direction;

    /**
     * 成交量
     */
    private BigDecimal tradedAmount = BigDecimal.ZERO;



}
