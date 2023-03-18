package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
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

        HttpSession session = request.getSession();

        int b_user_id = (int) session.getAttribute("b_user_id");

        String[] tagsArr = request.getParameterValues("tag_name");
        ArrayList<String> tags = new ArrayList<>();
        for (String tag : tagsArr) {
            tags.add(tag);
        }

        String[] picArr = request.getParameterValues("src");
        ArrayList<String> pics = new ArrayList<>();
        for (String pic : picArr) {
            pics.add(pic);
        }
        eventController.create(new Event(hold_time, event_name, fee, prof_picture, pics, tags, description, address, b_user_id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/create");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) {

    }
}
