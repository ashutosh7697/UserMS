package com.infosys.UserMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.UserMS.dto.CartDTO;
import com.infosys.UserMS.dto.WishlistDTO;
import com.infosys.UserMS.entity.Wishlist;
import com.infosys.UserMS.repository.WishlistRepository;

@Service
public class WishlistService {
	 @Autowired
	 WishlistRepository wishRepo;
	 @Autowired
	 CartService cartserv;
	 
//	 add product to wishList
	 public String addProduct(WishlistDTO w) throws Exception{
		 Optional<Wishlist> w1=wishRepo.findByBUYERIDAndPRODID(w.getBuyerId(),w.getProdId());

		 Wishlist wish=WishlistDTO.createEntity(w);
		 if(w1.isEmpty()) {
			 wishRepo.save(wish);
			 return "prodcut added to wishlisty Successfully";
		 }
		 else {
			 throw new Exception("Product is already in the wishList");
		 }
	 }
	 
	 public String addProductToCart(CartDTO c) throws Exception{
		 Optional<Wishlist> w=wishRepo.findByBUYERIDAndPRODID(c.getBuyerId(), c.getProdId());
		 if(w.isPresent() && w.get() != null) {
			    cartserv.addToCart(c);
				wishRepo.delete(w.get());
				return "Product Successfully Added to cart";
			}
		 else {
			 throw new Exception("Product is not Present in your WishList, First add it.");
		 }
	 }
	 
	 public List<WishlistDTO> getAllProducts(Integer b) throws Exception{
		 List<Wishlist> wishs=wishRepo.findByBUYERID(b);
		 if(wishs.isEmpty()) {
			 throw new Exception("No Iteams in you wishlist");
		 }
		 List<WishlistDTO> ws=new ArrayList<WishlistDTO>();
		 for(Wishlist wish: wishs) {
			 ws.add(WishlistDTO.valueOf(wish));
		 }
		 return ws;
	 }
	 

}
