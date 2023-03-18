package com.example.goevent.controller;

import com.example.goevent.connector.Connector;

import java.util.Collection;

public interface GenericController<E> {
    String jdbcURL = "jdbc:mysql://localhost:3306/go_event";
    
    String jdbcUsername = "root";

    String jdbcPassword = "123456";

    Connector connector = new Connector(jdbcURL, jdbcUsername, jdbcPassword);

    Collection<E> showAll();

    void create(E object);

    E showByIndex(int index);

    void update(E object);

    void delete(int index);
}