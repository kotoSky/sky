package com.sky.learn.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class KafkaController {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 简单类型
     *
     * @param msg
     * @return
     */
    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    public String send(@PathVariable("msg") String msg) {
        for (int i = 0; i < 10; i++) {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("test", msg + i);//使用kafka模板发送信息
            future.addCallback(
                    result -> System.out.println("消息发送成功" + msg),
                    throwable -> System.out.println("消息发送失败")
            );
        }
        return "success";
    }

    @KafkaListener(topics = "test")
    public void listen(ProducerRecord<?, ?> record) {
        System.out.printf("topice：" + record.topic().toString() + "partition：" + record.partition().toString() + "val" + record.value().toString());
    }

}