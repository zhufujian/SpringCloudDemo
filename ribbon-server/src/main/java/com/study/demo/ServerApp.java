package com.study.demo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServerApp {

	public static void main(String[] args) {
		//Scanner scanner= new Scanner(System.in);
		//String port =scanner.nextLine();
		//new SpringApplicationBuilder(ServerApp.class).properties("server.port=" + port).run(args);
		new SpringApplicationBuilder(ServerApp.class).web(true).run(args);
		/*
		Scanner scan = new Scanner(System.in);
		String port = scan.nextLine();
		new SpringApplicationBuilder(ServerApp.class).properties("server.port=" + port).web(true).run(args);
		*/
	}
}
