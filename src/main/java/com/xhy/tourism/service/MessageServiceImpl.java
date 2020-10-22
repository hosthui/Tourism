package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhy.tourism.dao.MessageMapper;
import com.xhy.tourism.entity.Message;
import com.xhy.tourism.util.Result;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messMap;
	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		List<Message> melist = messMap.findAll();
//		for(Message ml : melist) {
//			System.out.println(ml.getUser().getUsername());
//		}
		return melist;
	}
	@Override
	public Result add(Map<String,Object> mesag) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = messMap.add(mesag);
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			 result.setFlag(false);
			 result.setMessage("·¢±íÊ§°Ü");
			 return result;	
		}
	}
	@Override
	public Result delmessage(int id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int r = messMap.del(id);
		if(r>0) {
			result.setFlag(true);
			return result;
		}else {
			 result.setFlag(false);
			 result.setMessage("É¾³ýÊ§°Ü");
			 return result;	
		}
	}

}
