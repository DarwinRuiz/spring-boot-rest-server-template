package com.darwinruiz.springbootservertemplate.organizations.models;

import java.util.HashSet;
import java.util.Set;

import com.darwinruiz.springbootservertemplate.auth.roles.models.RolModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "organizations", schema = "administration")
public class OrganizationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Integer organizationId;

    private String name;

    private String logo;

    private String address;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "organization", targetEntity = RolModel.class)
    private Set<RolModel> roles = new HashSet<>();

}
