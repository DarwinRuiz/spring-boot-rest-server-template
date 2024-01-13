package com.darwinruiz.springbootservertemplate.auth.roles.repositories;

import org.springframework.data.repository.CrudRepository;

import com.darwinruiz.springbootservertemplate.auth.roles.models.RolModel;

public interface RolRepository extends CrudRepository<RolModel, Integer> {

}
