package com.ah.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {

    public static String handlerException1(BlockException blockException){
        return "handlerException 1号进行兜底";
    }

    public static String handlerException2(BlockException blockException){
        return "handlerException 2号进行兜底";
    }
}
