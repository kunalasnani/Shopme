package com.shopme.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopme.daos.FileService;
import com.shopme.daos.ProductDao;
import com.shopme.daos.UserDao;
import com.shopme.entities.Product;
import com.shopme.entities.User;
import com.shopme.services.ProductServiceImpl;
import com.shopme.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/upload")
public class UploadFileController {

	@Autowired
	private FileService fileService;
	
	@Autowired UserServiceImpl userService;
	
	@Autowired
	 private ProductServiceImpl productService;
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/file/user/{userid}")
	public ResponseEntity<Map<String,String>> uploadFile(@PathVariable("userid")int userid ,@RequestParam("file")  MultipartFile  file){
		
	User user = userService.findUserById(userid);
	
	String publicURL =fileService.uploadFile(file);
	
	userDao.updateProfileImgById(publicURL, userid);
	
	Map<String,String> response =new HashMap<>();
	
	response.put("publicURL", publicURL);
	
	
	return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/file/product/{productid}")
	public ResponseEntity<Map<String,String>> uploadFileProduct(@PathVariable("productid")int productid ,@RequestParam("file")  MultipartFile  file){
		
	Product product =productService.findProductById(productid);
	String publicURL =fileService.uploadFile(file);
	
	productDao.updateProductImgById(publicURL, productid);
	
	Map<String,String> response =new HashMap<>();
	
	response.put("publicURL", publicURL);
	
	
	return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
		
	}
}
