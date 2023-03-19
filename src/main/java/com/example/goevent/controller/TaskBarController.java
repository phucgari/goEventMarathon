package com.example.goevent.controller;

import com.example.goevent.model.BusinessUser;
import com.example.goevent.model.NormalUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TaskBarController {
    public static void setUpTaskBar(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        if(session.getAttribute("n_user_id")!=null){
            int n_user_id= (int) session.getAttribute("n_user_id");
            NormalUserController normalUserController=new NormalUserController();
            NormalUser user=normalUserController.showByIndex(n_user_id);
            request.setAttribute("user",user);
        } else if (session.getAttribute("b_user_id")!=null) {
            int b_user_id= (int) session.getAttribute("b_user_id");
            BusinessUserController businessUserController=new BusinessUserController();
            BusinessUser user=businessUserController.showByIndex(b_user_id);
            request.setAttribute("user",user);
        }else{
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
