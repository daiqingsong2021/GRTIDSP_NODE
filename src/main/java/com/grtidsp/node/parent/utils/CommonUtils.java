package com.grtidsp.node.parent.utils;

import com.grtidsp.node.parent.common.RedisTokenUser;
import com.grtidsp.node.parent.constants.SystemConstants;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
public class CommonUtils {
	public static RedisTokenUser requestGetUser() {
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		RedisTokenUser redisUserDTO = (RedisTokenUser) request.getSession().getAttribute(SystemConstants.USER_KEY);
		return redisUserDTO;
	}

	public static void removeRequestUser(RedisTokenUser redisToken) throws Exception{
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		request.getSession().setAttribute(SystemConstants.USER_KEY, "");
		RedisUtils.delPair(SystemConstants.CONSOLE_USER_PREFIX + redisToken.getToken());
	}

	public static Long requestGetWxUser() {
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		Long userId = (Long) request.getAttribute(SystemConstants.WX_USER_KEY);
		return userId;
	}
}
