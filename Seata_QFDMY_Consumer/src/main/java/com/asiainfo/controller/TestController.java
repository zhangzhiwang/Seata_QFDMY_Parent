package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asiainfo.service.ITestService;

@RestController
public class TestController {
	@Autowired
	private ITestService testService;
	
	@GetMapping("test")
	public String test() {
		testService.test();
		return "success";
	}
}
