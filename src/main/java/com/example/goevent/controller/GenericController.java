package com.example.goevent.controller;

import com.example.goevent.connector.Connector;

import java.util.Collection;

public interface GenericController<E> {

    String jdbcURL = "jdbc:mysql://localhost:3306/go_event?useUnicode=yes&characterEncoding=UTF-8";
    String jdbcUsername = "Nam";
    String jdbcPassword = "Anhnam220797anhnam";

    Connector connector = new Connector(jdbcURL, jdbcUsername, jdbcPassword);

    Collection<E> showAll();

    void create(E object);

    E showByIndex(int index);

    void update(E object);

    void delete(int index);
}