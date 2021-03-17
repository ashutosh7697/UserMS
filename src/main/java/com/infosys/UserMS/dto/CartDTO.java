package com.infosys.UserMS.dto;

import com.infosys.UserMS.entity.Cart;

public class CartDTO {
	
	Integer buyerId;

	Integer prodId;
	
	
	Integer quantity;
	
	public CartDTO(Integer buyerId,
	Integer prodId,
	Integer quantity) {
		this.setBuyerId(buyerId);
		this.setProdId(prodId);
		this.setQuantity(quantity);
		
	}
	public CartDTO() {
		super();
	}


	public Integer getQuantity() {
		return this.quantity;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public static CartDTO valueOf(Cart c) {
		CartDTO ca = new CartDTO();
		ca.setBuyerId(c.getBuyerId());
		ca.setProdId(c.getProdId());
		ca.setQuantity(c.getQuantity());
		return ca;
		
	}
	
	public static Cart createEntity(CartDTO c) {
		Cart m=new Cart();
		m.setBuyerId(c.getBuyerId());
		m.setProdId(c.getProdId());
		m.setQuantity(c.getQuantity());
		return m;
	}

}
