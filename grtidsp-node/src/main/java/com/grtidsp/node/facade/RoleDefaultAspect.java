package com.grtidsp.node.facade;

import com.grtidsp.common.common.MyException;
import com.grtidsp.common.constants.GrtidspErrorCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@Component
@Aspect
@Order(11)
public class RoleDefaultAspect {
    /**
     * 统一控制
     */
    @Pointcut("@annotation(com.grtidsp.node.facade.AdminMRole)")
    public void root() {
    }

    @Before("root()")
    public void after(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ra.getRequest();
        if (Objects.isNull(request.getAttribute("roleValid")) || !(Boolean) request.getAttribute("roleValid")) {
            throw new MyException(GrtidspErrorCode.ROLE_VALID_ERROR);
        }
    }

}
