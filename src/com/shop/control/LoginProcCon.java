package com.shop.control;

import com.shop.model.CarDAO;
import org.apache.axis.session.Session;
import sun.plugin.dom.core.Element;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginProcCon")
public class LoginProcCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); //사용자에게 입력받은 아이디
        String pass = request.getParameter("pass"); //사용자에게 입력받은 비밀번호

        CarDAO memberDAO = new CarDAO();
        String passCheck = memberDAO.getMember(id); //데이터 베이스에 저장된 비밀번호 가져옴

        if(pass.equals(passCheck)){ //비밀번호가 일치한다면
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60);
            if(session!=null) session.setAttribute("id", id);
            RequestDispatcher rd = request.getRequestDispatcher("MainCon");
            rd.forward(request, response);
        }else {
            request.setAttribute("msg", "1");
            RequestDispatcher rd = request.getRequestDispatcher("main.jsp?center=login.jsp");
            rd.forward(request, response);
        }
    }
}
