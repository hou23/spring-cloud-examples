package com.example.hystrix_consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @author yaojie.hou
 * @create 2018/8/6
 */
@Component
public class HelloController {

	@HystrixCommand(fallbackMethod = "defaultStores")
	public String getStores() {
		return "hello, this is your stores";
	}

	public String defaultStores() {
		return "hello, this is default stores";
	}
}
