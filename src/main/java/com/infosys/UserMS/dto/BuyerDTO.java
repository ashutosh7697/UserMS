package com.infosys.UserMS.dto;

import com.infosys.UserMS.entity.Buyer;

public class BuyerDTO {
	
	Integer buyerId;
	String name;
	String email;
	String phoneNumber;
	String password;
	Integer isPriviliged;
	Integer rewardPoints;
	Integer isActive;
	
	
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
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
	public Integer getIsPriviliged() {
		return isPriviliged;
	}
	public void setIsPriviliged(Integer isPriviliged) {
		this.isPriviliged = isPriviliged;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public BuyerDTO(Integer buyerId,String name,
	String email,
	String phoneNumber,
	String password,
	Integer isPriviliged,
	Integer rewardPoints,
	Integer isActive){
		this.setBuyerId(buyerId);
		this.setEmail(email);
		this.setIsActive(isActive);
		this.setIsPriviliged(isPriviliged);
		this.setName(name);
		this.setPassword(password);
		this.setPhoneNumber(phoneNumber);
		this.setRewardPoints(rewardPoints);
		
	}
	public BuyerDTO() {
		
	}
	
	public static BuyerDTO valueOf(Buyer buy1) {
		BuyerDTO buy=new BuyerDTO();
		buy.setBuyerId(buy1.getBuyerId());
		buy.setEmail(buy1.getEmail());
		buy.setIsActive(buy1.getIsActive());
		buy.setIsPriviliged(buy1.getIsPriviliged());
		buy.setName(buy1.getName());
		buy.setPassword(buy1.getPassword());
		buy.setPhoneNumber(buy1.getPhoneNumber());
		buy.setRewardPoints(buy1.getRewardPoints());
		
		return buy;
	}
	public Buyer createEntity(BuyerDTO buy1) {
		Buyer buy=new Buyer();
//		buy.setBuyerId(buy1.getBuyerId());
		buy.setEmail(buy1.getEmail());
		buy.setIsActive(buy1.getIsActive());
		buy.setIsPriviliged(buy1.getIsPriviliged());
		buy.setName(buy1.getName());
		buy.setPassword(buy1.getPassword());
		buy.setPhoneNumber(buy1.getPhoneNumber());
		buy.setRewardPoints(buy1.getRewardPoints());
		
		return buy;
	}
	
}

