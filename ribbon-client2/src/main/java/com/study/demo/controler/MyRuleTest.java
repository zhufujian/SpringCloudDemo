package com.study.demo.controler;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyRuleTest {

public static void main(String[] args) {
	BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
	
	MyRule myRule = new MyRule();
	loadBalancer.setRule(myRule);
	
	List<Server> servers = new ArrayList<Server>();
	servers.add(new Server("localhost",8082));
	servers.add(new Server("localhost",8083));
	
	loadBalancer.addServers(servers);
	
	for(int i=0; i<10; i++){
		//参数是负载均衡器可用来确定要返回哪个服务器的对象。置空表示不使用
		Server chosedServer = loadBalancer.chooseServer(null);
		System.out.println("选择的服务是："+chosedServer);
	}
}
}
