package com.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.servlet.dao.UserDao;
import com.servlet.pojo.User;
import com.servlet.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao userDao;

	@Override
	public List<User> queryUserInfo(User userInfo) {
		QueryWrapper<User> queryWp = new QueryWrapper<>();
		if(userInfo.getId()  != null) {
			queryWp.eq("id", userInfo.getId());
		}
		List<User> user =userDao.selectList(queryWp);
		return user;
	}
	
	
	
}
