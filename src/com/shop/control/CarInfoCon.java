package com.shop.control;

import com.shop.model.CarDAO;
import com.shop.model.CarDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarInfoCon")
public class CarInfoCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cno = Integer.parseInt(request.getParameter("cno"));
        String center = "carInfo.jsp";

        CarDAO carDAO = new CarDAO();
        CarDTO carDTO = carDAO.getInfo(cno);

        request.setAttribute("carDTO", carDTO);
        request.setAttribute("center", center);
        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);
    }
}
