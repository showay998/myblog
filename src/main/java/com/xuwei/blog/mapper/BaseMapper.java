package com.xuwei.blog.mapper;

import java.util.List;

import com.xuwei.blog.model.BaseModel;

public interface BaseMapper<T extends BaseModel> {

	/**
	 * 查询所有集合
	 * 
	 * @return
	 * @author xuwei
	 * @date 2018年8月28日下午4:43:06
	 */
	List<T> selectAll();

	/**
	 * 根据id删除记录
	 * 
	 * @param id
	 * @return
	 * @author xuwei
	 * @date 2018年8月28日下午4:43:18
	 */
	int deleteById(Long id);

	/**
	 * 根据id查询某个记录
	 * 
	 * @param id
	 * @return
	 * @author xuwei
	 * @date 2018年8月28日下午4:43:40
	 */
	T selectById(Long id);

	/**
	 * 插入一条记录
	 * 
	 * @param t
	 * @return
	 * @author xuwei
	 * @date 2018年8月28日下午4:43:56
	 */
	int insert(T t);

	/**
	 * 更新某条记录
	 * 
	 * @param t
	 * @return
	 * @author xuwei
	 * @date 2018年8月28日下午4:44:08
	 */
	int updateById(T t);
}
