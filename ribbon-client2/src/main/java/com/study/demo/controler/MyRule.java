package com.study.demo.controler;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule{

	private ILoadBalancer lb;
	@Override
	public Server choose(Object key) {
		Random random = new Random();
		Integer num = random.nextInt(10);//在0-9这10个随机数里取值
		//获取传输负载均衡器里所有的服务
		List<Server> servers = lb.getAllServers();
		if(num>7){//返回8082端口服务
			return chooseServerByPort(servers,8082);
		}
		//返回8083端口服务
		return chooseServerByPort(servers,8083);
	}
	private Server chooseServerByPort(List<Server> servers,Integer port){
		for (Server server : servers) {
			if(server.getPort() == port){
				return server;
			}
		}
		return null;
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb = lb;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return lb;
	}

}
