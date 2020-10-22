package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Hotel;
import com.xhy.tourism.entity.Scenic;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;

public interface HotelService {

	public List<Hotel> findall();
	public Hotel findHotelById(String id);
	public Result deleteHotel(String id);
	public Result updateHotel(Hotel hotel);
	public Result addHotel(Hotel hotel);
	public List<Hotel> searchStudentsByPage(Map<String, Object> map);
	public Result findHotelByIdResult(String id);
	public List<Hotel> findByNameLike(Hotel hotel);
	public List<Hotel> findByName(Hotel hotel);
}
