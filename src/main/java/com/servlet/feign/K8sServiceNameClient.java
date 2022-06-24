package com.servlet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "smartwf-system-man", url = "smartwf-system-man",path="/smartwf_sys_backend",fallback = K8sServiceNameClient.class)
public interface K8sServiceNameClient {
	
	@GetMapping(value="/user/selectUserInfoById",headers = {"Accept=application/json"})
	String querySysUserInfo2(@RequestParam("id") Integer id);
	

}
