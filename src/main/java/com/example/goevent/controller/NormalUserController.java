package com.example.goevent.controller;

import com.example.goevent.model.NormalUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NormalUserController implements GenericController<NormalUser> {
    private static final String GET_ALL_NORMAL_USER = "SELECT n_user.n_user_id, n_user.user_id, n_user.age, " +
            "n_user.gender, n_user.address, n_user.email, user.login_name, user.password FROM n_user " +
            "left join user on n_user.user_id = user.user_id";
    private static final String GET_NORMAL_USER_BY_ID = "SELECT n_user.n_user_id, n_user.user_id, n_user.age, " +
            "n_user.gender, n_user.address, n_user.email, user.login_name, user.password FROM n_user " +
            "left join user on n_user.user_id = user.user_id WHERE n_user.n_user_id = ?";
    private static final String CREATE_NORMAL_USER = "call CREATE_NORMAL_USER(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_NORMAL_USER = "call update_normal_user(?,?,?,?,?,?,?,?,?);";



    @Override
    public ArrayList<NormalUser> showAll() {
        ArrayList<NormalUser> result = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_NORMAL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NormalUser normalUser = getNormalUser(resultSet);
                result.add(normalUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private NormalUser getNormalUser(ResultSet resultset) throws SQLException {
        int normalUserId = resultset.getInt("n_user_id");
        int name = resultset.getInt("n_user_id");
        int age = resultset.getInt("age");
        String gender = resultset.getString("gender");
        String address = resultset.getString("address");
        String email = resultset.getString("email");
        return new NormalUser(normalUserId, age, gender, address, email);
    }

    @Override
    public void create(NormalUser object) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NORMAL_USER)) {
            preparedStatement.setString(1, object.getUserName());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setString(3, object.getFullName());
            preparedStatement.setString(4, object.getAvatar());
            preparedStatement.setString(5, object.getPhone());
            preparedStatement.setInt(6, object.getAge());
            preparedStatement.setString(7, object.getGender());
            preparedStatement.setString(8, object.getAddress());
            preparedStatement.setString(9, object.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public NormalUser showByIndex(int index) {
        NormalUser result;
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_NORMAL_USER_BY_ID)) {
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = getNormalUser(resultSet);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }


    @Override
    public void update(NormalUser object) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NORMAL_USER)) {
            preparedStatement.setString(1, object.getPassword());
            preparedStatement.setString(2, object.getFullName());
            preparedStatement.setString(3, object.getAvatar());
            preparedStatement.setString(4, object.getPhone());
            preparedStatement.setInt(5, object.getAge());
            preparedStatement.setString(6, object.getGender());
            preparedStatement.setString(7, object.getAddress());
            preparedStatement.setString(8, object.getEmail());
            preparedStatement.setInt(9, object.getNormalUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(int index) {

    }
}
