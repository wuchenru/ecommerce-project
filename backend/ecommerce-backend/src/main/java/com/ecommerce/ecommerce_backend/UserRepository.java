package com.ecommerce.ecommerce_backend;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecommerce_backend.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
