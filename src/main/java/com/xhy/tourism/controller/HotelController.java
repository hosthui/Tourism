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

import com.xhy.tourism.entity.Hotel;
import com.xhy.tourism.entity.Scenic;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.entity.Utilfind;
import com.xhy.tourism.service.HotelService;
import com.xhy.tourism.util.Result;

@Controller
@RequestMapping("web/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
//	��ѯ����
	@RequestMapping(value="findHotelalls",method=RequestMethod.GET)
	@ResponseBody
	public List<Hotel> finall() {
		return hotelService.findall();
	}
	
	
//	id��ѯ
	@RequestMapping(value="findHotelById",method=RequestMethod.POST)
	@ResponseBody
	public Hotel findHotelById(@RequestBody Hotel hotel) {
		return hotelService.findHotelById(hotel.getHid());
	}
	
//	��ѯ�Ƿ����  ����id
	@RequestMapping(value="findHotelByIdResult",method=RequestMethod.POST)
	@ResponseBody
	public Result findHotelByIdResult(@RequestBody Hotel hotel) {
		return hotelService.findHotelByIdResult(hotel.getHid());
	}
	
//	ɾ��   id
	@RequestMapping(value="delHlotel",method=RequestMethod.POST)
	@ResponseBody
	public Result delHlotel(@RequestBody Hotel hotel) {
		return hotelService.deleteHotel(hotel.getHid());
	}
	
//	�޸�
	@RequestMapping(value="updateHlotel",method=RequestMethod.POST)
	@ResponseBody
	public Result updateHlotel(@RequestBody Hotel hotel) {
		return this.hotelService.updateHotel(hotel);
	}
	
//	���
	@RequestMapping(value="addHlotel",method=RequestMethod.POST)
	@ResponseBody
	public Result addHlotel(@RequestBody Hotel hotel) {
		return this.hotelService.addHotel(hotel);
	}
	
//	��ҳ��ѯ
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	@ResponseBody
	public List<Hotel> findByPage(@RequestBody Utilfind util){
		Map<String,Object> map = new HashMap<String,Object>();
	   	map.put("startRow",(util.getPage()-1)*util.getRows() );
	   	map.put("PageSize", util.getRows());
		return hotelService.searchStudentsByPage(map);
	}
	
//	ģ����ѯ  ����hname ���ض����һ��  
	@RequestMapping(value="findByNameLike",method=RequestMethod.POST)
	@ResponseBody
	public List<Hotel> findByNameLike(@RequestBody Hotel hotel) {
		return this.hotelService.findByNameLike(hotel);
	}
	
//	ģ�� ������������ַ������
	@RequestMapping(value="findByName",method=RequestMethod.POST)
	@ResponseBody
	public List<Hotel> findByName(@RequestBody Hotel hotel) {
		return this.hotelService.findByName(hotel);
	}
	
}
