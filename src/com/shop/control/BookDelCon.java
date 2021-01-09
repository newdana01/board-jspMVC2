package com.shop.control;

import com.shop.model.CarDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BookDelCon")
public class BookDelCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rno = Integer.parseInt(request.getParameter("rno"));

        CarDAO carDAO = new CarDAO();
        carDAO.delBook(rno);

        String center = "bookLookup.jsp";
        String msg = "예약이 취소되었습니다";
        request.setAttribute("msg", msg);
        request.setAttribute("center", center);
        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);
    }
}
