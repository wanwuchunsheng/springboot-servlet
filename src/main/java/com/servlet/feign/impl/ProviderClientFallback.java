package com.servlet.feign.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.servlet.feign.ProviderClient;

import feign.hystrix.FallbackFactory;


@Component
public class ProviderClientFallback implements  FallbackFactory<ProviderClient>  {

	@Override
	public ProviderClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new ProviderClient() {
			
			@Override
			public String querySysUserInfo(Integer id) {
				// TODO Auto-generated method stub
				return cause.getMessage();
			}
		};
	}

	

}
