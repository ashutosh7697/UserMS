package com.infosys.UserMS.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="buyer")
public class Buyer{
	
	@Id
	@Column(name = "BUYERID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer buyerId;
	@Column(name="NAME",nullable = false, length = 45)
	String name;
	@Column(name="EMAIL",nullable = false, length = 45)
	String email;
	@Column(name="PHONENUMBER",nullable = false, length = 45)
	String phoneNumber;
	@Column(name="PASSWORD",nullable = false, length = 45)
	String password;
	@Column(name="ISPRIVILIGED",nullable = true, columnDefinition = "TINYINT")
	Integer isPriviliged;
	@Column(name="REWARDPOINTS",nullable = true)
	Integer rewardPoints;
	@Column(name="ISACTIVE",nullable = true, columnDefinition = "TINYINT")
	Integer isActive;
	
	
	
	public Integer getBuyerId() {
		return buyerId;
	}
	
//	public void setBuyerId(Integer buyerId) {
//		this.buyerId = buyerId;
//	}
	
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
	public Buyer() {
		super();
	}
	
	

}
