package com.example.usersystem.service;

import com.example.usersystem.entity.Role;
import com.example.usersystem.entity.User;
import com.example.usersystem.repository.RoleRepository;
import com.example.usersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
@Service
public class UserService {

private UserRepository userRepository;
private RoleRepository roleRepository;
private BCryptPasswordEncoder bCryptPasswordEncoder;

@Autowired
    private UserService( UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder){

    this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    this.roleRepository=roleRepository;
    this.userRepository=userRepository;

}

public User findUserByEmail(String email){

    return userRepository.findByEmail(email);

}
public  User findUserByUserName(String username){

    return userRepository.findByUserName(username);

}

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }











}
