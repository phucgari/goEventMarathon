package com.example.goevent.view;

import com.example.goevent.controller.BusinessUserController;
import com.example.goevent.model.BusinessUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BusinessUserServlet", value = "/BusinessUserServlet")
public class BusinessUserServlet extends HttpServlet {

    private BusinessUserController businessUserController;

    public void init() {
        businessUserController = new BusinessUserController();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/signupB.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("business/edit.jsp");
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
                    createNewBusinessU(request, response);
                    break;
                case "update":
                    updateBusinessU(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNewBusinessU(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("login_name");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        BusinessUser businessUser = new BusinessUser(username, password, name, avatar, phone, gender);
        businessUserController.create(businessUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/signupB.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBusinessU(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        BusinessUser businessUser = new BusinessUser(password, name, avatar, phone, gender);
        businessUserController.update(businessUser);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("bUser/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
