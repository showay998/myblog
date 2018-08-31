package com.xuwei.blog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuwei.blog.mapper.UserMapper;
import com.xuwei.blog.model.User;
import com.xuwei.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserInfoByUserId(String userId) {
		User user = userMapper.selectByUserId(Integer.parseInt(userId));
		return user;
	}

}
