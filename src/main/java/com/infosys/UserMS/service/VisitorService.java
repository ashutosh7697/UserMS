package com.infosys.UserMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.infosys.UserMS.dto.ProductModel;
import com.infosys.UserMS.entity.Buyer;
import com.infosys.UserMS.repository.BuyerRepository;

@Service
public class VisitorService {
	
	@Autowired
	BuyerRepository buyRepo;
	
	@Value("${productGetAll}")
	String productGetAll;
	
//	Going through Productlist
	public ProductModel[] allProduct(@PathVariable String contact) throws Exception{
		Optional<Buyer> buy=buyRepo.findByPhoneNumber(contact);
		if(buy.isPresent()) {
			ProductModel[] prods= new RestTemplate().getForObject(productGetAll,ProductModel[].class);
			return prods;
		}
		else {
			throw new Exception("No buyer with g=provided contact no is present");
		}
		
		
	}
	

}
