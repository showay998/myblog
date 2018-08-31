package com.xuwei.blog.common;

import java.io.Serializable;

import org.apache.commons.collections.MapUtils;

public class MapResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private int retcode = CodeMsg.SUCCESS;
	private String retmsg = "操作成功";
	private Object data = MapUtils.EMPTY_MAP;

	public MapResult(int retcode, String retmsg, Object data) {
		this.retcode = retcode;
		this.retmsg = retmsg;
		this.data = data;
	}

	public MapResult(int retcode, String retmsg) {
		this.retcode = retcode;
		this.retmsg = retmsg;
	}

	public MapResult(Object data) {
		this.retmsg = "查询成功";
		this.data = data;
	}

	public MapResult(int retcode) {
		this.retcode = retcode;
		this.retmsg = "操作失败";
	}

	public MapResult() {

	}

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
