package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.controller.NormalUserProcessor;
import com.example.goevent.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "NUserInsideServlet", value = "/user")
public class NUserInsideServlet extends HttpServlet {
    EventController eventController=new EventController();
    NormalUserProcessor userProcessor=new NormalUserProcessor();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "show_all_event":
                showAllEvent(request,response);
                break;
            case "show_all_registered_event":
                showAllRegisteredEvents(request,response);
                break;
            case "show1event":
                show1Event(request,response);
                break;
        }
    }

    private void show1Event(HttpServletRequest request, HttpServletResponse response) {
        int event_id= Integer.parseInt(request.getParameter("event_id"));
        HttpSession session=request.getSession();
        int nUser_id= (int) session.getAttribute("n_user_id");
        Event event=eventController.showByIndex(event_id);
        boolean registerStatus=userProcessor.checkIfUserAlreadyRegistered(nUser_id,event_id);
        request.setAttribute("registerStatus",registerStatus);
        request.setAttribute("event",event);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/nUser/show1Event.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
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
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllEvent(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime timeBegin= request.getParameter("timeBegin")==null?LocalDateTime.of(1900,01,01,00,00,00):
                LocalDateTime.parse(request.getParameter("timeBegin"));
        LocalDateTime timeEnd =request.getParameter("timeEnd")==null?LocalDateTime.of(2100,01,01,00,00,00):
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
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action=request.getParameter("action");
        if(action==null)action="";
        if (action.equals("show1event")) {
            registerNUser(request, response);
        }
    }

    private void registerNUser(HttpServletRequest request, HttpServletResponse response) {
        boolean req= Boolean.parseBoolean(request.getParameter("req"));
        int event_id = Integer.parseInt(request.getParameter("event_id"));
        int n_user_id = (int) request.getSession().getAttribute("n_user_id");
        if(req) {
            userProcessor.registerNUserToEvent(n_user_id, event_id);
        }else{
            userProcessor.unRegisterNUserFromEvent(n_user_id,event_id);
        }
    }
}
