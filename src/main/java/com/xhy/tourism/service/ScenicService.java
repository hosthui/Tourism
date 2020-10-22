package com.xhy.tourism.service;

import java.util.List;
import java.util.Map;

import com.xhy.tourism.entity.Scenic;
import com.xhy.tourism.entity.User;
import com.xhy.tourism.util.Result;

public interface ScenicService {

	public List<Scenic> findSecicall();
	public Scenic findScenicById(String id);
	public Result delScenic(String id);
	public Result uapdteScenic(Scenic scneic);
	public Result addScenic(Scenic scenic);
	public List<Scenic> searchStudentsByPage(Map<String, Object> map);
	public Result findScenicByIdResult(String id);
	public List<Scenic> findByNameLike(Scenic scenic);
	public List<Scenic> findByName(Scenic scenic);
}
