package com.darwinruiz.springbootservertemplate.auth.usersroles.repositories;

import org.springframework.data.repository.CrudRepository;

import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
import com.darwinruiz.springbootservertemplate.auth.usersroles.models.UserRolModel;

import java.util.List;

public interface UserRolRepository extends CrudRepository<UserRolModel, Integer> {
    public List<UserRolModel> findByUser(UserModel user);
}
