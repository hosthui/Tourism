package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;


public interface UserService {

	public Result register(User user);
	public List<User> findall();
	public Result login(User user);
	public Result deleteuser(User user);
	public Result updateUser(User user);
	public List<User> searchStudentsByPage(Map<String, Object> map);
	public Result findUserByNameResult(User user);
	public List<User> findByNameLike(String username);
	public User findByName(String username);
}
