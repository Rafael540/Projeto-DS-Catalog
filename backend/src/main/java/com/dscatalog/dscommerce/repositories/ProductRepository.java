package com.dscatalog.dscommerce.repositories;

import com.dscatalog.dscommerce.entities.Category;
import com.dscatalog.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
