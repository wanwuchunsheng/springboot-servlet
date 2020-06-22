package com.servlet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servlet.common.RedisService;
import com.servlet.service.UserService;

@RestController
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private RedisService redisService ;

	 
	//测试
	@GetMapping(path = "/hello")
    public String hello() {
		redisService.set(Math.random()*2*100+"","测试");
        return "Hello Jenkins  k8s 配置1111111111111";
    }
	
	//情况表
	@GetMapping(path = "/del")
    public String del() {
		userService.deleteAllUsers();
        return "清空user表";
    }
	
	//查询多少条
	@GetMapping(path = "/count")
    public String count() {
        return "数据库总条数："+userService.getAllUsers();
    }
	
	//插入
	@GetMapping(path = "/add")
    public String add() {
		System.out.println("插入5个用户");
		log.info("插入5个用户");
		log.debug("插入5个用户debug");
		log.error("插入5个用户error");
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
        return "插入完成";
    }
	
	
	
	
	
}
