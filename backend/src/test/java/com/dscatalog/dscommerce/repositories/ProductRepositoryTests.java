package com.dscatalog.dscommerce.repositories;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dscatalog.dscommerce.entities.Product;
import com.dscatalog.dscommerce.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {


	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	private long countTotalProdutcs;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		countTotalProdutcs = 25L;
	}

	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProdutcs + 1,product.getId());
		
		
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnNonEmptyOptionalProductWhenIdExists() {
		
		Optional <Product> result = repository.findById(exintingId);
		

		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnEmptyOptionalProductWhenIdDoesNotExists() {
		
		Optional <Product> result = repository.findById(exintingId);
		

		Assertions.assertTrue(result.isEmpty());
	}
	
	
	
}
