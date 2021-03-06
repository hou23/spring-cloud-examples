package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaojie.hou
 * @create 2018/8/22
 */
@RestController
public class HelloController {

	@Value("${config.hello}")
	private String hello;

	@RequestMapping("/hello")
	public String hello() {
		return this.hello;
	}
}
