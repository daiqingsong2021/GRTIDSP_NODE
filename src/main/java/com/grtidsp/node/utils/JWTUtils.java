package com.grtidsp.node.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@Slf4j
public class JWTUtils {
	private static final String password = "3TU10P3HS4FI3OPaRUSUYAFwYzMdnGBV";

	public static String getToken(Long userId) {
		String token = "";
		token = JWT.create().withAudience(String.valueOf(userId)).withExpiresAt(new Date())
				.sign(Algorithm.HMAC256(password));
		return token;
	}

	public static String getToken4h5(Long userId) {
		String token = "";
		token = JWT.create().withAudience(String.valueOf(userId) + ":H5").withExpiresAt(new Date())
				.sign(Algorithm.HMAC256(password));
		return token;
	}

	public static void main(String[] args) {
		System.out.println(JWTUtils.getToken(1000001L));
	}
}
