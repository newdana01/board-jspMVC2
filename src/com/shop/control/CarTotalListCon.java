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

@WebServlet("/CarTotalListCon")
public class CarTotalListCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String center = "carTotalList.jsp";

        CarDAO carDAO = new CarDAO();
        ArrayList<CarDTO> carDTOS = carDAO.getCarList();

        request.setAttribute("center", center);
        request.setAttribute("carDTOS", carDTOS);
        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);
    }
}
