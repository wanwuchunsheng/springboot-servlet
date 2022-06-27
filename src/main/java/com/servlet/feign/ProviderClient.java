package com.servlet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.servlet.common.CustomErrorDecoder;
import com.servlet.feign.impl.ProviderClientFallback;


/***  注意fallback 和 fallbackFactory却别，fallback ：实现接口  fallbackFactory实现接口对象
@FeignClient(name = "ProviderClient",url = "https://portal.windmagics.com/smartwf_sys_backend",fallbackFactory = ProviderClientFallback.class, configuration = CustomErrorDecoder.class )
public interface ProviderClient {
	
	@GetMapping(value="/user/selectUserInfoById",headers = {"Accept=application/json"})
	String querySysUserInfo(@RequestParam("id") Integer id);
	

}
*/

@FeignClient(name = "ProviderClient", url = "smartwf-system-man:8300",path="/smartwf_sys_backend",fallbackFactory = ProviderClientFallback.class,configuration = CustomErrorDecoder.class)
public interface ProviderClient {
	
	@GetMapping(value="/user/selectUserInfoById",headers = {"Accept=application/json"})
	String querySysUserInfo(@RequestParam("id") Integer id);

}
