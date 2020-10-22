package com.xhy.tourism.dao;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Scenic;


public interface ScenicMapper {

//	��ѯ���У�����ҳ
	public List<Scenic> findall();
//	�����Ϣ
	public int addScenic(Scenic scenic);
//	��ѯ������Ϣ
	public Scenic findScenicById(String sid);
//	ɾ����Ϣ
	public int deleteScenic(String sid);
//	�޸���Ϣ
	public int updateScenic(Scenic scenic);
//	��ҳ��ѯ
	public List<Scenic> searchStudentsByPage(Map<String, Object> map);
//	ģ����ѯ
	public List<Scenic> findUserByNameLike(Scenic scenic);
//	������
	public List<Scenic> findByName(Scenic scenic);
}
