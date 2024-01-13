package com.darwinruiz.springbootservertemplate.auth.usersroles.models;

import com.darwinruiz.springbootservertemplate.auth.roles.models.RolModel;
import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_rol", schema = "administration")
public class UserRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rol_id")
    private Integer userRolId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserModel.class)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id")
    @JsonIgnore
    private RolModel rol;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @JsonIgnore
    private OrganizationModel organization;
}
