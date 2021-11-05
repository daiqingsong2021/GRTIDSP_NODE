package com.grtidsp.node.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.grtidsp.node.parent.common.BaseController;
import com.grtidsp.node.parent.common.GrtidspResult;
import com.grtidsp.node.parent.common.MyException;
import com.grtidsp.node.parent.common.RedisTokenUser;
import com.grtidsp.node.parent.constants.GrtidspErrorCode;
import com.grtidsp.node.parent.constants.SystemConstants;
import com.grtidsp.node.facade.AdminMRole;
import com.grtidsp.node.parent.model.PageRequest;
import com.grtidsp.node.model.UserInfoDTO;
import com.grtidsp.node.service.LoginService;
import com.grtidsp.node.parent.utils.CommonUtils;
import com.grtidsp.node.parent.utils.JWTUtils;
import com.grtidsp.node.parent.utils.JsonUtil;
import com.grtidsp.node.parent.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@RestController
@Api("登录验证")
@Slf4j
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录验证接口
     *
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation("登录验证")
    public GrtidspResult<RedisTokenUser> login(@RequestBody UserInfoDTO userinfo, HttpServletRequest request) {
        try {
            UserInfoDTO dto = loginService.login(userinfo);
            RedisTokenUser redis = new RedisTokenUser();
            if (dto != null && dto.getId() > 0) {
                String token = JWTUtils.getToken(Long.valueOf(dto.getUserId()));
                String key = SystemConstants.CONSOLE_USER_PREFIX + token;
                boolean flag = RedisUtils.pairIsExist(key);
                if (!flag) {
                    redis.setToken(token);
                    redis.setUserInfoDTO(dto);
                    RedisUtils.addPair(key, JsonUtil.bean2json(redis), 3600);
                    request.getSession().setAttribute(SystemConstants.USER_KEY, redis);
                    return GrtidspResult.success(redis);
                } else {
                    log.info(assembleLog(GrtidspErrorCode.USER_NOT_FOUND_ERROR));
                    return GrtidspResult.fail(GrtidspErrorCode.USER_NOT_FOUND_ERROR);
                }
            } else {
                return GrtidspResult.fail(GrtidspErrorCode.USER_NOT_FOUND_ERROR);
            }
        } catch (Exception e) {
            if (e instanceof MyException) {
                throw new MyException(((MyException) e).getResponse());
            } else {
                log.error("logtest error:", e);
                throw new MyException(GrtidspErrorCode.NETWORK_ERROR);
            }
        }
    }

    @PostMapping("/logtest")
    public GrtidspResult<RedisTokenUser> logtest(@RequestParam(value = "role") Integer role) {
        log.info("访问了controller");
        try {
            // int j = i / 0;
            RedisTokenUser redis = new RedisTokenUser();
            redis.setToken("sdfsfdfd");
            if (redis.getUserInfoDTO() == null) {
                throw new MyException(GrtidspErrorCode.REDIS_CONNET_ERROR);
            }
            return GrtidspResult.success(redis);
        } catch (Exception e) {
            if (e instanceof MyException) {
                throw new MyException(((MyException) e).getResponse());
            } else {
                log.error("logtest error:", e);
                throw new MyException(GrtidspErrorCode.NETWORK_ERROR);
            }
        }
    }

    /**
     * 登录验证接口
     */
    @GetMapping("/test1")
    @ApiOperation("测试")
    public GrtidspResult<List<UserInfoDTO>> test() {
        List<UserInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserInfoDTO dto = new UserInfoDTO();
            dto.setId(i);
            dto.setPassword("sdfsdf");
            dto.setUserName("sdfsf");
            list.add(dto);
        }
        log.info(assembleLog(GrtidspErrorCode.USER_NOT_FOUND_ERROR));
		return GrtidspResult.fail(GrtidspErrorCode.USER_NOT_FOUND_ERROR);
    }

    /**
     * 登录退出接口
     */
    @PostMapping("/logOut")
    @ApiOperation(value = "退出登录", notes = "退出登录")
    @AdminMRole
    public GrtidspResult<String> logOut() {
        try {
            RedisTokenUser redisToken = CommonUtils.requestGetUser();
            if (redisToken != null) {
                CommonUtils.removeRequestUser(redisToken);
            }
            return GrtidspResult.success(SystemConstants.LOGIN_OUT);
        } catch (Exception e) {
            if (e instanceof MyException) {
                throw new MyException(((MyException) e).getResponse());
            } else {
                log.error("logtest error:", e);
                throw new MyException(GrtidspErrorCode.NETWORK_ERROR);
            }
        }
    }

    @PostMapping(value = "/findAll")
    public GrtidspResult<List<UserInfoDTO>> findAll() {

        return GrtidspResult.success(loginService.findAll());
    }
    @PostMapping(value = "/update")
    public GrtidspResult<List<UserInfoDTO>> updateUser() {

        return GrtidspResult.success(loginService.updateUser());
    }
    @PostMapping(value = "/findPage")
    public GrtidspResult<List<UserInfoDTO>> findPage(@RequestBody PageRequest pageQuery) {
        return GrtidspResult.success(loginService.findPage(pageQuery));
    }
}