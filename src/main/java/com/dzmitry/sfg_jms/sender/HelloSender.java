package com.dzmitry.sfg_jms.sender;

import com.dzmitry.sfg_jms.config.JmsConfig;
import com.dzmitry.sfg_jms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        log.info("I'm sending a message!");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello world!")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
        log.info("Message sent!");
    }
}
