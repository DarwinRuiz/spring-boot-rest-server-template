package com.darwinruiz.springbootservertemplate.organizations.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.darwinruiz.springbootservertemplate.organizations.interfaces.IMaintenanceOrganizations;
import com.darwinruiz.springbootservertemplate.organizations.models.OrganizationModel;
import com.darwinruiz.springbootservertemplate.organizations.repositories.OrganizationRepository;

public class OrganizationService implements IMaintenanceOrganizations {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationModel createRecord(OrganizationModel record) {
        return this.organizationRepository.save(record);
    }

    @Override
    public OrganizationModel readRecord(Integer id) {
        return this.organizationRepository.findById(id).orElse(null);
    }

    @Override
    public OrganizationModel updateRecord(OrganizationModel record) {
        return this.organizationRepository.save(record);
    }

    @Override
    public void deleteRecord(Integer id) {
        this.organizationRepository.deleteById(id);
    }

    @Override
    public List<OrganizationModel> getAllRecords() {
        return StreamSupport.stream(this.organizationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTotalRecords() {
        return (int) this.organizationRepository.count();
    }
}
