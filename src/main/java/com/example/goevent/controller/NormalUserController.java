package com.example.goevent.controller;

import com.example.goevent.model.NormalUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class NormalUserController implements GenericController<NormalUser>{
    private static final String GET_ALL_NORMAL_USER = "SELECT n_user.n_user_id, n_user.user_id, n_user.age, " +
            "n_user.gender, n_user.address, n_user.email, user.login_name, user.password FROM n_user " +
            "left join user on n_user.user_id = user.user_id";
    private static final String GET_NORMAL_USER_BY_ID = "SELECT n_user.n_user_id, n_user.user_id, n_user.age, " +
            "n_user.gender, n_user.address, n_user.email, user.login_name, user.password FROM n_user " +
            "left join user on n_user.user_id = user.user_id WHERE n_user.n_user_id = ?";
    private static final String CREATE_NORMAL_USER = "call CREATE_NORMAL_USER();";
    private static final String UPDATE_NORMAL_USER = "UPDATE n_user SET age = ?, gender = ?, address = ?," +
            " email = ? WHERE n_user_id = ?";



    @Override
    public ArrayList<NormalUser> showAll() {
        ArrayList<NormalUser> result = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_NORMAL_USER)){
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
        int normalUserId = resultset.getInt("normalUserId");
        int age = resultset.getInt("age");
        String gender = resultset.getString("gender");
        String address = resultset.getString("address");
        String email = resultset.getString("email");
        NormalUser normalUser = new NormalUser(normalUserId, age, gender, address, email);
        return normalUser;
    }

    @Override
    public void create(NormalUser object) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NORMAL_USER)) {

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
            result = getNormalUser(resultSet);
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }



    @Override
    public void update(NormalUser object) {

    }

    @Override
    public void delete(int index) {

    }
}
