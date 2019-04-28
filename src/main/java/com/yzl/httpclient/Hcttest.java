package com.yzl.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Hcttest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//获取HttpClient实例对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//通过get方式获取接口路径
		HttpGet httpget = new HttpGet("http://httpbin.org/get");
		System.out.println("请求行信息："+httpget.getRequestLine());
		//响应信息
		CloseableHttpResponse response = null;
		String entity=null;
		try {
			//执行get请求
			response = httpClient.execute(httpget);
			//获取请求状态码
			int status = response.getStatusLine().getStatusCode();
			if(status>=200 && status <= 300) {
				
				entity=	EntityUtils.toString(response.getEntity(),"utf-8");
				}else {
					throw new ClientProtocolException("读取数据失败");
				}
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(entity);
	}
}
