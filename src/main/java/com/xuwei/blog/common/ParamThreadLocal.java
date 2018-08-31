package com.xuwei.blog.common;

import java.util.Map;

public class ParamThreadLocal {

	private ParamThreadLocal() {
	}

	private static final ThreadLocal<Map<String, String>> LOCAL = new ThreadLocal<>();

	public static void set(Map<String, String> param) {
		LOCAL.set(param);
	}

	public static Map<String, String> get() {
		return LOCAL.get();
	}

	public static void remove() {
		LOCAL.remove();
	}
}
