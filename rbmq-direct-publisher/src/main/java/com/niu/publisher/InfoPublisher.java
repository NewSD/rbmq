package com.niu.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ami on 2018/5/20.
 */
@Component
public class InfoPublisher {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Value("${mq.config.exchage}")
    private String exchange;

    public void send()throws InterruptedException{
        String msg="hello"+new Date();
        this.rabbitTemplate.convertAndSend(this.exchange,"log.info.routing.key",msg);
    }
}

