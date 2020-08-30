package com.xsz.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 爽
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    private void input(Message<String> message){
        System.out.println("消费者二号--------------------->"+message.getPayload()+"...port:"+serverPort);
    }
}