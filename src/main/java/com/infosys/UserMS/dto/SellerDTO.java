package com.infosys.UserMS.dto;

import com.infosys.UserMS.entity.Seller;

public class SellerDTO {
	
	Integer sellerId;
	String name;
	String email;
	String phoneNumber;
	String password;
	Integer isActive;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	public static SellerDTO valueOf(Seller s) {
		SellerDTO sel = new SellerDTO();
		sel.setEmail(s.getEmail());
		sel.setIsActive(s.getIsActive());
		sel.setName(s.getName());
		sel.setPassword(s.getPassword());
		sel.setPhoneNumber(s.getPhoneNumber());
		sel.setSellerId(s.getSellerId());
		
		return sel;
	}
	
	public static Seller createEntity(SellerDTO s) {
		Seller sel=new Seller();
		sel.setEmail(s.getEmail());
		sel.setIsActive(s.getIsActive());
		sel.setName(s.getName());
		sel.setPassword(s.getPassword());
		sel.setPhoneNumber(s.getPhoneNumber());
		sel.setSellerId(s.getSellerId());
		
		return sel;
	}
	public SellerDTO(Integer sellerId,String name,String email,String phoneNumber,String password,Integer isActive) {
		this.setEmail(email);
		this.setIsActive(isActive);
		this.setName(name);
		this.setPassword(password);
		this.setPhoneNumber(phoneNumber);
		this.setSellerId(sellerId);
		}
	public SellerDTO() {
		super();
	}
	
}
