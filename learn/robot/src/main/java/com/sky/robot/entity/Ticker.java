package com.sky.robot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Ticker {
    private String symbol; //交易对
    private BigDecimal tradePrice; //最新成交价格
    private BigDecimal tradeSize; //最新成交数量
    private BigDecimal askPrice; //卖-价格
    private BigDecimal askSize;//卖-数量
    private BigDecimal bidPrice;//买-价格
    private BigDecimal bidSize;//买-数量

    private List<ExchangeOrder> bids;
    private List<ExchangeOrder> asks;
}