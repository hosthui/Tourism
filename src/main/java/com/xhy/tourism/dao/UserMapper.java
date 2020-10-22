package com.xhy.tourism.dao;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.User;


public interface UserMapper {

//	��ѯ���� ����ҳ
	public List<User> finAllUsers();
//	���
	public int addUser(User user);
//	���֡����͡����� ��ѯ 
	public User findUserByName(User user);
//	ɾ��
	public int deleteUser(Integer id);
//	�޸�
	public int updateUser(User user);
//	��ҳ��ѯ
	public List<User> searchStudentsByPage(Map<String, Object> map);
//	���֡����Ͳ�ѯ�������� 
	public User findUserByNameResult(User user);
//	ģ����ѯ
	public List<User> findUserByNameLike(String username);
	
	public User findByName(String username);
	
	public User findById(String uid);
}
