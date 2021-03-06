package com.ah.springcloud.controller;

import com.ah.springcloud.handler.MyBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        return "A请求测试通过...";
    }

    @GetMapping("/testB")
    public String testB(){
        return "B请求测试通过...";
    }

    @GetMapping("/testC")
    public String testC(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "RT测试通过...";
    }

    @GetMapping("/testD")
    public String testD(){
        System.out.println("异常比例测试");
        int a= 10/0;
        return "异常比例测试通过...";
    }

    @GetMapping("/testE")
    public String testE(){
        System.out.println("异常数测试");
        int a = 10/0;
        return "异常数测试通过...";
    }

    @GetMapping("/testHot")
    @SentinelResource(value = "testHot",blockHandler = "error_hot")
    // value值任意，但需保证唯一。热点规则资源名只能使用这个
    public String testHot(@RequestParam(name = "p1",required = false) String p1,
                          @RequestParam(name = "p2",required = false) String p2){
        return "热点测试通过...";
    }
    //兜底方法参数类型需保持一致，额外加一个参数BlockException
    public String error_hot(String p1, String p2, BlockException exception){
        return "热点测试失败...";
    }

    @GetMapping("/testGlobalHandler")
    @SentinelResource(value = "testGlobalHandler",
                blockHandlerClass = MyBlockHandler.class,
                blockHandler = "handlerException1")
    public String testGlobalHandler(){
        return "全局globalHandler测试通过...";
    }

    @GetMapping("/testAll")
    @SentinelResource(value = "testAll",
            blockHandler = "blockHandlerMethod",
            fallback = "fallbackMethod",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public String testAll(@RequestParam(name = "num",required = false)
                          Long num){
        if (num == 0){
            throw new IllegalArgumentException("非法的参数异常...");
        }
        if (num == 5){
            throw new NullPointerException("空指针异常...");
        }
        return "测试通过...";
    }

    public String blockHandlerMethod(Long num,BlockException e){
        return "blockHandlerMethod 方法执行...";
    }
    public String fallbackMethod(Long num){
        return "fallbackMethod 方法执行...";
    }
}
