package com.ecommerce.ecommerce_backend.repository;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecommerce_backend.model.Product;

// This will be AUTO IMPLEMENTED by Spring into a Bean called ProductRepository
// CRUD refers Create, Read, Update, Delete

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
