package com.infosys.UserMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.infosys.UserMS.Validator.CheckValidation;
import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.dto.ProductModel;
import com.infosys.UserMS.dto.SellerDTO;
import com.infosys.UserMS.entity.Seller;
import com.infosys.UserMS.repository.SellerRepository;

@Service
@CrossOrigin
public class SellerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SellerRepository selrepo;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
	
	//login
		public String login(LoginDTO loginDTO) throws Exception{				/*we can use validator functions here also or in controller*/
			if(!CheckValidation.LoginValidation(loginDTO))
				throw new Exception("Credentials format not correct");
			Optional<Seller> cust=selrepo.findByEmail(loginDTO.getEmail());
			if(cust.isPresent() && cust.get() != null && cust.get().getPassword().equals(loginDTO.getPassword())) {
				return "Logged In successfully";
			}
			else {
				throw new Exception("Credentials not correct");

			}
			}
		// Register a new Buyer
				public String sellerRegistration(SellerDTO sel) throws Exception{
					logger.info("Registration request for Seller {}", sel);
					if(!CheckValidation.sellerValidation(sel))
						throw new Exception("Credentials format not correct");
					Seller b=new Seller();
					b=SellerDTO.createEntity(sel);
					
					selrepo.save(b);
					return "Registered Successfully with Seller id:"+sel.getSellerId();
				}
				//Get All Seller
				public List<SellerDTO> getAllSellers() throws Exception{
					List<Seller> sellers = selrepo.findAll();
					List<SellerDTO> sellerDTOs = new ArrayList<>();
					if(sellers.isEmpty()) {
						throw new Exception("No seller is registered yet");
					}

					for (Seller s:sellers) {
						SellerDTO sel=SellerDTO.valueOf(s);
						sellerDTOs.add(sel);
					}


					return sellerDTOs;
				}
				//delete a seller
				public String deleteSeller(Integer id) throws Exception {
					Optional<Seller> buy=selrepo.findById(id);
					if(buy.isPresent() && buy.get() != null) {
						selrepo.deleteById(id);
						return ("Seller with sellerid {} deleted"+id);
					}
					else {
						throw new Exception("No seller Found with Provided Id: "+id);
					}
				}
				
////				Add product
//				public ProductModel addProduct(ProductModel product) throws Exception{
//				
//					
//				}
				
				

}
