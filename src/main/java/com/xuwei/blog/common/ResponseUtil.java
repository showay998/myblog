package com.xuwei.blog.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xuwei.blog.util.DES;

public class ResponseUtil {

	private static Logger logger = Logger.getLogger(ResponseUtil.class);

	public static ModelAndView outputJSONResponse(HttpServletRequest request, HttpServletResponse response, Object model) {
		response.setContentType("application/x-javascript;charset=utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		JSONObject result = new JSONObject();

		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (Constants.IS_ENCRYPT) {// 加密过则
				String json = null;
				try {
					json = JSONObject.toJSONString(model, SerializerFeature.WriteMapNullValue);
					logger.info(request.getRequestURI() + "**output params json string before encypt is:::" + json);
				} catch (IllegalArgumentException e) {
					if (e.getMessage().indexOf(" is an array") > -1) {// 数组
						json = JSONArray.toJSONString(model, SerializerFeature.WriteMapNullValue);
					} else {
						logger.error("output params transfer to json exception.", e);
					}
				}
				json = DES.encryptDES(json, Constants.DES_KEY);
				result.put("result", json);
				logger.info(request.getRequestURI() + "**ouput params json string after encypt is :: " + json);
			} else {// 配置不加密
				result.put("result", model);
				logger.info(request.getRequestURI() + "**output params json string unencypt is :: " + result.toJSONString());
			}
			out.write(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return null;
	}
}
