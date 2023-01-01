package com.lpc.module.grading.Models;

import org.springframework.data.repository.CrudRepository;

import com.lpc.module.grading.Models.Grade;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Grade, Integer> {

}