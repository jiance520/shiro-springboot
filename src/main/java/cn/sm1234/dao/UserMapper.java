package cn.sm1234.dao;

import java.util.List;

import cn.sm1234.domain.User;

public interface UserMapper{
//	根据用户名查询用户
	public User findByName(String name);
//	根据用户ID，查询用户拥有的资源授权码
	public List<String> findPermissionByUserId(Integer userId);
}
