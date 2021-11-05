package com.grtidsp.node.constants;
/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
public enum GrtidspErrorCode {
	// 通用错误码
	SYSTEM_NO_ERROR("0100", "未知系统错误"), 
	PARAM_VALID_ERROR("0101", "非法请求参数"), 
	USER_NOT_FOUND_ERROR("0102", "登录验证用户没找到"), 
	REDIS_CONNET_ERROR("0103", "redis连接失败"),
	NETWORK_ERROR("9999", "网络错误，待会重试"),
	ROLE_VALID_ERROR("1000", "角色异常"),
	FILE_SUFFIX_ERROR("1001", "文件传输错误");
	
	public final String code;
	public final String message;

	GrtidspErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
