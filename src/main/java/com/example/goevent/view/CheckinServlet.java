package com.example.goevent.view;

import com.example.goevent.controller.EventController;
import com.example.goevent.controller.NormalUserProcessor;
import com.example.goevent.controller.TaskBarController;
import com.example.goevent.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckinServlet", value = "/checkin")
public class CheckinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskBarController.setUpTaskBar(request, response);
        int event_id= Integer.parseInt(request.getParameter("event_id"));
        EventController eventController=new EventController();
        Event event=eventController.showByIndex(event_id);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Checkin event "+event.getEventName()+ "?</h1>");
        writer.println("<form method='post'>");
        writer.println("<button type='submit'>Lets go!</button>");
        writer.println("</form>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int event_id= Integer.parseInt(request.getParameter("event_id"));
        int n_user_id= (int) request.getSession().getAttribute("n_user_id");
        NormalUserProcessor userProcessor=new NormalUserProcessor();
        userProcessor.checkInNUser(n_user_id,event_id);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Checkin Successfully</h1>");
        writer.println("</html>");
    }
}
