package com.example.goevent.controller;

import com.example.goevent.model.Event;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventController implements GenericController<Event> {
    private final String ADD_PICTURE = "insert into picture(event_id,src) " +
            "values ((select max(event_id) from event),?)";
    private final String SHOW_ALL_EVENT_FILTER_N_USER ="select * from event " +
            "where disable=false " +
            "and hold_time between ? and ? " +
            "and fee between ? and ?"+
            "and address like ? " ;
    private final String FIND_TAG_BY_EVENT_ID =
            "select tag.* from tag " +
            "join tag_event on tag.tag_id=tag_event.tag_id " +
            "join event on tag_event.event_id=event.event_id " +
            "where event.event_id=?";
    private final String SHOW_ALL_EVENT_BY_ID="select * from event where event_id=?";
    private final String FIND_PICTURE_BY_EVENT_ID="select * from picture where event_id=?";
    private final String SHOW_ALL_EVENT_PARTICIPATED_N_USER =
            "select *  " +
            "from event  " +
            "join event_n_user on event.event_id=event_n_user.event_id " +
            "join n_user on event_n_user.n_user_id=n_user.n_user_id " +
            "where disable=false  " +
            "and hold_time between ? and ? " +
            "and fee between ? and ? " +
            "and event.address like ? " +
            "and n_user.n_user_id= ?";
    private final String ADD_TAG="insert into tag(tag_name) values (?)";
    private final String ADD_NEW_EVENT=
            "insert into event(hold_time,event_name,fee,prof_picture,description,address,b_user_id)" +
                    "values(?,?,?,?,?,?,?)";
    private final String SHOW_ALL_EVENT_B_USER=
            "select count(*) as number_register,SUM(event_n_user.checkin=true) AS number_participant ,event.* " +
            "from event " +
            "left join event_n_user on event.event_id=event_n_user.event_id " +
            "group by event.event_id " +
            "where b_user_id= ?";
    @Override
    public ArrayList<Event> showAll() {
        return null;
    }
    public ArrayList<Event> showAllEventWithFilterNUser(LocalDateTime timeBegin,LocalDateTime timeEnd,String address, long minFee,long maxFee){
        try(Connection connection= connector.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(SHOW_ALL_EVENT_FILTER_N_USER)){
            preparedStatement.setTimestamp(1, Timestamp.valueOf(timeBegin));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(timeEnd));
            preparedStatement.setLong(4,minFee);
            preparedStatement.setLong(5,maxFee);
            String like="%"+address+"%";
            preparedStatement.setString(6,like);
            return getNUserEventsUsingQuery(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Event> showAllEventForBUser(int b_User){
        ArrayList<Event> events=new ArrayList<>();
        try(Connection connection= connector.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(SHOW_ALL_EVENT_B_USER)) {
            preparedStatement.setInt(1,b_User);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int event_id=resultSet.getInt("event_id");
                String event_name=resultSet.getString("event_name");
                String address=resultSet.getString("address");
                int numberRegister=resultSet.getInt("number_register");
                int numberParticipant=resultSet.getInt("number_participant");
                Event event=new Event(event_id,event_name,address,numberRegister,numberParticipant);
                events.add(event);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return events;
    }
    public ArrayList<Event> showAllParticipatedEventNUser(LocalDateTime timeBegin,LocalDateTime timeEnd,String address, long minFee,long maxFee, int n_user_id){
        try(Connection connection= connector.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(SHOW_ALL_EVENT_PARTICIPATED_N_USER)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(timeBegin));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(timeEnd));
            preparedStatement.setLong(3,minFee);
            preparedStatement.setLong(4,maxFee);
            preparedStatement.setString(5,"%"+address+"%");
            preparedStatement.setInt(6,n_user_id);
            return getNUserEventsUsingQuery(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static ArrayList<Event> getNUserEventsUsingQuery(PreparedStatement preparedStatement) throws SQLException {
        ArrayList<Event> events=new ArrayList<>();
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String name=resultSet.getString("event_name");
            String add=resultSet.getString("address");
            LocalDateTime date= resultSet.getTimestamp("hold_time").toLocalDateTime();
            int event_id=resultSet.getInt("event_id");
            Event event=new Event(event_id,date,name,add);
            events.add(event);
        }
        return events;
    }

    @Override
    public void create(Event object) {
        try(Connection connection= connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(ADD_NEW_EVENT);
        ){
            preparedStatement.setTimestamp(1,Timestamp.valueOf(object.getHoldTime()));
            preparedStatement.setString(2,object.getEventName());
            preparedStatement.setLong(3,object.getFee());
            preparedStatement.setString(4,object.getProfilePic());
            preparedStatement.setString(5,object.getDescription());
            preparedStatement.setString(6,object.getAddress());
            preparedStatement.setInt(7,object.getB_userID());
            preparedStatement.execute();
            for (String tag :
                    object.getTag()) {
                try(PreparedStatement addTag=connection.prepareStatement(ADD_TAG)){
                    addTag.setString(1,tag);
                    addTag.execute();
                }catch (SQLException ignored){}
            }
            for (String picture :
                    object.getPictures()) {
                try (PreparedStatement addPicture=connection.prepareStatement(ADD_PICTURE)){
                    addPicture.setString(1,picture);
                    addPicture.execute();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Event showByIndex(int index) {
        try(Connection connection= connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(SHOW_ALL_EVENT_BY_ID)) {
            preparedStatement.setInt(1,index);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int id=resultSet.getInt("event_id");
            LocalDateTime hold_time= resultSet.getTimestamp("hold_time").toLocalDateTime();
            String eventName=resultSet.getString("event_name");
            long fee=resultSet.getLong("fee");
            String profPicture=resultSet.getString("prof_picture");
            String description=resultSet.getString("description");
            String address=resultSet.getString("address");
            int b_userId=resultSet.getInt("b_user_id");
            ArrayList<String>pictures=new ArrayList<>();
            try(PreparedStatement findPicture=connection.prepareStatement(FIND_PICTURE_BY_EVENT_ID)){
                ResultSet pictureResult=findPicture.executeQuery();
                while (pictureResult.next()){
                    pictures.add(pictureResult.getString("src"));
                }
            }
            ArrayList<String>tags=new ArrayList<>();
            try(PreparedStatement findTags=connection.prepareStatement(FIND_TAG_BY_EVENT_ID)){
                findTags.setInt(1,index);
                ResultSet tagResult=findTags.executeQuery();
                while (tagResult.next()){
                    tags.add(tagResult.getString("tag_name"));
                }
            }
            return new Event(id,hold_time,eventName,fee,profPicture,pictures,tags,description,address,b_userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Event object) {

    }

    @Override
    public void delete(int index) {

    }
}
