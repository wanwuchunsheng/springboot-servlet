package com.servlet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ServletComponentScan  //在启动的时候会扫描@webServlet注解
@MapperScan(basePackages = {"com.servlet.dao"})
//@EnableFeignClients
public class APP {
	
	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}

}
