package com.grtidsp.common.utils;

import java.util.UUID;

/**
 * 生成uuid 功能咧
 * 
 * @author EDZ
 * @date 2021/10
 * @version v1.0
 */
public class GenerateUUidUtil {

	/**
	 * 生成无"-"的uuid
	 * 
	 * @return uuid
	 */
	public static String getUUID() {
		String replace = UUID.randomUUID().toString().replace("-", "");
		return replace;
	}
}
