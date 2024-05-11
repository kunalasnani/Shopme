package com.shopme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopme.dtos.AddToCartDto;
import com.shopme.dtos.CartDto;
import com.shopme.dtos.OrderDto;
import com.shopme.dtos.Response;
import com.shopme.entities.Cart;
import com.shopme.entities.Order;
import com.shopme.entities.Product;
import com.shopme.entities.User;
import com.shopme.services.CartServiceImpl;
import com.shopme.services.OrderServiceImpl;
import com.shopme.services.ProductServiceImpl;
import com.shopme.services.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private UserServiceImpl userService;
	
	
	//to add in order table by userid
	@PostMapping("/addorder/{id}")
	public @ResponseBody ResponseEntity<?> addtoorder(@PathVariable("id") int id )
	{
		int i = orderService.addtoorder(id);
		if(i == 0)
		{   
			return Response.error("order is not added as userid is wrong");
		}
		else
			
		return Response.success("added orderdata added in order ");
	}
	

	//get list of order BY user
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<?> getOrderItems( @PathVariable("id") int id  ) {

		User user = userService.findUserById(id);
		//System.out.println(user);
		//get cart items
		if(user == null)
		{
		return	Response.error("user does not exist");
		}
	 List<Order> orderList = orderService.listOrderItems(user);
	 System.out.println(orderList);
	
			return Response.success(orderList);
	}
	

}
