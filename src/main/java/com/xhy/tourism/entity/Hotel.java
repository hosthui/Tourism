package com.xhy.tourism.entity;

import java.io.Serializable;

public class Hotel implements Serializable {

	/**
	 * 酒店基本信息
	 */
	private static final long serialVersionUID = 5872670106751502880L;
	private String oldid;
    private String hid;  
    private String hname;
    private String address;
    private String image;
    private String phone;
    private String remark;
    private String star;  //不确定类型 先不写set get
    
	public String getOldid() {
		return oldid;
	}
	public void setOldid(String oldid) {
		this.oldid = oldid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
    
	
}
