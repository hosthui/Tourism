package com.xhy.tourism.util;

import java.util.List;

import com.xhy.tourism.entity.User;


public class Result {
	 private boolean flag;
	    private String message;
	    private List<User> user;
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public List<User> getUser() {
			return user;
		}
		public void setUser(List<User> user) {
			this.user = user;
		}
}
