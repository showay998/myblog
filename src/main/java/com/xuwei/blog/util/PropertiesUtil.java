package com.xuwei.blog.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 功能描述：获得指定路径下Properties文件中某一个键对应的值
	 * 
	 * @param filePath
	 *            Properties文件路径
	 * @param key
	 *            键
	 * @return String 值
	 * @author 许志辉(XuZH)
	 * @date 2012-8-5 上午11:45:59 @修改日志：
	 */
	public static String getValue(String filePath, String key) {
		Properties props = new Properties();
		InputStream in = null;
		String value = null;
		try {
			in = PropertiesUtil.class.getResourceAsStream(filePath);
			props.load(in);
			value = props.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;

	}

	/**
	 * 功能描述：获得指定路径下Properties文件的对象
	 * 
	 * @param filePath
	 *            Properties文件路径
	 * @return Properties Properties对象
	 * @author 许志辉(XuZH)
	 * @date 2012-8-5 上午11:51:19 @修改日志：
	 */
	public static Properties getProperties(String filePath) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = PropertiesUtil.class.getResourceAsStream(filePath);
			props.load(new InputStreamReader(in, "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return props;
	}

	/**
	 * 功能描述：对路径下Properties文件进行修改（搜索引擎管理配置搜索引擎服务器时可能会用到）
	 * 
	 * @param filePath
	 *            Properties文件路径
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return void
	 * @author 许志辉(XuZH)
	 * @date 2012-8-5 上午11:56:02 @修改日志：
	 */
	public static void writeProperties(String filePath, String key, String value) {
		Properties prop = new Properties();
		InputStream fis = null;
		OutputStream fos = null;
		try {
			fis = new FileInputStream(filePath);
			// 从输入流中读取属性列表（键和元素对）
			prop.load(fis);
			// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			prop.store(fos, "Update '" + key + "' value");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
