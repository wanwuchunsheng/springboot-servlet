package com.servlet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.servlet.feign.impl.ProviderClientFallback;


/***
@FeignClient(name = "springboot-servlet",url = "https://portal.windmagics.com/smartwf_sys_backend",fallback = ProviderClientFallback.class)
public interface ProviderClient {
	
	@GetMapping(value="/user/selectUserInfoById",headers = {"Accept=application/json"})
	String querySysUserInfo(@RequestParam("id") Integer id);

}
*/

@FeignClient(name = "smartwf-system-man", url = "smartwf-system-man:8300",path="/smartwf_sys_backend",fallback = ProviderClientFallback.class)
public interface ProviderClient {
	
	@GetMapping(value="/user/selectUserInfoById",headers = {"Accept=application/json"})
	String querySysUserInfo(@RequestParam("id") Integer id);

}
