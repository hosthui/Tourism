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
	
//	查询所有
	@Override
	public List<Hotel> findall() {
		List<Hotel> list = hotelmap.finAllHotels();
		System.out.print(list);
		return list;
	}
	
//	id查询
	@Override
	public Hotel findHotelById(String id) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelmap.findHotelById(id);
		return hotel;
	}
	
//	id删除
	@Override
	public Result deleteHotel(String id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int rows = hotelmap.deleteHotel(id);
		if(rows>0) {
			result.setFlag(true);
			result.setMessage("删除成功");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("删除失败，请重试");
			 return result;	
		}
	}
	
//	修改
	@Override
	public Result updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = hotelmap.updateHotel(hotel);
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
	
//	添加
	@Override
	public Result addHotel(Hotel hotel) {
		Result result = new Result();
		int r = hotelmap.addHotel(hotel);
		if(r>0) {
			result.setFlag(true);
			result.setMessage("添加成功");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("添加失败，请重试");
			 return result;	
		}
	}
//	分页查询
	@Override
	public List<Hotel> searchStudentsByPage(Map<String, Object> map) {
		List<Hotel> hotellist = hotelmap.searchStudentsByPage(map);
		return hotellist;
	}

//	id查询  是否可以添加
	@Override
	public Result findHotelByIdResult(String id) {
		Result result = new Result();
		Hotel hotel = hotelmap.findHotelById(id);
		if(hotel==null) {
			result.setFlag(true);
			result.setMessage("不存在，可以添加");
			return result;
		}else {
			result.setFlag(false);
			 result.setMessage("存在这个id，不能添加");
			 return result;	
		}
	}
//模糊查询
	@Override
	public List<Hotel> findByNameLike(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Hotel> hotellist = hotelmap.findUserByNameLike(hotel);
		for(Hotel t:hotellist) {
			System.out.print(t.getHname());
		}
		return hotellist;
	}
//不同条件查询
	@Override
	public List<Hotel> findByName(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Hotel> hotellist = hotelmap.findByName(hotel);
		return hotellist;
	}

}
