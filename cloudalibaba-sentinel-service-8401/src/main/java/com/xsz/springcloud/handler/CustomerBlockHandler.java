package com.xsz.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;

public class CustomerBlockHandler {

    public static BaseResult handlerException(BlockException exception){

        return Rsp.err("global handlerException------1",null);
    }

    public static BaseResult handlerException2(BlockException exception){

        return Rsp.err("global handlerException------2",null);
    }
}
