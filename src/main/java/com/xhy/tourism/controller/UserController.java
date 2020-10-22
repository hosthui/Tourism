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
	
//	ʹ���˹����� ��¼ ��ѯ����
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Result login(@RequestBody User user) {
		return userService.login(user);
	}
	
//	�����࣬�鿴�Ƿ��Ѿ������������
	@RequestMapping(value="findUserByNameResult",method=RequestMethod.POST)
	@ResponseBody
	public Result findUserByNameResult(@RequestBody User user) {
		return userService.findUserByNameResult(user);
	}
	
//	ʹ���˹�����  ע��  ���
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public Result register(@RequestBody User user) {
		return userService.register(user);
	}
	
//	��ѯ����
	@RequestMapping(value="findall",method=RequestMethod.GET)
	@ResponseBody
	public List<User> finall() {
		return this.userService.findall();
	}	
	
//	ɾ��
	@RequestMapping(value="deleteuser",method=RequestMethod.POST)
	@ResponseBody
	public Result deleteuser(@RequestBody User user) {
		return userService.deleteuser(user);
	}
	
//	�޸�
	@RequestMapping(value="updateuser",method=RequestMethod.POST)
	@ResponseBody
	public Result updateuser(@RequestBody User user) {
		System.out.print(user.getAdmin());
		return userService.updateUser(user);
	}
	
//	��ҳ��ѯ
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findByPage(@RequestBody Utilfind util){
		Map<String,Object> map = new HashMap<String,Object>();
	   	map.put("startRow",(util.getPage()-1)*util.getRows() );
	   	map.put("PageSize", util.getRows());
		return userService.searchStudentsByPage(map);
	}
	
//	ģ����ѯ  ��ѯ ��username��  һ�����߶��
	@RequestMapping(value="findByNameLike",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findByNameLike(@RequestBody User user) {
		return this.userService.findByNameLike(user.getUsername());
	}
//	�û�������ѯ
	@RequestMapping(value="findByName",method=RequestMethod.POST)
	@ResponseBody
	public User findByName(@RequestBody User user) {
		return this.userService.findByName(user.getUsername());
	}
}
