package com.servlet.service;

import java.util.List;

import com.servlet.pojo.User;

public interface UserService {
	
	
	List<User> queryUserInfo(User userInfo);

}
