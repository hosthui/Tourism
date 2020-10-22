package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhy.tourism.dao.HotelMapper;
import com.xhy.tourism.entity.Hotel;
import com.xhy.tourism.entity.Scenic;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelMapper hotelmap;
	
//	��ѯ����
	@Override
	public List<Hotel> findall() {
		List<Hotel> list = hotelmap.finAllHotels();
		System.out.print(list);
		return list;
	}
	
//	id��ѯ
	@Override
	public Hotel findHotelById(String id) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelmap.findHotelById(id);
		return hotel;
	}
	
//	idɾ��
	@Override
	public Result deleteHotel(String id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int rows = hotelmap.deleteHotel(id);
		if(rows>0) {
			result.setFlag(true);
			result.setMessage("ɾ���ɹ�");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("ɾ��ʧ�ܣ�������");
			 return result;	
		}
	}
	
//	�޸�
	@Override
	public Result updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = hotelmap.updateHotel(hotel);
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
	
//	���
	@Override
	public Result addHotel(Hotel hotel) {
		Result result = new Result();
		int r = hotelmap.addHotel(hotel);
		if(r>0) {
			result.setFlag(true);
			result.setMessage("��ӳɹ�");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("���ʧ�ܣ�������");
			 return result;	
		}
	}
//	��ҳ��ѯ
	@Override
	public List<Hotel> searchStudentsByPage(Map<String, Object> map) {
		List<Hotel> hotellist = hotelmap.searchStudentsByPage(map);
		return hotellist;
	}

//	id��ѯ  �Ƿ�������
	@Override
	public Result findHotelByIdResult(String id) {
		Result result = new Result();
		Hotel hotel = hotelmap.findHotelById(id);
		if(hotel==null) {
			result.setFlag(true);
			result.setMessage("�����ڣ��������");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("�������id���������");
			 return result;	
		}
	}
//ģ����ѯ
	@Override
	public List<Hotel> findByNameLike(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Hotel> hotellist = hotelmap.findUserByNameLike(hotel);
		for(Hotel t:hotellist) {
			System.out.print(t.getHname());
		}
		return hotellist;
	}
//��ͬ������ѯ
	@Override
	public List<Hotel> findByName(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Hotel> hotellist = hotelmap.findByName(hotel);
		return hotellist;
	}

}
