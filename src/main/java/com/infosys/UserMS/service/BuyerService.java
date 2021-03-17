package com.infosys.UserMS.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.UserMS.Validator.CheckValidation;
import com.infosys.UserMS.dto.BuyerDTO;
import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.entity.Buyer;
import com.infosys.UserMS.repository.BuyerRepository;

@Service
public class BuyerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository buyRepo;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				

	//login
	public String login(LoginDTO loginDTO) throws Exception {				/*we can use validator functions here also or in controller*/
		if(!CheckValidation.LoginValidation(loginDTO))
			throw new Exception("Sorry,Credentials format not correct");
		Optional<Buyer> cust=buyRepo.findByEmail(loginDTO.getEmail());
		if(cust.isPresent() && cust.get() != null && cust.get().getPassword().equals(loginDTO.getPassword())) {
			return "Welcome, You Logged In successfully";
		}
		else {
			throw new Exception("Sorry, Credentials not correct");

		}

		}
	// Register a new Buyer
		public String buyerRegistration(BuyerDTO buy) throws Exception{
			logger.info("Registration request for Buyer {}", buy);
			if(!CheckValidation.buyerValidation(buy))
				throw new Exception("Sorry, Credentials format not correct");
			Buyer b=new Buyer();
			b=buy.createEntity(buy);
			
			buyRepo.save(b);
			return "Regsitration Successfull";
		}
		//Get All Seller
		public List<BuyerDTO> getAllBuyers() throws Exception{
			List<Buyer> buyers = buyRepo.findAll();
			List<BuyerDTO> BuyerDTOs = new ArrayList<>();
			if(buyers.isEmpty()) {
				throw new Exception("No buyer is Registered");
			}
			for (Buyer b : buyers) {
				BuyerDTO buy=BuyerDTO.valueOf(b);
				BuyerDTOs.add(buy);
			}

			logger.info("Buyer details : {}", BuyerDTOs);
			return BuyerDTOs;
		}
		
		//delete a buyer
		public String deleteBuyer(Integer id) throws Exception{
			Optional<Buyer> buy=buyRepo.findById(id);
			if(buy.isPresent() && buy.get() != null) {
				logger.info("Buyer deleted with id: "+id);
				buyRepo.deleteById(id);
				return ("Buyer deleted with id: "+id);
			}
			else {
				throw new Exception("No buyer is registered with provided id");
			}
		}
		
		
		//Choose to be privileged Buyer
		public String optPrivilege(Integer id) throws Exception{
			Optional<Buyer> buy=buyRepo.findById(id);
			if(buy.isPresent() && buy.get() != null) {
				Buyer b=buyRepo.getOne(id);
				if(b.getRewardPoints()>=10000) {
					logger.info("Buyer with id {} is now privileged buyer"+id); 
					b.setIsPriviliged(1);
					buyRepo.save(b);
					return ("Buyer with id {} is now a privileged buyer"+id);
				}
				else {
					throw new Exception("Sorry, Rewardpoints are less than 10000");

				}
			}
			else {
				throw new Exception("No buyer is registered with provided id");

			}
		}
		
		
		//Updating reward points
		public String updateRewardPoints(Integer buyerId,Integer RewardPoints) throws Exception{
			Optional<Buyer> buy=buyRepo.findById(buyerId);
			if(buy.isPresent() && buy.get() != null) {
				buy.get().setRewardPoints(RewardPoints);
				buyRepo.save(buy.get());
				logger.info("RewarPoints Updated"); 
				return "RewarPoints Updated";
			}
			else {
				throw new Exception("No buyer is registered with provided id:"+buyerId);
			}
		}
		
		//get buyer details by id
		public BuyerDTO getBuyerByID(Integer id) throws Exception{
			
			BuyerDTO buyerDTO=null;
			Optional<Buyer> optional=buyRepo.findById(id);
			if(optional.isPresent()) {
				buyerDTO=BuyerDTO.valueOf(optional.get());
				logger.info("Fetched buyer info of buyer:"+buyerDTO); 

				return buyerDTO;
			}
			else {
				throw new Exception("No buyer is registered with provided id:"+id);
			}
		}
	
	
}
