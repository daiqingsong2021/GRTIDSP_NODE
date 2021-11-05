package com.grtidsp.node.facade;

import com.grtidsp.node.common.RedisTokenUser;
import com.grtidsp.node.constants.SystemConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@Component
@Aspect
@Order(10)
public class RoleAspect {
    /**
     * 管理权限控制
     */
    @Pointcut("@annotation(com.grtidsp.node.facade.AdminMRole))")
    public void root() {
    }

    @Before("root()")
    public void after(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ra.getRequest();
        // 权限验证
        RedisTokenUser redisUserDTO = (RedisTokenUser) request.getAttribute(SystemConstants.USER_KEY);
        if (SystemConstants.ROOTM_ROLE.equalsIgnoreCase(redisUserDTO.getUserInfoDTO().getUserRole())) {
            request.setAttribute("roleValid", true);
        }
    }
}
