package com.servlet.feign.impl;

import org.springframework.stereotype.Component;

import com.servlet.feign.ProviderClient;


@Component
public class ProviderClientFallback implements ProviderClient {

	@Override
	public String querySysUserInfo(Integer id) {
		// TODO Auto-generated method stub
		return "调用失败， feign back";
	}

	

}
