package com.spring.control;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Product;
import com.spring.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class ProductController {
	private ProductService service;
	@Autowired
	public ProductController(ProductService service)
	{
		this.service=service;
	}
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product p1) {
		
		Product p=service.addProduct(p1);
		return ResponseEntity.ok(p);
		
	}
	@GetMapping("/viewproduct")
	public List<Product> viewProduct()
	{
		return service.viewProduct();
	}
	@GetMapping("/getproductbyid/{id}")
	public Optional<Product> getProductById(@PathVariable int id)
	{
	return	service.getProductById(id);
	}
	@GetMapping("/getproductbyprice/{price}")
	public ResponseEntity<List<Product>> getProductByPrice(@PathVariable int price)
	{
		return new ResponseEntity<>(service.getProductByPrice(price),HttpStatus.OK);
	}
	@DeleteMapping("/deleteproductbyid/{id}")
	public String deleteProductById(@PathVariable int id)
	{
		return service.deleteProductById(id);
	}
	@DeleteMapping("/deleteproductbyprice/{price}")
	public String deleteProductByPrice(@PathVariable int price)
	{
		return service.deleteProductByPrice(price);
	}

}
