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
import java.util.ArrayList;

@WebServlet("/CarListCon")
public class CarListCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category = Integer.parseInt(request.getParameter("category"));
        String center = "carList.jsp";

        CarDAO carDAO = new CarDAO();
        ArrayList<CarDTO> carDTOS = carDAO.getCarList(category);

        request.setAttribute("carDTOS", carDTOS);
        request.setAttribute("center", center);
        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);

    }
}
