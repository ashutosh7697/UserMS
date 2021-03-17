package com.infosys.UserMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.UserMS.dto.CartDTO;
import com.infosys.UserMS.entity.Cart;
import com.infosys.UserMS.repository.CartRepository;


@Service
public class CartService {
	
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CartRepository cartrepo;
	
	// Add item to cart
	public String addToCart(CartDTO c) throws Exception {
		Cart cart=CartDTO.createEntity(c);
		Optional<Cart> c1=cartrepo.findByBUYERIDAndPRODID(c.getBuyerId(), c.getProdId());
		if(c1.isEmpty()) {
			log.info("Iteam added to your cart with prodid :"+c.getProdId());
			cartrepo.save(cart);
			return ("Iteam added to your cart with prodid :"+c.getProdId());
		}
		else {
			throw new Exception("Product is Already in your cart");
		}
		
	}
	
	public String deleteFromCart(Integer b,Integer p) throws Exception{
		
		Optional<Cart> c=cartrepo.findByBUYERIDAndPRODID(b, p);
		if(c.isPresent() && c.get() != null) {
			cartrepo.delete(c.get());
			return ("Iteam deleted your cart with prodid :"+p);
		}
		else {
			throw new Exception("No Iteam Found for this productId");

		}
	}
	
	public List<CartDTO> showAll(Integer buyerId) throws Exception{
		List<Cart> carts=cartrepo.findByBUYERID(buyerId);
		List<CartDTO> cs=new ArrayList<CartDTO>();
		if(carts.isEmpty()) {
			throw new Exception("No Iteam Found in your cart");
		}
		for(Cart cart:carts) {
			cs.add(CartDTO.valueOf(cart));
		}
		return cs;
		
		
	}
	

}