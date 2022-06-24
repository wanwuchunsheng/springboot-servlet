package com.servlet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.servlet.feign.impl.K8sServiceNameClientBack;

@FeignClient(name = "smartwf-health-man", url = "smartwf-health-man.windmagics",path="/smartwf_health",fallback = K8sServiceNameClientBack.class)
public interface K8sServiceNameClient {
	
	@GetMapping(value="/log/selectLogById",headers = {"Accept=application/json"})
	String querySysUserInfo2(@RequestParam("id") Integer id);
	

}
