package com.example.goevent.controller;

import com.example.goevent.connector.Connector;
import com.example.goevent.model.BusinessUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BusinessUserController implements GenericController<BusinessUser>{


    public static final String SELECT_ALL_BUSINESS_USERS = "select B.b_user_id, u.user_id, u.login_name, u.password, u.name, u.avatar, u.phone\n" +
            "from b_user B join user u on u.user_id = B.user_id;";

    @Override
    public ArrayList<BusinessUser> showAll() {
        return null;
    }


    @Override
    public void create(BusinessUser object) {
        try {
            Connection conn = connector.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call create_b_user(?,?,?,?,?);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BusinessUser showByIndex(int index) {
        return null;
    }

    @Override
    public void update(BusinessUser object) {

    }

    @Override
    public void delete(int index) {

    }
}
