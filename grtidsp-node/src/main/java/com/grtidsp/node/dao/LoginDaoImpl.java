package com.grtidsp.node.dao;

import com.grtidsp.common.model.PageRequest;
import com.grtidsp.common.model.UserInfoDTO;
import com.grtidsp.node.mappers.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private UserServiceMapper userServiceMapper;

	@Override
	public UserInfoDTO login(UserInfoDTO userinfo) {
		return userServiceMapper.loadUser(userinfo);
	}

	@Override
	public List<UserInfoDTO> findAll() {
		return userServiceMapper.findAll();
	}

	@Override
	public List<UserInfoDTO> findPage(PageRequest pageRequest) {
		return userServiceMapper.findPage(pageRequest);
	}

	

	
}
