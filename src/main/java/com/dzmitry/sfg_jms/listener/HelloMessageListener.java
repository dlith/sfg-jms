package com.dzmitry.sfg_jms.listener;

import com.dzmitry.sfg_jms.config.JmsConfig;
import com.dzmitry.sfg_jms.model.HelloWorldMessage;
import javax.jms.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){
        log.info("I Got a Message!!!");
        log.info(helloWorldMessage.toString());
    }
}
