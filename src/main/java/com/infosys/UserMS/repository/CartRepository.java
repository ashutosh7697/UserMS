package com.infosys.UserMS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.UserMS.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
	Optional<Cart> findByBUYERIDAndPRODID(Integer b,Integer p);
	List<Cart> findByBUYERID(Integer b);
	
	}
