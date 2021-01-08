<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2021-01-05
  Time: 오후 7:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        h3{
            color: red;
        }
    </style>
</head>
<body>
<h3>■ 전체 목록</h3>
<table width="1000">
    <c:set var="i" value="0"/>
    <c:forEach var="carDTO" items="${carDTOS}">
        <c:if test="${(i mod 3) == 0}">
            <tr/>
        </c:if>
                <td align="center">
                    <a href="CarInfoCon?cno=${carDTO.cno}">
                        <img src="img/${carDTO.img}" alt="${carDTO.cname}" width="300" height="220">
                    </a>
                    <br>
                    <span>${carDTO.cname}</span>
                </td>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
</table>
<br>
<form action="CarListCon" method="post" align="center">
    <select name="category">
        <option value="1">소형</option>
        <option value="2">중형</option>
        <option value="3">대형</option>
    </select>
    <input type="submit" value="검색">
    <input type="button" onclick="location.href='CarTotalListCon'" value="전체검색">
</form>
</body>
</html>
