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
        return null;
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
