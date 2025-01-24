package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Product;
import com.spring.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository)
	{
		this.repository=repository;
	}

	public Product addProduct(Product p1) {
		
		return repository.save(p1);
		
	}

	public List<Product> viewProduct() {
		
		return repository.findAll();
	}

	public Optional<Product> getProductById(int id) {
		
	Optional<Product> p =repository.findById(id);
	if(p.isPresent())
	{
		return p;
	}
	else
	{
		return null;
	}
	}

	public List<Product> getProductByPrice(int price) {
	return	repository.getProductByPrice(price);
		
	}

	public String deleteProductById(int id) {
	Optional<Product>p1=repository.findById(id);
	if(p1.isPresent())
	{
		repository.deleteById(id);
		return "deleted id" + id +" successfully";
	}
	else
	{
		return "id is not present";
	}
		
	}

	public String deleteProductByPrice(int price) {
	List<Product> p1=repository.getProductByPrice(price);
	if(p1.isEmpty())
	{
		return price+" is not exist";
	}
	else
	{
		repository.deleteProductByPrice(price);
	    return	"Deleted "+price+" successfully";
	}
		
		
	}

}
