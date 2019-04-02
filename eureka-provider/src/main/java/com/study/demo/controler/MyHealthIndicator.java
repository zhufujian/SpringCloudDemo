package com.study.demo.controler;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

/**
 * 自定义健康指示器(Spring Boot的内容)
 * @author zhu_f
 *
 */
public class MyHealthIndicator implements HealthIndicator{

	public Health health() {
		if(ProviderController.isCanLinkDb){
			return new Health.Builder(Status.UP).build();
		}else{
			return new Health.Builder(Status.DOWN).build();
		}
	}

}
