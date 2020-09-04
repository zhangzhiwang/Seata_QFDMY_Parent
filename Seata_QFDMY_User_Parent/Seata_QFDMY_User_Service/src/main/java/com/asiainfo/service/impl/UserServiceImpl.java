package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.asiainfo.entity.User;
import com.asiainfo.mapper.UserMapper;
import com.asiainfo.service.api.IUserService;

@DubboService
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}
}
