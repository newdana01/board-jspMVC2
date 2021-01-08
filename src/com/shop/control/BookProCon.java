package com.shop.control;

import com.shop.model.BookDTO;
import com.shop.model.CarDAO;
import com.shop.model.CarDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/BookProCon")
public class BookProCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String img = request.getParameter("img");
        int cno = Integer.parseInt(request.getParameter("cno"));
        String id = request.getParameter("id");
        String rent_date = request.getParameter("rent_date");
        String return_date = request.getParameter("return_date");
        int ins = Integer.parseInt(request.getParameter("ins"));
        int wifi = Integer.parseInt(request.getParameter("wifi"));
        int nav = Integer.parseInt(request.getParameter("nav"));
        int seat = Integer.parseInt(request.getParameter("seat"));

        //날짜 계산 파트
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date today = null;
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(rent_date);
            d2 = sdf.parse(return_date);
            today = sdf.parse(sdf.format(date)); //현재 시스템 날짜
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long calDate1 = d2.getTime() - d1.getTime(); //rent_date과 return_date 간 차이
        long days1 = calDate1 / (24*60*60*1000) + 1;

        long calDate2 = d1.getTime()  - today.getTime(); //rent_date과 현재 시스템 날짜간 차이
        long days2 = calDate2 / (24*60*60*1000);

        if((days1-1) < 0){ //선택된 반납 날짜가 대여 날짜보다 이전인 경우
            String msg = "반납 날짜가 대여 날짜보다 빠릅니다.";
            String center = "bookOption.jsp";
            request.setAttribute("msg", msg);
            request.setAttribute("center", center);
            RequestDispatcher rd = request.getRequestDispatcher("MainCon");
            rd.forward(request, response);
        }else if(days1 >= 5){ //총 대여 일수가 5일 이상인 경우
            String msg = "최대 5일 이상 대여하실 수 없습니다.";
            String center = "bookOption.jsp";
            request.setAttribute("msg", msg);
            request.setAttribute("center", center);
            RequestDispatcher rd = request.getRequestDispatcher("MainCon");
            rd.forward(request, response);
        }else if(days2 < 0){ //선택된 대여날짜가 현재 시스템 날짜보다 이전인 경우
            String msg = "현재 시스템 날짜보다 이전 날짜는 예약할 수 없음.";
            String center = "bookOption.jsp";
            request.setAttribute("msg", msg);
            request.setAttribute("center", center);
            RequestDispatcher rd = request.getRequestDispatcher("MainCon");
            rd.forward(request, response);
        }else{
            //옵션 및 전체 금액 계산
            CarDAO carDAO = new CarDAO();
            CarDTO carDTO = carDAO.getInfo(cno); //해당 차량의 대여비 가져오기
            int price = carDTO.getPrice();

            int insCost = 0;
            int wifiCost = 0;
            int seatCost = 0;

            if(ins == 1){ insCost = 10000; } //보험을 적용한 경우
            if(wifi == 1){ wifiCost = 10000; } //와이파이를 적용한 경우
            if(seat == 1 ){ seatCost = 10000; } //베이비시트를 적용한 경우

            int total_cost = (int) days1 * (price + insCost + wifiCost + seatCost); //총 대여금액

            BookDTO bookDTO = new BookDTO();
            bookDTO.setCno(cno);
            bookDTO.setId(id);
            bookDTO.setTotal_cost(total_cost);
            bookDTO.setRent_date(rent_date);
            bookDTO.setReturn_date(return_date);
            bookDTO.setIns(ins);
            bookDTO.setWifi(wifi);
            bookDTO.setNav(nav);
            bookDTO.setSeat(seat);

            carDAO.insertBooking(bookDTO); //예약 정보를 DB에 저장

            String center = "bookResult.jsp";
            request.setAttribute("center", center);
            request.setAttribute("img", img);
            request.setAttribute("price", price);
            request.setAttribute("options", insCost + wifiCost + seatCost);
            request.setAttribute("days1", days1);
            request.setAttribute("total_cost", total_cost);
            RequestDispatcher rd = request.getRequestDispatcher("MainCon");
            rd.forward(request, response);
        }
    }
}
