package com.xuwei.blog.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xuwei.blog.mapper.BaseMapper;
import com.xuwei.blog.model.BaseModel;

public class BaseService<T extends BaseModel> {

	@Autowired
	BaseMapper<T> mapper;
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public List<T> listAll() throws Exception {
		logger.info("==查询所有记录==");
		return mapper.selectAll();
	}

	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @throws Exception
	 * @author xuwei
	 * @date 2018年8月28日下午4:54:29
	 */
	public void delete(Long id) throws Exception {
		logger.info("==删除一条记录==");
		T record = queryById(id);
		record.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		record.setIsValid(false);
		mapper.updateById(record);
	}

	public T insert(T record) throws Exception {
		logger.info("==保存一条记录==");
		record.setCreateDate(new Timestamp(System.currentTimeMillis()));
		record.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		record.setIsValid(true);
		mapper.insert(record);
		return record;
	}

	public T update(T record) throws Exception {
		logger.info("==更新一条记录==");
		record.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		if (record.getId() == null) {
			record.setCreateDate(new Timestamp(System.currentTimeMillis()));
			mapper.insert(record);
		} else {
			mapper.updateById(record);
		}
		return record;
	}

	public T queryById(Long id) throws Exception {
		logger.info("==根据id查询一条记录==");
		T record = mapper.selectById(id);
		return record;
	}

}
