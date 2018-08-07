package com.example.hystrix_consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yaojie.hou
 * @create 2018/8/6
 */
@RestController
public class HelloController {

	private final LoadBalancerClient loadBalancer;
	private final RestTemplate restTemplate;

	@Autowired
	public HelloController(LoadBalancerClient loadBalancer, RestTemplate restTemplate) {
		this.loadBalancer = loadBalancer;
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod = "defaultStores")
	@RequestMapping("/getStores")
	public String getStores() {
		String uri = loadBalancer.choose("hystrix-producer").getUri().toString();
		return restTemplate.getForObject(uri + "/getStores", String.class);
	}

	public String defaultStores() {
		return "hello, this is default stores";
	}
}
