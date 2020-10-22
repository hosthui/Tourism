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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xhy.tourism.entity.Message;
import com.xhy.tourism.service.MessageService;
import com.xhy.tourism.util.Result;


@Controller
@RequestMapping("web/message")
public class MessageController {

	@Autowired
	private MessageService messService;
	
//	查询所有
	@RequestMapping(value="findall",method=RequestMethod.GET)
	@ResponseBody
	public List<Message> finall() {
		return messService.findAll();
	}
//	添加
	@RequestMapping(value="addmessage",method=RequestMethod.POST)
	@ResponseBody
	public Result addmessage(@RequestBody String mesg) {
		Map<String,Object> mess=(Map<String, Object>) JSON.parse(mesg);
//		System.out.println(mess.get("user"));
		return messService.add(mess);
	}
	
	@RequestMapping(value="del",method=RequestMethod.POST)
	@ResponseBody
	public Result delmessage(@RequestBody Message message) {
		System.out.println(message.getTid()+"====");
		return messService.delmessage(message.getTid());
	}
	
}
