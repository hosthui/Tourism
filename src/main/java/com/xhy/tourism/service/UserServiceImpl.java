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
	
//	ע��
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
//	��ѯ����
	@Override
	public List<User> findall() {
		List<User> userlist = userdao.finAllUsers();
		return userlist;
	}
//	��¼
	@Override
	public Result login(User user) {
		Result result = new Result();
        User userlist =  userdao.findUserByName(user);
		 if(userlist!=null) {
			 result.setFlag(true);
				return result;
		 }else {
			 result.setFlag(false);
			 result.setMessage("�û��������������");
			 return result;
		 }
	}
//	ɾ��
	@Override
	public Result deleteuser(User user) {
		Result result = new Result();
		int r = userdao.deleteUser(user.getUid());
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			 result.setFlag(false);
			 result.setMessage("ɾ��ʧ��,û�и��û�");
			 return result;	
		}
	}
//	�޸�
	@Override
	public Result updateUser(User user) {
		Result result = new Result();
		int r = userdao.updateUser(user);
		if(r>0) {
			result.setFlag(true);
			result.setMessage("�޸ĳɹ�");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("�޸�ʧ�ܣ�������");
			 return result;	
		}
	}
//	��ҳ��ѯ
	@Override
	public List<User> searchStudentsByPage(Map<String, Object> map) {
		List<User> userlist = userdao.searchStudentsByPage(map);
		return userlist;
	}
//	username��ѯ ������ �Ƿ�����û��� 
	@Override
	public Result findUserByNameResult(User user) {
		Result result = new Result();
        User userlist =  userdao.findUserByNameResult(user);
		 if(userlist==null) {
			 result.setFlag(true);
				return result;
		 }else {
			 result.setFlag(false);
			 result.setMessage("�û����Ѵ��ڣ������");
			 return result;
		 }
	}
//	ģ����ѯ
	@Override
	public List<User> findByNameLike(String username) {
		List<User> userlist = userdao.findUserByNameLike(username);
		for(User user : userlist) {
		  String info = user.getUsername();
   	      System.out.println(info);
	    }
		return userlist;
	}
//	ģ����ѯ  
	@Override
	public User findByName(String username) {
		User user = userdao.findByName(username);
		return user;
	}

	
}
