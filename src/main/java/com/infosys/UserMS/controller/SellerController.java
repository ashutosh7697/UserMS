package com.infosys.UserMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.dto.ProductModel;
import com.infosys.UserMS.dto.SellerDTO;
import com.infosys.UserMS.service.SellerService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/seller")
public class SellerController {
	
	@Autowired
	SellerService selserv;
	
	private Logger log=LoggerFactory.getLogger(this.getClass());

	
	//login
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		try {
			return new ResponseEntity<String>(selserv.login(loginDTO),HttpStatus.OK);

		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	//Register buyer
	@PostMapping(value = "/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerBuyer(@RequestBody SellerDTO sDTO) {
		try {
			return new ResponseEntity<String>(selserv.sellerRegistration(sDTO),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Get all buyers
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SellerDTO>> getAllsellers() {
		try {
			return new ResponseEntity<List<SellerDTO>>(selserv.getAllSellers(),HttpStatus.OK);

		}
		catch(Exception e) {
			
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	
	//delete seller
	@DeleteMapping(value = "/deactivate/{sellerId}")
	public ResponseEntity<String> deleteSeller(@PathVariable Integer sellerId) {
		try {
			return new ResponseEntity<String>(selserv.deleteSeller(sellerId),HttpStatus.OK);

		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
//	//seller add product
//	@PostMapping(value = "/addProduct",  consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> addProduct(@RequestBody ProductModel prodModel) {
//		try {
//			new RestTemplate().postForObject("http://localhost:9001/product/add", prodModel, ProductModel.class); 
//			return new ResponseEntity<String>("Product added Successfully",HttpStatus.OK);
//			}
//		catch(Exception e) {
//			log.error(e.getMessage());
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
//	
//	}
//
//	
////	



}
