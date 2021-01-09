package com.shop.control;

import com.shop.model.BookDTO;
import com.shop.model.CarDAO;
import com.shop.model.LookupDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/BookLookupCon")
public class BookLookupCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        String center = "bookLookup.jsp";
        String msg="";

        if(id == null){ //로그인되어 있지 않다면
            msg = "로그인 후 이용하세요";
        }else{
            CarDAO carDAO = new CarDAO();
            ArrayList<LookupDTO> lookupDTOS = carDAO.getBook(id); //DB에서 예약정보를 가져옴
            request.setAttribute("lookupDTOS", lookupDTOS);
        }
        request.setAttribute("center", center);
        request.setAttribute("msg", msg);
        RequestDispatcher rd = request.getRequestDispatcher("MainCon");
        rd.forward(request, response);
    }
}
