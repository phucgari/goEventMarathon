package com.example.goevent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NormalUserProcessor {
    private final String CHECK_IF_REGISTERED = "select * from event_n_user where n_user_id=? and event_id=?";
    private final String ADD_EVENT_N_USER="insert into event_n_user(event_id,n_user_id) " +
            "values (?,?)";
    private final String CHECK_IN_USER="update event_n_user set checkin=true where event_id=? and n_user_id=?";
    private final String DELETE_EVENT_USER ="delete from event_n_user where n_user_id=? and event_id=?";
    public void registerNUserToEvent(int NUserId,int EventId){
        try(Connection connection=GenericController.connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(ADD_EVENT_N_USER)) {
            preparedStatement.setInt(1,EventId);
            preparedStatement.setInt(2,NUserId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkInNUser(int nUserId,int eventId){
        try(Connection connection=GenericController.connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CHECK_IN_USER)) {
            preparedStatement.setInt(1,eventId);
            preparedStatement.setInt(2,nUserId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkIfUserAlreadyRegistered(int nUserId,int eventId){
        try(Connection connection=GenericController.connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CHECK_IF_REGISTERED)){
            preparedStatement.setInt(1,nUserId);
            preparedStatement.setInt(2,eventId);
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void unRegisterNUserFromEvent(int nUserId,int eventId){
        try(Connection connection=GenericController.connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE_EVENT_USER)) {
            preparedStatement.setInt(1,nUserId);
            preparedStatement.setInt(2,eventId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
