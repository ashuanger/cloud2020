package com.xsz.springcloud.controller;

import com.xsz.springcloud.service.MessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 爽
 */
@RestController
public class MessageProviderController {

    @Resource
    private MessageProviderService messageProviderService;


    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProviderService.send();
    }
}
