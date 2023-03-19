package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.model.BusinessUser;
import com.example.goevent.model.Event;
import com.example.goevent.model.NormalUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

            switch (action) {
                case "create":
                    createForm(request, response);
                    break;
                case "update":
                    updateForm(request, response);
                    break;
                case "list-users-in-event":
                    listUsersInEvent(request, response);
                    break;
                case "show-1-event":
                    show1event(request,response);
                    break;
                default:
                    listEvents(request, response);
                    break;
            }

    }

    private void show1event(HttpServletRequest request, HttpServletResponse response) {
        int event_id= Integer.parseInt(request.getParameter("event_id"));
        Event event=eventController.showByIndex(event_id);
        request.setAttribute("event",event);
        try {
            request.getRequestDispatcher("/show1Event.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listUsersInEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("event_id"));
        List<NormalUser> normalUsers = eventController.showAllUserInEvent(id);
        request.setAttribute("user", normalUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/showListNUsers.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
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
        int event_id = Integer.parseInt(request.getParameter("event_id"));
        Event event = eventController.showByIndex(event_id);
        request.setAttribute("event", event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("b_user_id");
        List<Event> events = eventController.showAllEventForBUser(id);
        request.setAttribute("events", events);
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/showListEventsByBUser.jsp");
        dispatcher.forward(request, response);
    }


    //===============================Method Post=================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEvent(request, response);
                break;
            case "update":
                updateEvent(request, response);
                break;
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

        String[] tagsArr = request.getParameter("tag_name").split("\n");
        ArrayList<String> tags = new ArrayList<>();
        if (tagsArr != null) {
            for (String tag : tagsArr) {
                tags.add(tag);
            }
        }

        String[] picArr = request.getParameter("src").split("\n");
        ArrayList<String> pics = new ArrayList<>();
        if (picArr != null) {
            for (String pic : picArr) {
                pics.add(pic);
            }
        }
        eventController.create(new Event(hold_time, event_name, fee, prof_picture, pics, tags, description, address, b_user_id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("event/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime hold_time = null;
        if (request.getParameter("hold_time") != null) {
            hold_time=LocalDateTime.parse(request.getParameter("hold_time"));
        }
        String event_name = request.getParameter("event_name");
        Long fee = 0L;
        if (request.getParameter("fee") != null) {
            fee = Long.parseLong(request.getParameter("fee"));
        }
        String prof_pic = request.getParameter("prof_picture");
        String desc = request.getParameter("description");
        String address = request.getParameter("address");

        int event_id = Integer.parseInt(request.getParameter("event_id"));


        HttpSession session = request.getSession();
        int b_user_id = (int) session.getAttribute("b_user_id");

        String[] picArrs = request.getParameterValues("src");
        ArrayList<String> pics = new ArrayList<>();
        for (String pic : picArrs) {
            pics.add(pic);
        }

        String[] tagArrs = request.getParameterValues("tag_name");
        ArrayList<String> tags = new ArrayList<>();
        for (String tag : tagArrs) {
            tags.add(tag);
        }
        Event event = new Event(event_id,hold_time, event_name, fee, prof_pic, pics, tags, desc, address, b_user_id);
        eventController.update(event);
        try {
            response.sendRedirect("/events");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
