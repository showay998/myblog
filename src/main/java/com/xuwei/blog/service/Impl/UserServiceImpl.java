package com.xuwei.blog.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuwei.blog.common.MapResult;
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

	@Override
	public MapResult registerUser(Map<String, String> param) {
		MapResult mapResult = registCheckParam(param);
		return null;
	}

	/**
	 * 注册部分校验参数
	 * 
	 * @param param
	 * @return
	 * @author xuwei
	 * @date 2018年9月4日上午11:02:02
	 */
	private MapResult registCheckParam(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
