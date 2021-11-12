package com.grtidsp.node.service;

import com.grtidsp.common.model.PageRequest;
import com.grtidsp.common.model.UserInfoDTO;
import com.grtidsp.node.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@CacheConfig(cacheNames = "CacheConfigName")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDTO login(UserInfoDTO userinfo) {
        return loginDao.login(userinfo);
    }

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，可以直接从缓存中获取不需要调用方法
     **/
    @Cacheable(value = "valueName", key = "'keyName1'")
    @Override
    public List<UserInfoDTO> findAll() {

        return loginDao.findAll();
    }
    @CacheEvict(value = "valueName",allEntries = true)
    @Override
    public List<UserInfoDTO> updateUser() {
        return null;
    }

    @Override
    public List<UserInfoDTO> findPage(PageRequest pageRequest) {
        return loginDao.findPage(pageRequest);
    }
}
