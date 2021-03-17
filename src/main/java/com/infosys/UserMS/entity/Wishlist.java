package com.infosys.UserMS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
@IdClass(MyKey.class)

public class Wishlist {
	   
	@Id
    private Integer BUYERID;

	@Id
	private Integer PRODID;

	public Integer getBUYERID() {
		return BUYERID;
	}

	public void setBUYERID(Integer bUYERID) {
		BUYERID = bUYERID;
	}

	public Integer getPRODID() {
		return PRODID;
	}

	public void setPRODID(Integer pRODID) {
		PRODID = pRODID;
	}


}

