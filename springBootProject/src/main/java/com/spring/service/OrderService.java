package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.entity.Order1;
import com.spring.entity.OrderWrapper;
import com.spring.entity.Product;
import com.spring.repository.OrderRepository;
import com.spring.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;
	@Autowired
	private ProductRepository productrepository;
	public OrderService(OrderRepository orderrepository)
	{
		this.orderrepository=orderrepository;
	}
	public ResponseEntity<OrderWrapper> getPlaceOrder(int pid, int qty) {
		//first we need check that product is available or not
	Optional<Product> p1=productrepository.findById(pid);
	if(p1.isPresent())
	{
		//we need check the qty
		Product p=p1.get();
		if(p.getQty()>=qty)
		{
			//place the order
			Order1 o=new Order1();
			o.setProduct(p);
			o.setQty(qty);
			p.setQty(o.getQty()-qty);
			o.setStatus("placed");
			o.setTotalprice(p.getPrice()*qty);
			orderrepository.save(o);
			OrderWrapper o1=new OrderWrapper(o.getOid(),o.getQty(),o.getStatus(),o.getTotalprice(),o.getProduct().getPname());
			return ResponseEntity.ok(o1);
		}
		else
		{
			throw new RuntimeException("stock is not available");
		}
	}
	else
	{
		//return the product is unavailable
		throw new RuntimeException("product is not available");
	}
	
		
		
	}
	public String cancelOrder(int oid) {
		Optional<Order1> o=orderrepository.findById(oid);
		if(o.isPresent())
		{
			Product p=o.get().getProduct();
			p.setQty(p.getQty()+o.get().getQty());
			productrepository.save(p);
			orderrepository.deleteById(oid);
			return "Order Cancelled Successfully";
		}
		else
		{
			return "invalid Order ID";
		}
		
		
	}
	

}
