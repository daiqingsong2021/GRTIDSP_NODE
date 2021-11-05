package com.grtidsp.node.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户表")
public class UserInfoDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "id")
	private Integer id;
	@ApiModelProperty(value = "userId")
	private String userId;
	@ApiModelProperty(value = "userRole")
	private String userRole;
	@ApiModelProperty(value = "userName")
	private String userName;
	@ApiModelProperty(value = "password")
	private String password;
	@ApiModelProperty(value = "unitId")
	private String unitId;
}
