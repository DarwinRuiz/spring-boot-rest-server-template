package com.darwinruiz.springbootservertemplate.auth.roles.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darwinruiz.springbootservertemplate.auth.roles.interfaces.IMaintenanceRoles;
import com.darwinruiz.springbootservertemplate.auth.roles.models.RolModel;
import com.darwinruiz.springbootservertemplate.auth.roles.repositories.RolRepository;

@Service
public class RolService implements IMaintenanceRoles {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public RolModel createRecord(RolModel record) {
        return this.rolRepository.save(record);
    }

    @Override
    public RolModel readRecord(Integer id) {
        return this.rolRepository.findById(id).orElse(null);
    }

    @Override
    public RolModel updateRecord(RolModel record) {
        return this.rolRepository.save(record);
    }

    @Override
    public void deleteRecord(Integer id) {
        this.rolRepository.deleteById(id);
    }

    @Override
    public List<RolModel> getAllRecords() {
        return StreamSupport.stream(this.rolRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTotalRecords() {
        return (int) this.rolRepository.count();
    }

}
