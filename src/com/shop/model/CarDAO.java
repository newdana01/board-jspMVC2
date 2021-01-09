package com.shop.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarDAO {
    Connection con;
    DataSource dataSource;
    PreparedStatement pst;
    ResultSet res;

    public void getCon(){
        try{
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysqlDB");
            con = dataSource.getConnection();

            pst = con.prepareStatement("USE rentcar");
            pst.execute();
            pst.clearParameters();
        }catch (Exception e1){
            e1.printStackTrace();
            try{
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public String getMember(String id){
        String passCheck="";

        getCon();
        try{
            String sql = "SELECT pass FROM car_member WHERE id=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            res = pst.executeQuery();

            if(res.next()){
                passCheck = res.getString(1);
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                if(res!=null) res.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return passCheck;
    }

    public ArrayList<CarDTO> getLatest() {
        getCon();
        ArrayList<CarDTO> carDTOS = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rentcar ORDER BY cno DESC LIMIT 3"; //등록된 차 중 최신 3개만 가져옴
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();

            while (res.next()) {
                CarDTO carDTO = new CarDTO();

                carDTO.setCno(res.getInt(1));
                carDTO.setCname(res.getString(2));
                carDTO.setCategory(res.getInt(3));
                carDTO.setPrice(res.getInt(4));
                carDTO.setUsepeople(res.getInt(5));
                carDTO.setCompany(res.getString(6));
                carDTO.setImg(res.getString(7));
                carDTO.setInfo(res.getString(8));

                carDTOS.add(carDTO);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return carDTOS;
    }

    public ArrayList<CarDTO> getCarList(){
        getCon();
        ArrayList<CarDTO> carDTOS = new ArrayList<>();

        try{
            String sql = "SELECT * FROM rentcar";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();

            while (res.next()) {
                CarDTO carDTO = new CarDTO();

                carDTO.setCno(res.getInt(1));
                carDTO.setCname(res.getString(2));
                carDTO.setCategory(res.getInt(3));
                carDTO.setPrice(res.getInt(4));
                carDTO.setUsepeople(res.getInt(5));
                carDTO.setCompany(res.getString(6));
                carDTO.setImg(res.getString(7));
                carDTO.setInfo(res.getString(8));

                carDTOS.add(carDTO);
            }
        }catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return carDTOS;
    }

        public ArrayList<CarDTO> getCarList(int category){
            getCon();
            ArrayList<CarDTO> carDTOS = new ArrayList<>();

            try{
                String sql = "SELECT * FROM rentcar WHERE category=?"; //선택된 카테고리에 속하는 것만 가져옴
                pst = con.prepareStatement(sql);
                pst.setInt(1, category);
                res = pst.executeQuery();

                while (res.next()) {
                    CarDTO carDTO = new CarDTO();

                    carDTO.setCno(res.getInt(1));
                    carDTO.setCname(res.getString(2));
                    carDTO.setCategory(res.getInt(3));
                    carDTO.setPrice(res.getInt(4));
                    carDTO.setUsepeople(res.getInt(5));
                    carDTO.setCompany(res.getString(6));
                    carDTO.setImg(res.getString(7));
                    carDTO.setInfo(res.getString(8));

                    carDTOS.add(carDTO);
                }
            }catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (res != null) res.close();
                    if (pst != null) pst.close();
                    if (con != null) con.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return carDTOS;
        }

        public CarDTO getInfo(int cno){
        getCon();
        CarDTO carDTO = new CarDTO();

        try {
            String sql = "SELECT * FROM rentcar WHERE cno =?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cno);
            res = pst.executeQuery();

            if(res.next()){
                carDTO.setCno(res.getInt(1));
                carDTO.setCname(res.getString(2));
                carDTO.setCategory(res.getInt(3));
                carDTO.setPrice(res.getInt(4));
                carDTO.setUsepeople(res.getInt(5));
                carDTO.setCompany(res.getString(6));
                carDTO.setImg(res.getString(7));
                carDTO.setInfo(res.getString(8));
            }

        }catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return  carDTO;
        }

    public void insertBooking(BookDTO bookDTO) { //예약 정보를 저장
        getCon();

        try{
            String sql = "INSERT INTO car_reservation VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, bookDTO.getCno());
            pst.setString(2, bookDTO.getId());
            pst.setInt(3, bookDTO.getTotal_cost());
            pst.setString(4, bookDTO.getRent_date());
            pst.setString(5, bookDTO.getReturn_date());
            pst.setInt(6, bookDTO.getIns());
            pst.setInt(7, bookDTO.getWifi());
            pst.setInt(8, bookDTO.getNav());
            pst.setInt(9, bookDTO.getSeat());
            pst.executeUpdate();
        }catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ArrayList<LookupDTO> getBook(String id) { //현재 날짜 이후의 해당 회원의 예약 정보를 가져옴
        getCon();
        ArrayList<LookupDTO> lookupDTOS = new ArrayList<>();

        try{
            String sql = "SELECT rno, cname, img, total_cost, rent_date, return_date, ins, wifi, nav, seat" +
                    " FROM rentcar a JOIN car_reservation b ON a.cno = b.cno WHERE id=? AND rent_date >= DATE(NOW())";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            res = pst.executeQuery();

            while(res.next()){
                LookupDTO lookupDTO = new LookupDTO();
                lookupDTO.setRno(res.getInt(1));
                lookupDTO.setCname(res.getString(2));
                lookupDTO.setImg(res.getString(3));
                lookupDTO.setTotal_cost(res.getInt(4));
                lookupDTO.setRent_date(res.getString(5));
                lookupDTO.setReturn_date(res.getString(6));
                lookupDTO.setIns(res.getInt(7));
                lookupDTO.setWifi(res.getInt(8));
                lookupDTO.setNav(res.getInt(9));
                lookupDTO.setSeat(res.getInt(10));

                lookupDTOS.add(lookupDTO);
            }
        }catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lookupDTOS;
    }
}
