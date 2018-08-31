package com.xuwei.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xuwei.blog.common.CodeMsg;
import com.xuwei.blog.common.MapResult;
import com.xuwei.blog.common.ParamThreadLocal;
import com.xuwei.blog.common.ResponseUtil;
import com.xuwei.blog.model.User;
import com.xuwei.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUser")
	public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> param = ParamThreadLocal.get();
		logger.info("param::" + JSON.toJSONString(param));
		String userId = param.get("id");
		logger.info("开始！！");
		MapResult result = null;
		try {
			if (StringUtils.isEmpty(userId)) {
				result = new MapResult(CodeMsg.FAIL, "用户id为空");
				return ResponseUtil.outputJSONResponse(request, response, result);
			}
			User user = userService.getUserInfoByUserId(userId);
			if (user != null) {
				result = new MapResult(CodeMsg.SUCCESS, "请求成功");
				Map<String, Object> data = new HashMap<String, Object>();
				user.setPasswd(null);
				data.put("userInfo", user);
				result.setData(data);
			} else {
				result = new MapResult(CodeMsg.FAIL, "无该用户");
			}
		} catch (Exception e) {
			logger.error("get user info has error:::", e);
			result = new MapResult();
			result.setRetcode(CodeMsg.FAIL);
			result.setRetmsg("获取用户信息发生异常。");
		}
		return ResponseUtil.outputJSONResponse(request, response, result);
	}
}
