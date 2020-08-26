package com.xsz.springcloud.service.impl;

import com.xsz.springcloud.service.MessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderService {

    //定义消息的推送通道
    @Resource
    private MessageChannel output;

    /**
     * 发送消息
     *
     * @return
     */
    @Override
    public String send() {
        String id= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(id).build());
        return id;
    }
}
