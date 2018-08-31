package com.xuwei.blog.mapper;

import org.apache.ibatis.annotations.Param;

import com.xuwei.blog.model.User;

public interface UserMapper extends BaseMapper<User> {

	public User selectByUserId(@Param("userId") Integer userId);

}
