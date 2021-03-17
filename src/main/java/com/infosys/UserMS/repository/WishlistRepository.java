package com.infosys.UserMS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.UserMS.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer>{
	Optional<Wishlist> findByBUYERIDAndPRODID(Integer b,Integer p);
	List<Wishlist> findByBUYERID(Integer b);

}
