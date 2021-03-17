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

import com.infosys.UserMS.dto.CartDTO;
import com.infosys.UserMS.entity.Cart;
import com.infosys.UserMS.repository.CartRepository;
import com.infosys.UserMS.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cServ;
	
	@MockBean
	CartRepository cRepo;
	
	CartDTO c=new CartDTO(1,2,3);
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToCartTest() {
		
	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.empty());

	String message;
	
	try {
		cServ.addToCart(c);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToCartTestN() {
		
	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.of(c.createEntity(c)));

	String message;
	
	try {
		cServ.addToCart(c);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Product is Already in your cart", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToCartTestN2() {
		
	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.of(c.createEntity(c)));

	String message;
	
	try {
		cServ.addToCart(c);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Product is Already in your cart", message);
	}

//	@SuppressWarnings("deprecation")
//	@Test
//	public void delFromCartTest() {
//		Mockito.when(cRepo.delete(c.createEntity(c));
//	Mockito.when(cRepo.findByBUYERIDAndPRODID(1, 2)).thenReturn(Optional.of(c.createEntity(c)));
//
//	String message;
//	
//	try {
//		cServ.addToCart(c);
//		message="Verified";
//	}
//	catch(Exception e) {
//		message=e.getMessage();
//	}
//	
//	assertEquals("Verified", message);
//	}
//	
	
CartDTO c1=new CartDTO(1,3,4);
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCartItemsTest() {
		List<Cart> l=new ArrayList<Cart>();
		l.add(CartDTO.createEntity(c));
		l.add(CartDTO.createEntity(c1));
		
//	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERID(1)).thenReturn(l);

	String message;
	
	try {
		cServ.addToCart(c);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCartItemsTestN() {
		List<Cart> l1=new ArrayList<Cart>();
//		l.add(CartDTO.createEntity(c));
//		l.add(CartDTO.createEntity(c1));
		
//	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERID(1)).thenReturn(l1);

	String message;
	
	try {
		cServ.showAll(1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("No Iteam Found in your cart", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCartItemsTestN2() {
		List<Cart> l12=new ArrayList<Cart>();
//		l.add(CartDTO.createEntity(c));
//		l.add(CartDTO.createEntity(c1));
		
//	Mockito.when(cRepo.save(Mockito.anyObject())).thenReturn(null);
	Mockito.when(cRepo.findByBUYERID(1)).thenReturn(l12);

	String message;
	
	try {
		cServ.showAll(1);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("No Iteam Found in your cart", message);
	}

}
