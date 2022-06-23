package com.servlet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.servlet.feign.impl.ProviderClientFallback;

@FeignClient(name = "${service.provider.name}",url = "${service.provider.url}",fallback = ProviderClientFallback.class)
public interface ProviderClient {
	
	@GetMapping("/provider/hello")
    String hello();

}
