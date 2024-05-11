package com.shopme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopme.dtos.Response;
import com.shopme.entities.Vendor;
import com.shopme.services.VendorServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vendor")
public class VendorController {

		@Autowired
		private VendorServiceImpl vendorService;
			
		@PostMapping("/add")
		public @ResponseBody ResponseEntity<?> addVendorshopdetails(@RequestBody Vendor vendor)
		{
			Vendor result = vendorService.addVendorshop(vendor);
			if(result == null)
			{
		   return Response.error("only Vendor can add his shop details else userId not found");
			}else {
				return Response.success(result);
		}
		
		}
		
		
}
