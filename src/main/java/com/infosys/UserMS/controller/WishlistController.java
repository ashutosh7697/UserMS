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
import com.infosys.UserMS.service.WishlistService;

@RestController
@CrossOrigin
@RequestMapping(value="api/wishlist")
public class WishlistController {
	@Autowired
	WishlistService wishServ;
	@Value("${productGet}")
	String productGet;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	//to add product to Wishlist
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody WishlistDTO w) {
		try {
			return  new ResponseEntity<String>(wishServ.addProduct(w),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(value = "/addProductToCart",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody CartDTO c) {
		try {
			return  new ResponseEntity<String>(wishServ.addProductToCart(c),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductModel>> getAll(@PathVariable Integer buyerId) {
		try {
			List<WishlistDTO> ca=wishServ.getAllProducts(buyerId);
			List<ProductModel> prods=new ArrayList<ProductModel>();
			for(WishlistDTO c:ca) {
				prods.add(new RestTemplate().getForObject(productGet+c.getProdId(),ProductModel.class));
			}
			return new ResponseEntity<List<ProductModel>>(prods,HttpStatus.OK);
		}
		catch(Exception e) {
			
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

}
