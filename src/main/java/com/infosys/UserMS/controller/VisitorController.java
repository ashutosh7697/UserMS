package com.infosys.UserMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.UserMS.dto.ProductModel;
import com.infosys.UserMS.service.VisitorService;

@RestController
@CrossOrigin
@RequestMapping(value="/visitor")

public class VisitorController {
	
	
	@Autowired
	VisitorService visServ;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
//	Going through ProductList as a visitor
	@GetMapping(value = "/allProducts/{contactNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ProductModel[]> getAllsellers(@PathVariable String contactNo) {
//		String c=""+contactNo;
		try {
			return new ResponseEntity<ProductModel[]>(visServ.allProduct(contactNo),HttpStatus.OK);

		}
		catch(Exception e) {
			
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	

}
