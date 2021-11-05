package com.grtidsp.node.common;

import com.grtidsp.node.constants.GrtidspErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@org.springframework.web.bind.annotation.ExceptionHandler(MyException.class)
	@ResponseBody
	public GrtidspResult handleStudentException(HttpServletRequest request, MyException ex) {
		log.error("自定义异常：", ex.getResponse().getCode() + ":" + ex.getResponse().getMessage());
		GrtidspResult<String> response = new GrtidspResult(ex.getResponse().getCode(), ex.getResponse().getMessage());
		return response;
	}

	@SuppressWarnings("rawtypes")
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public GrtidspResult handleException(HttpServletRequest request, Exception ex) {
		log.error("运行时错误：", ex);
		GrtidspResult response = new GrtidspResult(GrtidspErrorCode.NETWORK_ERROR.getCode(), GrtidspErrorCode.NETWORK_ERROR.getMessage());
		return response;
	}
}
