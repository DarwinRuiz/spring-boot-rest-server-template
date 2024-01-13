package com.darwinruiz.springbootservertemplate.auth.roles.models;

import java.util.Set;

import com.darwinruiz.springbootservertemplate.auth.usersroles.models.UserRolModel;
import com.darwinruiz.springbootservertemplate.organizations.models.OrganizationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "roles", schema = "administration")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Integer rolId;

    private String rol;

    @ManyToOne()
    @JoinColumn(name = "organization_id")
    @JsonIgnore
    private OrganizationModel organization;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rol")
    @JsonIgnore
    private Set<UserRolModel> userRoles;

}
