package cn.sm1234.service;

import java.util.List;

import cn.sm1234.domain.User;

public interface UserService {
	public User findByName(String name);
	public List<String> findPermissionByUserId(Integer userId);
}
