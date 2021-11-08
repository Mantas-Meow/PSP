package com.psp.repository;

import org.springframework.data.repository.CrudRepository;

import com.psp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
