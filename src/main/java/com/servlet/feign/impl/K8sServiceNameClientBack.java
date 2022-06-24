package com.servlet.feign.impl;

import org.springframework.stereotype.Component;

import com.servlet.feign.K8sServiceNameClient;

@Component
public class K8sServiceNameClientBack implements K8sServiceNameClient{

	@Override
	public String querySysUserInfo2(Integer id) {
		// TODO Auto-generated method stub
		return "异常 feign back";
	}

}
