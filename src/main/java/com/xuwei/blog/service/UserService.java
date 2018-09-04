package com.xuwei.blog.service;

import java.util.Map;

import com.xuwei.blog.common.MapResult;
import com.xuwei.blog.model.User;

public interface UserService {

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 * @author xuwei
	 * @date 2018年9月4日上午10:54:57
	 */
	public User getUserInfoByUserId(String userId);

	/**
	 * 注册用户
	 * 
	 * @param param
	 * @return
	 * @author xuwei
	 * @date 2018年9月4日上午10:55:06
	 */
	public MapResult registerUser(Map<String, String> param);

}
