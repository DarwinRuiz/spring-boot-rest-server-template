package com.darwinruiz.springbootservertemplate.auth.users.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
import com.darwinruiz.springbootservertemplate.shared.interfaces.IMaintenance;

public interface IMaintenanceUsers extends IMaintenance<UserModel> {

    public UserDetailsService userDetailsService();
}
