package com.grtidsp.node.dao;

import java.util.List;

import com.grtidsp.node.mappers.UserServiceMapper;
import com.grtidsp.node.parent.model.PageRequest;
import com.grtidsp.node.model.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
