package com.xhy.tourism.dao;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Hotel;

public interface HotelMapper {

//	��ѯ����
	public List<Hotel> finAllHotels();
//	id��ѯ
	public Hotel findHotelById(String id);
//	ɾ��
	public int deleteHotel(String id);
//	�޸�
	public int updateHotel(Hotel hotel);
//	���
	public int addHotel(Hotel hotel);
//	��ҳ��ѯ
	public List<Hotel> searchStudentsByPage(Map<String, Object> map);
//	id �� name ��ѯ
	public List<Hotel> findUserByNameLike(Hotel hotel);
//	ģ����ѯ  ������
	public List<Hotel> findByName(Hotel hotel);
}
