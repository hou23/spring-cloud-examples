package com.example.hystrix_producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaojie.hou
 * @create 2018/8/7
 */
@RestController
public class HelloController {

	@RequestMapping("/getStores")
	public String getStores() {
		return "hello, this is your stores";
	}
}
