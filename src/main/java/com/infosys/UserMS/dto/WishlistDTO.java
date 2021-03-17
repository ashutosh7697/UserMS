package com.infosys.UserMS.dto;

import com.infosys.UserMS.entity.Wishlist;

public class WishlistDTO {
	Integer buyerId;

	Integer prodId;

	public Integer getBuyerId() {
		return buyerId;
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
	
	public static WishlistDTO valueOf(Wishlist w) { 
		WishlistDTO wish=new WishlistDTO();
		wish.setBuyerId(w.getBUYERID());
		wish.setProdId(w.getPRODID());
		return wish;
	}
	public static Wishlist createEntity(WishlistDTO w2) {
		Wishlist w=new Wishlist();
		w.setBUYERID(w2.getBuyerId());
		w.setPRODID(w2.getProdId());
		return w;
	}
	
	public WishlistDTO(Integer buyerId,Integer prodId){
		this.setBuyerId(buyerId);
		this.setProdId(prodId);
	}
	public WishlistDTO() {
		super();
	}


}
