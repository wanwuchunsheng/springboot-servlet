package com.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan  //在启动的时候会扫描@webServlet注解
public class APP {
	
	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}

}
