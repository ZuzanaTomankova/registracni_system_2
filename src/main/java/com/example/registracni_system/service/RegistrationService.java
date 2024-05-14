package com.example.registracni_system.service;

import com.example.registracni_system.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class RegistrationService {
    public static final String CONNECTION_CONSTANT = "jdbc:mysql://localhost:3306/resources?user=root&password=1234";
    Connection connection = DriverManager.getConnection(CONNECTION_CONSTANT);

    Statement statement = connection.createStatement();

    public RegistrationService() throws SQLException {
    }
    public void createUser(User user)   throws SQLException  {
        statement.execute("INSERT INTO resourcedistribution VALUES ('"+user.getId()+"','"+user.getName()+"','"+ user.getSurname()+"','"+user.getPersonID()+"','"+user.getUuid()+"')");
    }



}
