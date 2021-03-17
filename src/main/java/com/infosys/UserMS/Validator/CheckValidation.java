package com.infosys.UserMS.Validator;

import com.infosys.UserMS.dto.BuyerDTO;
import com.infosys.UserMS.dto.LoginDTO;
import com.infosys.UserMS.dto.SellerDTO;

public class CheckValidation {
	
	public static boolean buyerValidation(BuyerDTO buyerDto) {
		
		String nameRegex="[A-Za-z]+([\\s][a-zA-Z]+)*";
		String emailRegex="[A-Za-z]+@[a-z]+\\.[a-z]+";
		String contactRegex="[1-9][0-9]{9}";
		String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		
		if(!buyerDto.getName().matches(nameRegex))
			return false;
		if(!buyerDto.getEmail().matches(emailRegex))
			return false;
		if(!buyerDto.getPhoneNumber().matches(contactRegex))
			return false;
		if(!buyerDto.getPassword().matches(passwordRegex))
			return false;
		return true;
	}
	
	public static boolean sellerValidation(SellerDTO sellerDto) {
		
		String nameRegex="[A-Za-z]+([\\s][a-zA-Z]+)*";
		String emailRegex="[A-Za-z]+@[a-z]+\\.[a-z]+";
		String contactRegex="[1-9][0-9]{9}";
		String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		
		if(!sellerDto.getName().matches(nameRegex))
			return false;
		if(!sellerDto.getEmail().matches(emailRegex))
			return false;
		if(!sellerDto.getPhoneNumber().matches(contactRegex))
			return false;
		if(!sellerDto.getPassword().matches(passwordRegex))
			return false;
		return true;
	}

	public static boolean LoginValidation(LoginDTO loginDto) {
	
		String emailRegex="[A-Za-z]+@[a-z]+\\.[a-z]+";
		
		if(!loginDto.getEmail().matches(emailRegex))
			return false;
		return true;

}
}
