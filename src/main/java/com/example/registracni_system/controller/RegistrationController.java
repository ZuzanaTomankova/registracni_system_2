package com.example.registracni_system.controller;

import com.example.registracni_system.model.User;
import com.example.registracni_system.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping ("api/v1/user")
    public void createUser(@RequestBody User user) throws SQLException {
        registrationService.createUser(user);
    }

    @GetMapping("api/v1/user/{id}")
    public User getUserById(@PathVariable("id") int id) throws SQLException {
        return registrationService.getUserById(id);

    }

    @GetMapping("api/v1/user/{id}/detail")
    public User getUserByIdWithDetail(@PathVariable("id") int id) throws SQLException {
        return registrationService.getUserByIdWithDetail(id);

    }

    @GetMapping("api/v1/users")
    public List<User> getAllUsers() throws SQLException {
        return registrationService.getAllUsers();
    }

    @GetMapping("api/v1/users/detail")
    public List<User> getAllUsersWithDetails() throws SQLException {
        return registrationService.getAllUsersWithDetails();
    }

    @PutMapping("api/v1/user/{id}")
    public void updateUser(@RequestBody User user,@PathVariable ("id") int id) throws SQLException {
        registrationService.updateUser(user);}

    @DeleteMapping("api/v1/user/{id}")
    public void deleteUser(@PathVariable("id") int id)throws SQLException {
        registrationService.deleteUser(id);
    }
}