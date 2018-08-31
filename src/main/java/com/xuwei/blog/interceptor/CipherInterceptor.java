package com.xuwei.blog.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xuwei.blog.common.CodeMsg;
import com.xuwei.blog.common.Constants;
import com.xuwei.blog.common.MapResult;
import com.xuwei.blog.common.ParamThreadLocal;
import com.xuwei.blog.common.ResponseUtil;
import com.xuwei.blog.util.DES;

public class CipherInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Map<String, String> returnMap = new HashMap<String, String>();
		String value = request.getParameter("data");
		if (Constants.IS_ENCRYPT) {// 加密
			try {
				value = DES.decryptDES(value, Constants.DES_KEY);
				logger.info("input param after decrpt : key[data]::value[" + value + "]");
				returnMap = JSON.parseObject(value, new TypeReference<Map<String, String>>() {
				});
			} catch (Exception e) {
				// 解密失败
				MapResult result = new MapResult();
				result.setRetcode(CodeMsg.FAIL);
				result.setRetmsg("解密失败！");
				ResponseUtil.outputJSONResponse(request, response, result);
				return false;
			}
		} else {
			try {
				returnMap = JSON.parseObject(value, new TypeReference<Map<String, String>>() {
				});
			} catch (Exception e) {
				MapResult result = new MapResult();
				result.setRetcode(CodeMsg.FAIL);
				result.setRetmsg("参数解析异常！");
				ResponseUtil.outputJSONResponse(request, response, result);
				return false;
			}
		}

		if (returnMap == null) {
			returnMap = new HashMap<>();
		}

		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : returnMap.entrySet()) {
			String val = entry.getValue();
			if (val.length() > 200) {
				val = val.substring(0, 200);
			}
			sb.append(" " + entry.getKey() + "=" + val + " ");
		}
		logger.info(request.getRequestURI() + " " + sb.toString());

		ParamThreadLocal.set(returnMap);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// 清空本地线程中的参数对象数据
		ParamThreadLocal.set(null);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
