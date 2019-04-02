package com.study.demo.bean;

import lombok.Data;

@Data
public class Person {

	private Integer id;			//主键ID
	private String name;		//姓名
	private String info;		//信息，根据URL地址查看服务的来源
}
