package com.servlet.dao;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.servlet.pojo.User;

@Repository
public interface UserDao extends BaseMapper<User> {


}
