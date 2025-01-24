package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> getProductByPrice(int price);

	void deleteProductByPrice(int price);

}
