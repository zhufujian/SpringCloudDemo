package com.study.demo.controler;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

public class MyConfig {

	@Bean
	public IRule getMyRule(){
		return new MyRule();
	}
}
