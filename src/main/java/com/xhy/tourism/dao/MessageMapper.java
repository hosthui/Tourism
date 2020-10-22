package com.xhy.tourism.dao;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Message;

public interface MessageMapper {

	public List<Message> findAll();
    public int add(Map<String, Object> mesag);
    public int del(int id);
	
}
