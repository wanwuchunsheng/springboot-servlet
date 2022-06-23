package com.servlet.feign.impl;

import com.servlet.feign.ProviderClient;

public class ProviderClientFallback implements ProviderClient {

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "调用错误";
	}

}
