package com.niu.consumer;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ami on 2018/5/20.
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.info}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchage}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}"
)
)
public class InfoConsumer {
    public void process(String msg){
        System.out.println("reciever:"+msg);
    }
}