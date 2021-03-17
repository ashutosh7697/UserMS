package com.infosys.UserMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.UserMS.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer,Integer>{
	
	Optional<Buyer> findByEmail(String email);
	Optional<Buyer> findByPhoneNumber(String phn);

}
