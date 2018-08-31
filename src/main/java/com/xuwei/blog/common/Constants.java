package com.xuwei.blog.common;

import java.util.Properties;

import com.xuwei.blog.util.PropertiesUtil;

public class Constants {

	public static boolean IS_ENCRYPT = false;
	public static String DES_KEY = "MYBLOG";
	static {
		Properties properties = PropertiesUtil.getProperties("/config.properties");
		IS_ENCRYPT = Boolean.parseBoolean(properties.getProperty("is_encrypt", "false"));
	}
}
