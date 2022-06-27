package com.servlet.common;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.hystrix.HystrixFeign;
import okhttp3.ConnectionPool;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignConfig {

	@Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new okhttp3.OkHttpClient.Builder()
        	    //设置连接超时
        	    .connectTimeout(60, TimeUnit.SECONDS)
        	    //设置读超时
        	    .readTimeout(60, TimeUnit.SECONDS)
        	    //设置写超时
        	    .writeTimeout(120,TimeUnit.SECONDS)
        	    //是否自动重连
        	    .retryOnConnectionFailure(true)
        	    .connectionPool(new ConnectionPool())
        	    //构建OkHttpClient对象
        	    .build();
    }
 
    @Bean
    public Feign.Builder feignBuilder() {
        return HystrixFeign.builder();
    }
 
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }
 
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
 
    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(10, TimeUnit.SECONDS, 60,TimeUnit.SECONDS,true);
    }
 
    @Bean
    public Retryer feignRetry() {
        return new Retryer.Default();
    }

}
