package com.example.goevent.view;

import com.example.goevent.controller.NormalUserController;
import com.example.goevent.model.NormalUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NormalUserServlet", value = "/nuser")
public class NormalUserServlet extends HttpServlet {
    NormalUserController normalUserController = new NormalUserController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                showCreateNewNormalUser(request, response);
                break;
            case "edit":
                showEditNormalUser(request, response);
                break;
            case "login":
                showFormLoginNormal(request, response);
                break;
            default:
                showALlNormalUser(request, response);
        }
    }

    private void showFormLoginNormal(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showALlNormalUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<NormalUser> normalUsers = normalUserController.showAll();
            request.setAttribute("normal", normalUsers);
            request.getRequestDispatcher("nUser/normal.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditNormalUser(HttpServletRequest request, HttpServletResponse response) {
        int normalUserId = Integer.parseInt(request.getParameter("normalUserId"));
        NormalUser normalUser = normalUserController.showByIndex(normalUserId);
        request.setAttribute("normalUser", normalUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(".jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateNewNormalUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("login/signupN.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createNewNormalUser(request, response);
                break;
            case "edit":
                updateNormalUser(request, response);
        }
    }

    private void updateNormalUser(HttpServletRequest request, HttpServletResponse response) {
        int normalUserId = Integer.parseInt(request.getParameter("normalUserId"));
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        NormalUser normalUser = new NormalUser(password, fullName, avatar, phone, normalUserId, age, gender, address, email);
        normalUserController.update(normalUser);
        try {
            response.sendRedirect("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createNewNormalUser(HttpServletRequest request, HttpServletResponse response) {
        String login_name = request.getParameter("login_name");
        String password = request.getParameter("password");
        String fullName = request.getParameter("name");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        NormalUser normalUser = new NormalUser(login_name, password, fullName, avatar, phone, age, gender, address, email);
        normalUserController.create(normalUser);
        try {
            request.getRequestDispatcher("login/signupN.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}