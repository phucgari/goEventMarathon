package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "NUserInsideServlet", value = "/nuserinside")
public class NUserInsideServlet extends HttpServlet {
    EventController eventController=new EventController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "showAllEvent":
                showAllEvent(request,response);
                break;
            case "showAllRegisteredEvent":
                showAllRegisteredEvents(request,response);
                break;
            case "show1Event":
                show1Event(request,response);
                break;
        }
    }

    private void show1Event(HttpServletRequest request, HttpServletResponse response) {
        int event_id= Integer.parseInt(request.getParameter("event_id"));
        Event event=eventController.showByIndex(event_id);
        request.setAttribute("event",event);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/nUser/show1Event.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllRegisteredEvents(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime timeBegin= request.getParameter("timeBegin")==null?LocalDateTime.MIN:
                LocalDateTime.parse(request.getParameter("timeBegin"));
        LocalDateTime timeEnd =request.getParameter("timeEnd")==null?LocalDateTime.MAX:
                LocalDateTime.parse(request.getParameter("timeEnd"));
        String address=request.getParameter("address")==null?"":
                request.getParameter("address");
        long minFee=request.getParameter("minFee")==null?0:
                Long.parseLong(request.getParameter("minFee"));
        long maxFee=request.getParameter("maxFee")==null?Long.MAX_VALUE:
                Long.parseLong(request.getParameter("maxFee"));
        HttpSession session=request.getSession();
        int n_user_id= (int) session.getAttribute("n_user_id");
        ArrayList<Event> events=eventController.showAllRegisteredEventNUser(timeBegin,timeEnd,address,minFee,maxFee,n_user_id);
        request.setAttribute("events",events);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/nUser/showAllRegisteredEvent.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllEvent(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime timeBegin= request.getParameter("timeBegin")==null?LocalDateTime.MIN:
                LocalDateTime.parse(request.getParameter("timeBegin"));
        LocalDateTime timeEnd =request.getParameter("timeEnd")==null?LocalDateTime.MAX:
                LocalDateTime.parse(request.getParameter("timeEnd"));
        String address=request.getParameter("address")==null?"":
                request.getParameter("address");
        long minFee=request.getParameter("minFee")==null?0:
                Long.parseLong(request.getParameter("minFee"));
        long maxFee=request.getParameter("maxFee")==null?Long.MAX_VALUE:
                Long.parseLong(request.getParameter("maxFee"));
        ArrayList<Event> events=eventController.showAllEventWithFilterNUser(timeBegin,timeEnd,address,minFee,maxFee);
        request.setAttribute("events",events);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/nUser/showAllEvent.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "show1Event":
                show1Event(request,response);
                break;
        }
    }
}
