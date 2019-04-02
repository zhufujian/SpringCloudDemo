package com.study.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

public class MyHealthCheckHandler implements HealthCheckHandler{
	@Autowired
	private MyHealthIndicator myHealthIndicator;
	
	public InstanceStatus getStatus(InstanceStatus arg0) {
		Status status = myHealthIndicator.health().getStatus();
		if(status.equals(Status.UP)){
			return InstanceStatus.UP;
		}else{
			return InstanceStatus.DOWN;
		}
	}
}
