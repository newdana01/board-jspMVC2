package com.shop.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BookOptionCon")
public class BookOptionCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        String msg = "";

        if(id == null){
            msg= "로그인 후 이용하세요.";
        }

        int cno = Integer.parseInt(request.getParameter("cno"));
        String img = request.getParameter("img");
        String center = "bookOption.jsp";

        request.setAttribute("cno", cno);
        request.setAttribute("img", img);
        request.setAttribute("center", center);
        request.setAttribute("msg", msg);

        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);
    }
}
