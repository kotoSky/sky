package com.sky.robot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sky.robot.entity.ExchangeOrder;
import com.sky.robot.utils.HttpUtil;
import com.sky.robot.utils.HttpsUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RobotService {

    String AccessKey = "mjlpdje3ld-6ce18b06-5b4e4d88-e240b";

    String SecretKey = "101dbdb9-035c3716-4b470a0c-61fe8";

    public static List<ExchangeOrder> bids = new ArrayList<>();

    public static List<ExchangeOrder> asks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // 火币
        //String hbTicker = HttpUtil.get("https://api.huobi.pro/market/tickers","UTF-8");
        //String hbDepth = HttpsUtil.doGet("https://api.huobi.pro/market/depth?symbol=BTC_USDT&depth=20&type=step0");
        //System.out.println(hbDepth);

        // 中币
        //String zbTicker = HttpUtil.get("http://api.zb.live/data/v1/ticker?market=btc_usdt","UTF-8");
        String zbDepth = HttpUtil.get("http://api.zb.live/data/v1/depth?market=btc_usdt&size=5", "UTF-8");
        //System.out.println(zbTicker);
        System.out.println(zbDepth);

        getSum(zbDepth);

        // okex
        //String okexTicker = HttpUtil.get("https://www.okex.me/api/spot/v3/instruments/BTC-USDT/ticker","UTF-8");
        String okexDepth = HttpsUtil.doGet("https://www.okex.me/api/spot/v3/instruments/BTC-USDT/book?size=5&depth=0.2");
        //System.out.println(okexTicker);
        System.out.println(okexDepth);

        getSum(okexDepth);

        // binance
        //String binanceTicker = HttpUtil.get("https://www.binancezh.com/api/v3/ticker/bookTicker?symbol=BTCUSDT","UTF-8");
        String binanceDepth = HttpsUtil.doGet("https://www.binancezh.com/api/v3/depth?symbol=BTCUSDT&limit=5");
        //System.out.println(binanceTicker);
        System.out.println(binanceDepth);

        getSum(binanceDepth);


        bids.sort(Comparator.comparing(ExchangeOrder::getPrice).reversed());
        asks.sort(Comparator.comparing(ExchangeOrder::getPrice));

        System.out.println("1");

    }

    private static void getSum(String depth) {

        JSONObject depthObj = JSON.parseObject(depth);
        List<JSONArray> bidsArray = JSON.parseArray(depthObj.getString("bids"), JSONArray.class);
        List<JSONArray> asksArray = JSON.parseArray(depthObj.getString("asks"), JSONArray.class);

        bidsArray.stream().forEach(bid -> {
            ExchangeOrder order = new ExchangeOrder();
            order.setPrice(new BigDecimal(bid.get(0).toString()));
            order.setAmount(new BigDecimal(bid.get(1).toString()));
            order.setDirection("BUY");
            order.setType("LIMIT_PRICE");
            order.setTradedAmount(BigDecimal.ZERO);
            bids.add(order);
        });

        asksArray.stream().forEach(ask -> {
            ExchangeOrder order = new ExchangeOrder();
            order.setPrice(new BigDecimal(ask.get(0).toString()));
            order.setAmount(new BigDecimal(ask.get(1).toString()));
            order.setDirection("SELL");
            order.setType("LIMIT_PRICE");
            order.setTradedAmount(BigDecimal.ZERO);
            asks.add(order);
        });

    }

}
