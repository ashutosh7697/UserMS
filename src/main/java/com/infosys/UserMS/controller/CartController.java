package com.infosys.UserMS.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.UserMS.dto.CartDTO;
import com.infosys.UserMS.dto.ProductModel;
import com.infosys.UserMS.dto.WishlistDTO;
import com.infosys.UserMS.service.CartService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/cart")
public class CartController {
	
	@Autowired
	CartService cartServ;
	
	@Value("${productGet}")
	String productGet;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToCart(@RequestBody CartDTO c) {
		try {
			ProductModel prod=new RestTemplate().getForObject(productGet+c.getProdId(),ProductModel.class);
			if(prod!=null) {
				return new ResponseEntity<String>(cartServ.addToCart(c),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Product not found",HttpStatus.NOT_FOUND);

			}
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/remove/{buyerId}/{prodId}")
	public ResponseEntity<String> deleteCart(@PathVariable Integer buyerId,@PathVariable Integer prodId) {
		try {
			return new ResponseEntity<String>(cartServ.deleteFromCart(buyerId,prodId),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
//	public ResponseEntity<String> deleteCart(@RequestBody WishlistDTO w) {
//		try {
//			return new ResponseEntity<String>(cartServ.deleteFromCart(w.getBuyerId(),w.getProdId()),HttpStatus.OK);
//		}
//		catch(Exception e) {
//			log.error(e.getMessage());
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping(value = "/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CartDTO>> getAll(@PathVariable Integer buyerId) {
		try {
			return new ResponseEntity<List<CartDTO>>(cartServ.showAll(buyerId),HttpStatus.OK);
		}
catch(Exception e) {
			
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	
//	@GetMapping(value = "/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ProductModel>> getAll(@PathVariable Integer buyerId) {
//		try {
//			List<CartDTO> ca=cartServ.showAll(buyerId);
//			List<ProductModel> prods=new ArrayList<ProductModel>();
//			for(CartDTO c:ca) {
//				prods.add(new RestTemplate().getForObject(productGet+c.getProdId(),ProductModel.class));
//			}
//			return new ResponseEntity<List<ProductModel>>(prods,HttpStatus.OK);
//		}
//catch(Exception e) {
//			
//			log.error(e.getMessage());
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
//		}
//		
//	}
	
}
