package com.shop.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/MainCon")
public class MainCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String center = (String) request.getAttribute("center");
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");

        if(center==null){
            center="center.jsp";
        }

        if(id==null){
            id="GUEST";
        }

        request.setAttribute("center", center);
        request.setAttribute("id", id);
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);

    }
}
