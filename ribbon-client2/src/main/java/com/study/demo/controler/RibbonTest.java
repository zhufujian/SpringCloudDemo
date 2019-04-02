package com.study.demo.controler;

import java.io.IOException;
import java.net.URISyntaxException;

import com.netflix.client.ClientException;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

public class RibbonTest {

	public static void main(String[] args) throws InterruptedException,
			IOException, ClientException, URISyntaxException {
		//test01();
		test02();
	}

	private static void test01() {

		// 设置要请求的服务器
		ConfigurationManager.getConfigInstance().setProperty(
				"sample-client.ribbon.listOfServers",
				"localhost:8082,localhost:8083");
		// 设置REST请求客户端
		RestClient client = (RestClient) ClientFactory
				.getNamedClient("sample-client");
		// 创建请求实例
		HttpRequest request = HttpRequest.newBuilder().uri("/search/1").build();
		// 连续发送10次请求到服务器
		for (int i = 0; i < 10; i++) {
			try {
				HttpResponse response = client.executeWithLoadBalancer(request);
				String result = response.getEntity(String.class);
				System.out.println("请求" + i + "结果：" + result);
			} catch (ClientException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static void test02() {
		//设置要请求的服务器
				ConfigurationManager.getConfigInstance().setProperty(
			      		"sample-client.ribbon.listOfServers", 
			      		"localhost:8082,localhost:8083");
				//配置自定义的负载均衡器规则
				ConfigurationManager.getConfigInstance().setProperty(
			      		"sample-client.ribbon.NFLoadBalancerRuleClassName", 
			      		MyRule.class.getName());
				//设置REST请求客户端
				RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");
				//创建请求实例
				HttpRequest request = HttpRequest.newBuilder().uri("/search/1").build();
				//连续发送10次请求到服务器
				for(int i=0; i<10; i++){
					try {
						HttpResponse response = client.executeWithLoadBalancer(request);
						String result = response.getEntity(String.class);
						System.out.println("请求结果："+result);
					} catch (ClientException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	}
}
