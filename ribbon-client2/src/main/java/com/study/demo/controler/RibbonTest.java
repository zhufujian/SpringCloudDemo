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

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException, ClientException, URISyntaxException {
	
		//设置要请求的服务器
				ConfigurationManager.getConfigInstance().setProperty(
			      		"sample-client.ribbon.listOfServers", 
			      		"localhost:8082,localhost:8083");
				//设置REST请求客户端
				RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");
				//创建请求实例
				HttpRequest request = HttpRequest.newBuilder().uri("/search/1").build();
				//连续发送10次请求到服务器
				for(int i=0; i<10; i++){
					try {
						HttpResponse response = client.executeWithLoadBalancer(request);
						String result = response.getEntity(String.class);
						System.out.println("请求"+i+"结果："+result);
					} catch (ClientException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	}
}
