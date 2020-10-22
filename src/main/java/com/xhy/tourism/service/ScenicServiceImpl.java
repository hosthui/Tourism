package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhy.tourism.dao.ScenicMapper;
import com.xhy.tourism.entity.Hotel;
import com.xhy.tourism.entity.Scenic;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;

@Service
public class ScenicServiceImpl implements ScenicService {

	@Autowired
	private ScenicMapper scenicmap;
//	��ѯ����
	@Override
	public List<Scenic> findSecicall() {
		// TODO Auto-generated method stub
		List<Scenic> list = scenicmap.findall();
		return list;
	}
//	��ѯ����
	@Override
	public Scenic findScenicById(String id) {
		Scenic scenic = scenicmap.findScenicById(id);
		return scenic;
	}
	
//	ɾ��
	@Override
	public Result delScenic(String id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = scenicmap.deleteScenic(id);
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("ɾ��ʧ��,û�иþ���");
			 return result;	
		}
	}
	
//	�޸�
	@Override
	public Result uapdteScenic(Scenic scneic) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = scenicmap.updateScenic(scneic);
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("�޸�ʧ��,û�иþ���");
			 return result;	
		}
	}
	
//	���
	@Override
	public Result addScenic(Scenic scenic) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = scenicmap.addScenic(scenic);
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("���ʧ��,������");
			 return result;	
		}
	}
//	��ҳ��ѯ
	@Override
	public List<Scenic> searchStudentsByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Scenic> sceniclist = scenicmap.searchStudentsByPage(map);
		return sceniclist;
	}
//	id��ѯ  ������   �Ƿ�������
	@Override
	public Result findScenicByIdResult(String id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Scenic scenic = scenicmap.findScenicById(id);
		if(scenic==null) {
			result.setFlag(true);
			return result;
		}else {
			 result.setFlag(false);
			 result.setMessage("id��ռ�ã��������");
			 return result;	
		}
	}
	
	@Override
	public List<Scenic> findByNameLike(Scenic scenic) {
		// TODO Auto-generated method stub
		List<Scenic> sceniclist = scenicmap.findUserByNameLike(scenic);
		for(Scenic scen : sceniclist) {
		  String info = scen.getSname();
   	      System.out.println(info);
	    }
		return sceniclist;
	}
	
	@Override
	public List<Scenic> findByName(Scenic scenic) {
		// TODO Auto-generated method stub
		List<Scenic> sceniclist = scenicmap.findByName(scenic);
		return sceniclist;
	}

}
