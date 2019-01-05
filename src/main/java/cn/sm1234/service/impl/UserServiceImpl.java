package cn.sm1234.service.impl;

import java.util.List;


import cn.sm1234.dao.UserMapper;
import cn.sm1234.domain.User;
import cn.sm1234.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	@Override
	public List<String> findPermissionByUserId(Integer userId) {
		return userMapper.findPermissionByUserId(userId);
	}
}
