package com.darwinruiz.springbootservertemplate.auth.users.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.darwinruiz.springbootservertemplate.auth.users.interfaces.IMaintenanceUsers;
import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
import com.darwinruiz.springbootservertemplate.auth.users.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IMaintenanceUsers {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel createRecord(UserModel record) {
        return this.userRepository.save(record);
    }

    @Override
    public UserModel readRecord(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel updateRecord(UserModel record) {
        return this.userRepository.save(record);
    }

    @Override
    public void deleteRecord(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<UserModel> getAllRecords() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTotalRecords() {
        return (int) this.userRepository.count();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
