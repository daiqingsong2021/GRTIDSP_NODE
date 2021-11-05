package com.grtidsp.node.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * text util
 * 
 * @author daiqingsong
 * @date 2021/10
 */
public abstract class TextUtil {
	private TextUtil() {
	}

	public static final char STAR = '*';

	/**
	 * 掩码
	 * 
	 * @param src
	 * @return
	 */
	public static String mask(String src) {

		if (StringUtils.isEmpty(src)) {
			return src;
		}
		if (src.length() > 14) {
			return maskCertNo(src);
		}
		return maskPhone(src);
	}

	/**
	 * 脱敏手机号码
	 * 
	 * @param phone
	 * @author 
	 * @date 2020-05-26 14:24:03
	 * @return
	 */
	public static String maskPhone(String phone) {
		if (StringUtils.isEmpty(phone)) {
			return phone;
		}
		char[] arr = phone.toCharArray();
		if (arr.length < 7) {
			return phone;
		}
		for (int i = 3; i < 7; i++) {
			arr[i] = STAR;
		}
		return new String(arr);
	}

	/**
	 * 脱敏身份证
	 * 
	 * @param certNo
	 * @author 
	 * @date 2020-05-26 14:26:47
	 * @return
	 */
	public static String maskCertNo(String certNo) {
		if (StringUtils.isEmpty(certNo)) {
			return certNo;
		}

		char[] arr = certNo.toCharArray();
		if (arr.length < 14) {
			return certNo;
		}
		for (int i = 3; i < 14; i++) {
			arr[i] = STAR;
		}
		return new String(arr);
	}

	/**
	 *
	 * @param pattern
	 * @return
	 */
	public static String now(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 *
	 * @param pattern
	 * @return
	 */
	public static String format(String pattern, Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(pattern).format(date);
	}
}
