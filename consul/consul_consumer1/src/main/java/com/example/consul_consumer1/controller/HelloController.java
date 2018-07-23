package com.example.consul_consumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yaojie.hou
 * @create 2018/7/23
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

	@RequestMapping("/hello")
	public Object hello() {
		String url = loadBalancer.choose("service-producer").getUri().toString();
		return restTemplate.getForObject(url + "/hello", String.class);
	}
}
