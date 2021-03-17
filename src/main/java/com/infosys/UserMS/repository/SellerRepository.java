package com.infosys.UserMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.UserMS.entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, Integer>{


	Optional<Seller> findByEmail(String email);

}
