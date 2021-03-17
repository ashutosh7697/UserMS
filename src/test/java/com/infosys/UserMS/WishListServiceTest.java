package com.infosys.UserMS;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.infosys.UserMS.dto.WishlistDTO;
import com.infosys.UserMS.entity.Wishlist;
import com.infosys.UserMS.repository.WishlistRepository;
import com.infosys.UserMS.service.WishlistService;

@SpringBootTest
public class WishListServiceTest {

	@Autowired
	WishlistService wServ;
	@MockBean
	WishlistRepository wRepo;
	
	WishlistDTO w=new WishlistDTO(1,2);
	WishlistDTO w1=new WishlistDTO(1,3);
	

	@SuppressWarnings("deprecation")
	@Test
	public void addToWishlistTest() {
		
	Mockito.when(wRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(wRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.empty());

	String message;
	
	try {
		wServ.addProduct(w);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToWishlistTestN() {
		
	Mockito.when(wRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(wRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.of(WishlistDTO.createEntity(w)));

	String message;
	
	try {
		wServ.addProduct(w);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Product is already in the wishList", message);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToWishlistTestN2() {
		
	Mockito.when(wRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(wRepo.findByBUYERIDAndPRODID(1, 3)).thenReturn(Optional.of(WishlistDTO.createEntity(w1)));

	String message;
	
	try {
		wServ.addProduct(w1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Product is already in the wishList", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getAllTest() {
		List<Wishlist> l=new ArrayList<Wishlist>();
		l.add(WishlistDTO.createEntity(w));
		l.add(WishlistDTO.createEntity(w1));

	Mockito.when(wRepo.findByBUYERID(1)).thenReturn(l);

	String message;
	
	try {
		wServ.getAllProducts(1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void getAllTestN() {
		List<Wishlist> l1=new ArrayList<Wishlist>();
		

	Mockito.when(wRepo.findByBUYERID(1)).thenReturn(l1);

	String message;
	
	try {
		wServ.getAllProducts(1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("No Iteams in you wishlist", message);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getAllTestN2() {
		List<Wishlist> l2=new ArrayList<Wishlist>();
		

	Mockito.when(wRepo.findByBUYERID(1)).thenReturn(l2);

	String message;
	
	try {
		wServ.getAllProducts(1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("No Iteams in you wishlist", message);
	}

}
