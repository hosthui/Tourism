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
import com.xhy.tourism.entity.Utilfind;
import com.xhy.tourism.service.ScenicService;
import com.xhy.tourism.util.Result;

@Controller
@RequestMapping("web/scenic")
public class ScenicController {
	@Autowired
	private ScenicService scenicservice;
	
//	查询所有
	@RequestMapping(value="findall",method=RequestMethod.GET)
	@ResponseBody
	public List<Scenic> finall() {
		return this.scenicservice.findSecicall();
	}
	
//	根据id查询
	@RequestMapping(value="findScenicById",method=RequestMethod.POST)
	@ResponseBody
	public Scenic findScenicById(@RequestBody Scenic scenic) {
		return scenicservice.findScenicById(scenic.getSid());
	}
	
//	工具类 查询是否存在这个id
	@RequestMapping(value="findScenicByIdResult",method=RequestMethod.POST)
	@ResponseBody
	public Result findScenicByIdResult(@RequestBody Scenic scenic) {
		return scenicservice.findScenicByIdResult(scenic.getSid());
	}
	
//	删除
	@RequestMapping(value="deletescenic",method=RequestMethod.POST)
	@ResponseBody
	public Result deletescenic(@RequestBody Scenic scenic) {
		return scenicservice.delScenic(scenic.getSid());
	}
	
//	修改
	@RequestMapping(value="updatescenic",method=RequestMethod.POST)
	@ResponseBody
	public Result updatescenic(@RequestBody Scenic scenic) {
		return scenicservice.uapdteScenic(scenic);
	}
	
//	添加
	@RequestMapping(value="addscenic",method=RequestMethod.POST)
	@ResponseBody
	public Result addscenic(@RequestBody Scenic scenic) {
		return scenicservice.addScenic(scenic);
	}
	
//	分页查询
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	@ResponseBody
	public List<Scenic> findByPage(@RequestBody Utilfind util){
		System.out.print(util.getRows());
		Map<String,Object> map = new HashMap<String,Object>();
	   	map.put("startRow",(util.getPage()-1)*util.getRows() );
	   	map.put("PageSize", util.getRows());
		return scenicservice.searchStudentsByPage(map);
	}
	
	@RequestMapping(value="findByNameLike",method=RequestMethod.POST)
	@ResponseBody
	public List<Scenic> findByNameLike(@RequestBody Scenic scenic) {
		return this.scenicservice.findByNameLike(scenic);
	}
	
	@RequestMapping(value="findByName",method=RequestMethod.POST)
	@ResponseBody
	public List<Scenic> findByName(@RequestBody Scenic scenic) {
		return this.scenicservice.findByName(scenic);
	}
}
