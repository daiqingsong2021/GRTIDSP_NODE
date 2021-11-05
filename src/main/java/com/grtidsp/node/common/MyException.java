package com.grtidsp.node.common;

import com.grtidsp.node.constants.GrtidspErrorCode;

/**
 * 自定义异常
 * @Author daiqingsong
 * @Date 2021/10
 **/
public class MyException extends RuntimeException {
    private static final long serialVersionUID = -6370612186038915645L;

    private final GrtidspErrorCode response;

    public MyException(GrtidspErrorCode response) {
        this.response = response;
    }

    public GrtidspErrorCode getResponse() {
        return response;
    }

}
