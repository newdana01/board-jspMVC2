<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-12-21
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <style>
    table{
      width: 1000px;
    }
    #menuBar *{
      height: 50px;
      width: 200px;
      background-color: red;
      text-align: center;
    }
    a{
      text-decoration: none;
      color: azure;
    }
  </style>
</head>
<body>
<table>
  <tr height="80">
    <td colspan="4">
      <a href="MainCon"><img src="img/logo.png" alt="로고 이미지" height="65"></a>
    </td>
    <td align="right" width="200"> ${id}님
      <c:if test="${id == 'GUEST'}">
        <input type="button" onclick="location.href='LoginCon'" value="로그인">
      </c:if>
      <c:if test="${id != 'GUEST'}">
        <input type="button" onclick="location.href='LogoutCon'" value="로그아웃">
      </c:if>
    </td>
  </tr>
  <tr id="menuBar">
    <td>
      <a href="BookMainCon">예 약 하 기</a>
    </td>
    <td>
      <a href="#">예 약 확 인</a>
    </td>
    <td>
      <a href="#">자유게시판</a>
    </td>
    <td>
      <a href="#">이  벤  트</a>
    </td>
    <td>
      <a href="#">고 객 센 터</a>
    </td>
  </tr>
</table>
<%--<div id="container">
  <div>
    <a href="MainCon"><img id="logoImg" src="img/logo.png" alt="로고이미지"></a>
    <div id="login">${id}님
      <c:if test="${id == 'GUEST'}">
      <input type="button" onclick="location.href='MainCon?center=login.jsp'" value="로그인">
    </c:if>
      <c:if test="${id != 'GUEST'}">
        <input type="button" onclick="location.href='#'" value="로그아웃">
      </c:if></div>
  </div>
  <div>
    <ul id="nav">
      <li>
        <a href="#">예 약 하 기</a>
      </li>
      <li>
        <a href="#">예 약 확 인</a>
      </li>
      <li>
        <a href="#">자유게시판</a>
      </li>
      <li>
        <a href="#">이  벤  트</a>
      </li>
      <li>
        <a href="#">고 객 센 터</a>
      </li>
    </ul>
  </div>
</div>--%>
</body>
</html>
