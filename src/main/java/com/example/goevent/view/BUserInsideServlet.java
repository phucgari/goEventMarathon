package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "EventServlet", value = "/events")
public class BUserInsideServlet extends HttpServlet {


    private EventController eventController;

    public void init() {
        eventController = new EventController();
    }

    //===============================Method Get=================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createForm(request, response);
                    break;
                case "update":
                    updateForm(request, response);
                    break;
                default:
                    listEvent(request, response);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listEvent(HttpServletRequest request, HttpServletResponse response) {


    }

    //===============================Method Post=================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createEvent(request, response);
                    break;
                case "update":
                    updateEvent(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createEvent(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime hold_time = LocalDateTime.parse(request.getParameter("hold_time"));
        String event_name = request.getParameter("event_name");
        Long fee = Long.valueOf(request.getParameter("fee"));
        String prof_picture = request.getParameter("prof_picture");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        int b_user_id = Integer.parseInt(request.getParameter("b_user_id"));
        Event event = new Event(hold_time,event_name,fee,prof_picture,description,address,b_user_id);
        eventController.create(event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/create");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) {

    }
}