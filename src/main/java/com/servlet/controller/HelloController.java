package com.servlet.controller;

import java.util.List;

import javax.xml.transform.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servlet.pojo.User;
import com.servlet.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController {
	
	
	 @Autowired
	 private UserService userService;
	 

	 
	//测试
	@GetMapping("/queryUserInfo")
    @ApiOperation(value = "查询用户接口", notes = "用户信息")
    @ApiImplicitParams({
	    @ApiImplicitParam(paramType = "query", name = "id", value = "登录账号（禁止特殊字符）", dataType = "Integer")
    })
    public ResponseEntity<Object> queryUserInfo(User userInfo) {
		List<User> user = userService.queryUserInfo(userInfo);
        return ResponseEntity.ok(user);
    }
	
	
	
	
}
