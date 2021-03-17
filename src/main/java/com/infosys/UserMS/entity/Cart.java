package com.infosys.UserMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="cart")
@IdClass(MyKey.class)
public class Cart {
	
	   /* This is the primary key class , having prodid and buyerid*/
	@Id
    private Integer BUYERID;

	@Id
	private Integer PRODID;
	
	
	
	@Column(name="QUANTITY",nullable = false)
	Integer quantity;
	

	public Integer getBuyerId() {
		return BUYERID;
	}

	public void setBuyerId(Integer buyerId) {
		this.BUYERID = buyerId;
	}

	public Integer getProdId() {
		return PRODID;
	}

	public void setProdId(Integer prodId) {
		this.PRODID = prodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Cart() {
		super();
	}

}
