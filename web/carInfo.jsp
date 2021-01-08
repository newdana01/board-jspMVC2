<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2021-01-05
  Time: 오후 8:59
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
<h3>■ ${carDTO.cname}</h3>
<form action="BookOptionCon" method="post">
    <table width="1000">
        <tr height="60" align="center">
            <td width="500" rowspan="5">
                <img src="img/${carDTO.img}" alt="${carDTO.cname}" width="450">
            </td>
            <td width="250">차량 이름</td>
            <td width="250">${carDTO.cname}</td>
        </tr>
        <tr align="center">
            <td width="250">차량 분류</td>
            <td width="250">
                <c:choose>
                    <c:when test="${carDTO.category == 1}">
                        소형
                    </c:when>
                    <c:when test="${carDTO.category == 2}">
                        중형
                    </c:when>
                    <c:otherwise>
                        대형
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr align="center">
            <td width="250">대여 가격</td>
            <td width="250">${carDTO.price} 원/1h</td>
        </tr>
        <tr align="center">
            <td width="250">제조 회사</td>
            <td width="250">${carDTO.company}</td>
        </tr>
        <tr align="center">
            <td width="250" colspan="2">
                <input type="hidden" name="cno" value="${carDTO.cno}">
                <input type="hidden" name="img" value="${carDTO.img}">
                <input type="submit" value="옵션선택 및 예약하기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
