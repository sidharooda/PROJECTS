package com.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.OrderWrapper;
import com.spring.service.OrderService;
import com.spring.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderControl {
	@Autowired
	private OrderService orderservice;
	
	public OrderControl(OrderService orderservice)
	{
		this.orderservice=orderservice;
	}
	@PostMapping("/placeorder")
	public Object placeorder(@RequestParam int pid,@RequestParam int qty)
	{
		  return orderservice.getPlaceOrder(pid,qty);
	}
	@DeleteMapping("/cancelorder/{oid}")
	public String cancelOrder(@PathVariable int oid)
	{
		return orderservice.cancelOrder(oid);
	}

}
