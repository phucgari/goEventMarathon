package com.example.goevent.controller;

import com.example.goevent.model.BusinessUser;
import com.example.goevent.model.NormalUser;
import com.example.goevent.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class LoginController {
    private static final String SELECT_USER = "SELECT n_user.n_user_id, b_user.b_user_id, user.login_name, user.password " +
            "FROM user " +
            "left join n_user on n_user.user_id = user.user_id " +
            "left join b_user on user.user_id = b_user.user_id " +
            "WHERE user.login_name = ? and user.password = ?";
    public User login(String login_name, String password) {
        try (Connection connection = GenericController.connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);) {
            preparedStatement.setString(1, login_name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if(!rs.next())return null;

            if(rs.getInt("n_user_id")!=0){
                return new NormalUser(rs.getInt("n_user_id"));
            }else{
                return new BusinessUser(rs.getInt("b_user_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
