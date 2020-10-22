package com.xhy.tourism.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xhy.tourism.entity.User;
import com.xhy.tourism.entity.Utilfind;
import com.xhy.tourism.service.UserService;
import com.xhy.tourism.util.Result;


@Controller
@RequestMapping("web/user")
public class UserController {
	@Autowired
	private UserService userService;
	
//	使用了工具类 登录 查询当个
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Result login(@RequestBody User user) {
		return userService.login(user);
	}
	
//	工具类，查看是否已经存在这个名字
	@RequestMapping(value="findUserByNameResult",method=RequestMethod.POST)
	@ResponseBody
	public Result findUserByNameResult(@RequestBody User user) {
		return userService.findUserByNameResult(user);
	}
	
//	使用了工具类  注册  添加
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public Result register(@RequestBody User user) {
		return userService.register(user);
	}
	
//	查询所有
	@RequestMapping(value="findall",method=RequestMethod.GET)
	@ResponseBody
	public List<User> finall() {
		return this.userService.findall();
	}	
	
//	删除
	@RequestMapping(value="deleteuser",method=RequestMethod.POST)
	@ResponseBody
	public Result deleteuser(@RequestBody User user) {
		return userService.deleteuser(user);
	}
	
//	修改
	@RequestMapping(value="updateuser",method=RequestMethod.POST)
	@ResponseBody
	public Result updateuser(@RequestBody User user) {
		System.out.print(user.getAdmin());
		return userService.updateUser(user);
	}
	
//	分页查询
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findByPage(@RequestBody Utilfind util){
		Map<String,Object> map = new HashMap<String,Object>();
	   	map.put("startRow",(util.getPage()-1)*util.getRows() );
	   	map.put("PageSize", util.getRows());
		return userService.searchStudentsByPage(map);
	}
	
//	模糊查询  查询 按username来  一个或者多个
	@RequestMapping(value="findByNameLike",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findByNameLike(@RequestBody User user) {
		return this.userService.findByNameLike(user.getUsername());
	}
//	用户名来查询
	@RequestMapping(value="findByName",method=RequestMethod.POST)
	@ResponseBody
	public User findByName(@RequestBody User user) {
		return this.userService.findByName(user.getUsername());
	}
}
