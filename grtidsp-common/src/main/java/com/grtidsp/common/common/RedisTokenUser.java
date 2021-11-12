package com.grtidsp.common.common;

import com.grtidsp.common.model.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一登录redis存放的缓存信息
 *
 * @author daiqingsong 2021-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedisTokenUser implements Serializable {
    private static final long serialVersionUID = -7279149331328765178L;
    private String token;
    private UserInfoDTO userInfoDTO;
}
