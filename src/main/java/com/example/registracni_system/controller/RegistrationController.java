package com.example.registracni_system.controller;

import com.example.registracni_system.model.User;
import com.example.registracni_system.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping ("api/v1/user")
    public void createUser(@RequestBody User user) throws SQLException {
        registrationService.createUser(user);
    }




}