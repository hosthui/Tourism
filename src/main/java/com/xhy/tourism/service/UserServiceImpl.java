package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhy.tourism.dao.UserMapper;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userdao;
	
//	注册
	@Override
	public Result register(User user) {
		Result result = new Result();
		int r = userdao.addUser(user);
		if(r>0) {
			result.setFlag(true);
			return result;
		}
		return result;
	}
//	查询所有
	@Override
	public List<User> findall() {
		List<User> userlist = userdao.finAllUsers();
		return userlist;
	}
//	登录
	@Override
	public Result login(User user) {
		Result result = new Result();
        User userlist =  userdao.findUserByName(user);
		 if(userlist!=null) {
			 result.setFlag(true);
				return result;
		 }else {
			 result.setFlag(false);
			 result.setMessage("用户名或者密码错误");
			 return result;
		 }
	}
//	删除
	@Override
	public Result deleteuser(User user) {
		Result result = new Result();
		int r = userdao.deleteUser(user.getUid());
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			 result.setFlag(false);
			 result.setMessage("删除失败,没有该用户");
			 return result;	
		}
	}
//	修改
	@Override
	public Result updateUser(User user) {
		Result result = new Result();
		int r = userdao.updateUser(user);
		if(r>0) {
			result.setFlag(true);
			result.setMessage("修改成功");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("修改失败，请重试");
			 return result;	
		}
	}
//	分页查询
	@Override
	public List<User> searchStudentsByPage(Map<String, Object> map) {
		List<User> userlist = userdao.searchStudentsByPage(map);
		return userlist;
	}
//	username查询 工具类 是否存在用户名 
	@Override
	public Result findUserByNameResult(User user) {
		Result result = new Result();
        User userlist =  userdao.findUserByNameResult(user);
		 if(userlist==null) {
			 result.setFlag(true);
				return result;
		 }else {
			 result.setFlag(false);
			 result.setMessage("用户名已存在，请更换");
			 return result;
		 }
	}
//	模糊查询
	@Override
	public List<User> findByNameLike(String username) {
		List<User> userlist = userdao.findUserByNameLike(username);
		for(User user : userlist) {
		  String info = user.getUsername();
   	      System.out.println(info);
	    }
		return userlist;
	}
//	模糊查询  
	@Override
	public User findByName(String username) {
		User user = userdao.findByName(username);
		return user;
	}

	
}
