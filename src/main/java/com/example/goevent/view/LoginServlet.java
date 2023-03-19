package com.example.goevent.view;

import com.example.goevent.controller.LoginController;
import com.example.goevent.model.BusinessUser;
import com.example.goevent.model.NormalUser;
import com.example.goevent.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    LoginController controller = new LoginController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showFormLogin(request, response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("n_user_id") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/signupN.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (request.getParameter("b_user_id") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/signupB.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("password");
        User user = controller.login(login_name, login_password);

        HttpSession session = request.getSession();
        if (user == null) {
            //may sai r
            try {
                response.sendRedirect("http://localhost:8080/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (user instanceof NormalUser) {
            session.setAttribute("n_user_id", ((NormalUser) user).getNormalUserId());
            //forward vao phuc
            try {
                response.sendRedirect("/nuserinside?action=show_all_event");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (user instanceof BusinessUser) {
            session.setAttribute("b_user_id", ((BusinessUser) user).getBusinessUserId());
            //forward vao luc
            try {
                response.sendRedirect("/events");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
