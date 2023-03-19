package com.example.goevent.controller;

import com.example.goevent.connector.Connector;
import com.example.goevent.model.BusinessUser;
import com.example.goevent.model.NormalUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BusinessUserController implements GenericController<BusinessUser> {


    public static final String SELECT_ALL_BUSINESS_USERS = "select B.b_user_id, u.user_id, u.login_name, u.password, u.name, u.avatar, u.phone\n" +
            "from b_user B join user u on u.user_id = B.user_id;";

    public static final String CALL_CREATE_BUSINESS_USER = "call create_b_user(?,?,?,?,?,?);";

    public static final String CALL_EDIT_BUSINESS_USER = "call edit_b_user(?,?,?,?,?,?);";
    public static final String SELECT_B_USER_BY_ID = "SELECT b.b_user_id,b.user_id, u.name, u.avatar, u.phone, b.gender, u.login_name, u.password from b_user b join user u on b.user_id = u.user_id where b_user_id=?;";

    @Override
    public ArrayList<BusinessUser> showAll() {
        return null;
    }


    @Override
    public void create(BusinessUser user) {
        try (
                Connection conn = connector.getConnection();
                CallableStatement callableStatement = conn.prepareCall(CALL_CREATE_BUSINESS_USER);
        ) {
            callableStatement.setString(1, user.getUserName());
            callableStatement.setString(2, user.getPassword());
            callableStatement.setString(3, user.getFullName());
            callableStatement.setString(4, user.getAvatar());
            callableStatement.setString(5, user.getPhone());
            callableStatement.setString(6, user.getGender());

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public BusinessUser showByIndex(int index) {
        BusinessUser user = null;
        try {
            Connection conn = connector.getConnection();
            PreparedStatement statement = conn.prepareStatement(SELECT_B_USER_BY_ID);
            statement.setInt(1, index);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int b_user_id = rs.getInt("b_user_id");
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String avatar = rs.getString("avatar");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                user = new BusinessUser(b_user_id, user_id, name, avatar, phone, gender);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void update(BusinessUser user) {
        try (
                Connection conn = connector.getConnection();
                CallableStatement statement = conn.prepareCall(CALL_EDIT_BUSINESS_USER);
        ) {
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getAvatar());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getGender());
            statement.setInt(1, user.getBusinessUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {

    }
}
