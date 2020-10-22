package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Message;
import com.xhy.tourism.util.Result;

public interface MessageService {

	public List<Message> findAll();
	public Result add(Map<String, Object> mess);
	public Result delmessage(int id);
}
