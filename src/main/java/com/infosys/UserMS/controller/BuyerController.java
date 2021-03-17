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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.UserMS.dto.BuyerDTO;
import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.service.BuyerService;

@RestController
@CrossOrigin
@RequestMapping(value="api/buyer")
public class BuyerController {
	
	@Autowired
	BuyerService buyserv;
	
	private Logger log=LoggerFactory.getLogger(this.getClass());

	
	//login
		@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
			try {
				return new ResponseEntity<String>(buyserv.login(loginDTO),HttpStatus.OK);

			}
			catch(Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		
		//Register buyer
		@PostMapping(value = "/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO bDTO) {
			try {
				return new ResponseEntity<String>(buyserv.buyerRegistration(bDTO),HttpStatus.OK);
			}
			catch(Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}

		
		//Get all buyers
		@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<BuyerDTO>> getAllBuyers() {
			try {
				return new ResponseEntity<List<BuyerDTO>>(buyserv.getAllBuyers(),HttpStatus.OK);

			}
			catch(Exception e) {
				
				log.error(e.getMessage());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			}
		}
		
		
		//delete buyer
		@DeleteMapping(value = "/deactivate/{buyerId}")
		public ResponseEntity<String> deleteBuyer(@PathVariable Integer buyerId) {
			try {
				return new ResponseEntity<String>(buyserv.deleteBuyer(buyerId),HttpStatus.OK);

			}
			catch(Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		
		//make buyer privileged
		@GetMapping(value="/privilege/{id}")
		public ResponseEntity<String> optForPrivelege(@PathVariable Integer id) {
			try {
					return new ResponseEntity<String>(buyserv.optPrivilege(id),HttpStatus.OK);
			}
			catch(Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		@PutMapping(value="/updateReward/{buyerId}/{rewardPoints}")
		public ResponseEntity<String> updateReward(@PathVariable Integer buyerId,@PathVariable Integer rewardPoints) {
			try {
				return new ResponseEntity<String>(buyserv.updateRewardPoints(buyerId, rewardPoints),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		}
		
		@GetMapping(value="/{id}")
		public ResponseEntity<BuyerDTO> getBuyerByID(@PathVariable Integer id) {
			try {
				return new ResponseEntity<BuyerDTO>(buyserv.getBuyerByID(id),HttpStatus.OK);

			}
			catch(Exception e) {
				log.error(e.getMessage());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			}
		}
	
	

}
