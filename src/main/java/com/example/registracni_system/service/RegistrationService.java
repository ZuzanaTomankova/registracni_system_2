package com.example.registracni_system.service;

import com.example.registracni_system.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public User getUserById(int id) throws SQLException {
        ResultSet resultSet;

            resultSet = statement.executeQuery("SELECT * FROM resourcedistribution WHERE ID = " + id);
           while (resultSet.next()) {
                return new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname")
                );
            }
            return null;
        }

    public User getUserByIdWithDetail(int id) throws SQLException {
        ResultSet resultSet;

        resultSet = statement.executeQuery("SELECT * FROM resourcedistribution WHERE ID = " + id);
        while (resultSet.next()) {
            return new User(
                    resultSet.getInt("ID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Surname"),
                    resultSet.getString("PersonID"),
                    resultSet.getString("Uuid")

            );
        }
        return null;
    }

    public List<User>getAllUsers()throws SQLException{
        ResultSet resultSet;
        List<User>allUsers = new ArrayList<>();
        resultSet = statement.executeQuery("SELECT * FROM resourcedistribution");
        while (resultSet.next()){
            User user = new User(
                    resultSet.getInt("ID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Surname")
            );
            allUsers.add(user);
        }
        return allUsers;
    }

    public List<User>getAllUsersWithDetails()throws SQLException{
        ResultSet resultSet;
        List<User>allUsers = new ArrayList<>();
        resultSet = statement.executeQuery("SELECT * FROM resourcedistribution");
        while (resultSet.next()){
            User user = new User(
                    resultSet.getInt("ID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Surname"),
                    resultSet.getString("PersonID"),
                    resultSet.getString("Uuid")
            );
            allUsers.add(user);
        }
        return allUsers;
    }
    public void updateUser(User user) throws SQLException {
        int id = user.getId();
        String name = user.getName();
        String surname = user.getSurname();
        String query = "UPDATE resourcedistribution SET Name='" + name + "', Surname='" + surname + "' WHERE ID=" + id;
        statement.executeUpdate(query);
    }

    public void deleteUser(int id) throws SQLException{
        statement.execute("DELETE FROM resourcedistribution WHERE ID="+id);
    }

        }





