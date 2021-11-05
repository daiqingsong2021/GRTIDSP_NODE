package com.grtidsp.node.parent.constants;
/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
public class SystemConstants {
	public static final String QE_PREFIX = "QR:";
	// 保存在redis中token的前缀
	public static final String CONSOLE_USER_PREFIX = "console:";
	// 微信登录时缓存的值
	public static final String WX_USER_KEY = "wxUser";
	// 登录时缓存的值
	public static final String USER_KEY = "redisUser";
	// 退出参数
	public static final String LOGIN_OUT = "10009";
	// 超时时间
	public static final Integer QR_TIMEOUT = 168 * 60 * 60;
	
	public static final String ROOTM_ROLE = "1";
}
