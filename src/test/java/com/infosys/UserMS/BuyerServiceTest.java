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

import com.infosys.UserMS.dto.BuyerDTO;
import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.entity.Buyer;
import com.infosys.UserMS.repository.BuyerRepository;
import com.infosys.UserMS.service.BuyerService;


@SpringBootTest
public class BuyerServiceTest {
	
	@Autowired
	BuyerService buyServ;
	
	@MockBean
	BuyerRepository buyRepo;
	
	BuyerDTO b=new BuyerDTO(10,"Ashu Tiwa","ashueoeo@gmail.com","8372728432","Aloh@12455",0,100001,1);
	
	@SuppressWarnings("deprecation")
	@Test
	public void buyerRegisTest() {
		
	Mockito.when(buyRepo.save(Mockito.anyObject())).thenReturn(null);
	String message;
	
	try {
		buyServ.buyerRegistration(b);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void buyerRegisTestN() {
		
		Mockito.when(buyRepo.save(Mockito.anyObject())).thenReturn(null);
		String message;
		b.setEmail("AShutosh");
		try {
			buyServ.buyerRegistration(b);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("Sorry, Credentials format not correct", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void buyerRegisTestN2() {
		
		Mockito.when(buyRepo.save(Mockito.anyObject())).thenReturn(null);
		String message;
		b.setEmail("AShutosh1212@1212");
		try {
			buyServ.buyerRegistration(b);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("Sorry, Credentials format not correct", message);
	}
	
	LoginDTO l=new LoginDTO("ashueoeo@gmail.com","Aloh@12455");
	
	@SuppressWarnings("deprecation")
	@Test
	public void buyerLoginTest() {
		
	Mockito.when(buyRepo.findByEmail(Mockito.anyObject())).thenReturn(Optional.of(b.createEntity(b)));
	String message;
	
	try {
		buyServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Verified", message);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	
	public void buyerLoginTestN() {
		
	Mockito.when(buyRepo.findByEmail(Mockito.anyObject())).thenReturn(Optional.of(b.createEntity(b)));
	String message;
	l.setPassword("Ssgg@1344");
	try {
		buyServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Sorry, Credentials not correct", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	
	public void buyerLoginTestN2() {
		l.setEmail("Ashu@123.com");
	Mockito.when(buyRepo.findByEmail(l.getEmail())).thenReturn(Optional.of(b.createEntity(b)));
	String message;
	l.setPassword("Ssgg@1344");
	try {
		buyServ.login(l);
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("Sorry,Credentials format not correct", message);
	}
	
	
	
	
	
	BuyerDTO b1=new BuyerDTO(11,"Ashut Tiwari","ashueo@gmail.com","8372728432","Alok@12455",1,2,3);
	
	
	@Test
	public void getAllTest() {
		List<Buyer> l=new ArrayList<Buyer>();
		l.add(b.createEntity(b));
		l.add(b1.createEntity(b1));
	Mockito.when(buyRepo.findAll()).thenReturn(l);
	String message;
	
	try {
		buyServ.getAllBuyers();
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
		List<Buyer> l2=new ArrayList<Buyer>();
	Mockito.when(buyRepo.findAll()).thenReturn(l2);
	String message;
	
	try {
		buyServ.getAllBuyers();
		message="Verified";
	}
	catch(Exception e) {
		message=e.getMessage();
	}
	
	assertEquals("No buyer is Registered", message);
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void buyerDelete() {
		
		Mockito.when(buyRepo.findById(10)).thenReturn(Optional.of(b.createEntity(b)));
		String message;
		try {
			buyServ.deleteBuyer(10);
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
	public void buyerDeleteN() {
		Mockito.when(buyRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		String message;
		try {
			buyServ.deleteBuyer(10);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("No buyer is registered with provided id", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void buyerDeleteN2() {
		Mockito.when(buyRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		String message;
		try {
			buyServ.deleteBuyer(10);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("No buyer is registered with provided id", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void optPrivelegeTest() {
		
		Mockito.when(buyRepo.findById(10)).thenReturn(Optional.of(b.createEntity(b)));
		Mockito.when(buyRepo.getOne(10)).thenReturn((b.createEntity(b)));

		String message;
		try {
			buyServ.optPrivilege(10);
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
	public void optPrivelegeTestN() {
		b.setRewardPoints(8000);
		Mockito.when(buyRepo.findById(10)).thenReturn(Optional.of(b.createEntity(b)));
		Mockito.when(buyRepo.getOne(10)).thenReturn((b.createEntity(b)));

		String message;
		try {
			buyServ.optPrivilege(10);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("Sorry, Rewardpoints are less than 10000", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void updateRewardsTest() {
		
		Mockito.when(buyRepo.findById(10)).thenReturn(Optional.of(b.createEntity(b)));
		Mockito.when(buyRepo.save(b.createEntity(b))).thenReturn(null);

		String message;
		try {
			buyServ.updateRewardPoints(10, 10000);
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
	public void updateRewardsTestN() {
		
		Mockito.when(buyRepo.findById(10)).thenReturn(Optional.empty());
//		Mockito.when(buyRepo.save(b.createEntity(b))).thenReturn(null);

		String message;
		try {
			buyServ.updateRewardPoints(10, 10000);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("No buyer is registered with provided id:10", message);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void updateRewardsTestN2() {
		
		Mockito.when(buyRepo.findById(12)).thenReturn(Optional.empty());
//		Mockito.when(buyRepo.save(b.createEntity(b))).thenReturn(null);

		String message;
		try {
			buyServ.updateRewardPoints(12, 10000);
			message="Verified";
		}
		catch(Exception e) {
			message=e.getMessage();
		}
		System.out.println(message);
		assertEquals("No buyer is registered with provided id:12", message);
	}

}
