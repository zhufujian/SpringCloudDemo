package com.study.demo.controler;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "eureka-provider", configuration = MyConfig.class)
public class MyLoadBalanceClient {

}
