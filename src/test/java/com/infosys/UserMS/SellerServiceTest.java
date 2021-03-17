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

import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.dto.SellerDTO;
import com.infosys.UserMS.entity.Seller;
import com.infosys.UserMS.repository.SellerRepository;
import com.infosys.UserMS.service.SellerService;

@SpringBootTest
public class SellerServiceTest {
	
	
	@Autowired
	SellerService sServ;
	@MockBean
	SellerRepository selrepo;
	
	SellerDTO s=new SellerDTO(1,"Ashutosh Tiwari","ashutosh@gmail.com","6576876576","Ashui@123",1);
	SellerDTO s2=new SellerDTO(2,"Ashut2osh Tiwari","ash2utosh@gmail.com","6576872576","As2hui@123",1);

	LoginDTO l=new LoginDTO("ashutosh@gmail.com","Ashui@123");
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerLoginTest() {
		
		Mockito.when(selrepo.findByEmail(l.getEmail())).thenReturn(Optional.of(SellerDTO.createEntity(s)));
		String message;
	
	try {
		sServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerLoginTestN() {
		
		Mockito.when(selrepo.findByEmail(l.getEmail())).thenReturn(Optional.empty());
		String message;
	
	try {
		sServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Credentials not correct", message);

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerLoginTestN2() {
		l.setEmail("ASSDAD@12");
		Mockito.when(selrepo.findByEmail(l.getEmail())).thenReturn(Optional.empty());
		String message;
	
	try {
		sServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Credentials format not correct", message);

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerRegisTest() {
		
		Mockito.when(selrepo.save(SellerDTO.createEntity(s))).thenReturn(null);
		String message;
	
	try {
		sServ.sellerRegistration(s);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("Verified", message);


	}
	@SuppressWarnings("deprecation")
	@Test
	public void sellerRegisTestN() {
		s.setEmail("asassAS@");
		Mockito.when(selrepo.save(SellerDTO.createEntity(s))).thenReturn(null);
		String message;
	
	try {
		sServ.sellerRegistration(s);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("Credentials format not correct", message);


	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerRegisTestN2() {
		s.setEmail("asassAwefS@");
		Mockito.when(selrepo.save(SellerDTO.createEntity(s))).thenReturn(null);
		String message;
	
	try {
		sServ.sellerRegistration(s);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("Credentials format not correct", message);


	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getAllSellerTest() {
		List<Seller> l=new ArrayList<Seller>();
		l.add(SellerDTO.createEntity(s));
		l.add(SellerDTO.createEntity(s2));
		Mockito.when(selrepo.findAll()).thenReturn(l);
		String message;
	
	try {
		sServ.getAllSellers();
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("Verified", message);


	}

	@SuppressWarnings("deprecation")
	@Test
	public void getAllSellerTestN() {
		List<Seller> l1=new ArrayList<Seller>();
//		l.add(SellerDTO.createEntity(s));
//		l.add(SellerDTO.createEntity(s2));
		Mockito.when(selrepo.findAll()).thenReturn(l1);
		String message;
	
	try {
		sServ.getAllSellers();
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("No seller is registered yet", message);


	}
	@SuppressWarnings("deprecation")
	@Test
	public void getAllSellerTestN2() {
		List<Seller> l2=new ArrayList<Seller>();
//		l.add(SellerDTO.createEntity(s));
//		l.add(SellerDTO.createEntity(s2));
		Mockito.when(selrepo.findAll()).thenReturn(l2);
		String message;
	
	try {
		sServ.getAllSellers();
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	assertEquals("No seller is registered yet", message);


	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerDelete() {
		
		Mockito.when(selrepo.findById(1)).thenReturn(Optional.of(SellerDTO.createEntity(s)));
//		Mockito.when(selrepo.deleteById(1).thenReturn(null));

		String message;
		try {
			sServ.deleteSeller(1);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("Verified", message);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void sellerDeleteN() {
		Mockito.when(selrepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		String message;
		try {
			sServ.deleteSeller(1);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("No seller Found with Provided Id: "+1, message);
	}
	
//	public void sellerDeleteN2() {
//		Mockito.when(selrepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
//		String message;
//		try {
//			sServ.deleteSeller(1);
//			message="Verified";
//		}
//		catch(Exception e) {
//			message=e.getMessage();
//		}
//		System.out.println(message);
//		assertEquals("No seller Found with Provided Id: "+1, message);
//	}
	

}
