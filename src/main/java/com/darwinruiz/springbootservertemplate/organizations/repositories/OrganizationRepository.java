package com.darwinruiz.springbootservertemplate.organizations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.darwinruiz.springbootservertemplate.organizations.models.OrganizationModel;

public interface OrganizationRepository extends CrudRepository<OrganizationModel, Integer> {

}
