package com.darwinruiz.springbootservertemplate.auth.users.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
}
