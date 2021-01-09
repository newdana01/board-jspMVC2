<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2021-01-09
  Time: 오전 9:35
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
<c:if test="${not empty msg}">
    <script>
        alert("${msg}");
    </script>
</c:if>
<h3>■ 예약 확인</h3>
<form action="BookDelCon" method="post">
    <table width="1000">
        <tr height="40" align="center">
            <td width="150">차량</td>
            <td width="120">차량명</td>
            <td width="150">대여일</td>
            <td width="150">반납일</td>
            <td width="100">대여금액</td>
            <td width="60">보험</td>
            <td width="60">WIFI</td>
            <td width="60">네비게이션</td>
            <td width="60">베이비시트</td>
            <td width="90">취소</td>
        </tr>
        <c:forEach var="lookupDTO" items="${lookupDTOS}">
            <tr align="center">
                <td width="150">
                    <img src="img/${lookupDTO.img}" alt="${lookupDTO.cname}" width="120" width="70">
                </td>
                <td width="120">${lookupDTO.cname}</td>
                <td width="150">${lookupDTO.rent_date}</td>
                <td width="150">${lookupDTO.return_date}</td>
                <td width="100">${lookupDTO.total_cost}</td>
                <td width="60">
                    <c:choose>
                        <c:when test="${lookupDTO.ins == 1}">적용</c:when>
                        <c:otherwise>비적용</c:otherwise>
                    </c:choose>
                </td>
                <td width="60">
                    <c:choose>
                        <c:when test="${lookupDTO.wifi == 1}">적용</c:when>
                        <c:otherwise>비적용</c:otherwise>
                    </c:choose>
                </td>
                <td width="60">
                    <c:choose>
                        <c:when test="${lookupDTO.nav == 1}">적용</c:when>
                        <c:otherwise>비적용</c:otherwise>
                    </c:choose>
                </td>
                <td width="60">
                    <c:choose>
                        <c:when test="${lookupDTO.seat == 1}">적용</c:when>
                        <c:otherwise>비적용</c:otherwise>
                    </c:choose>
                </td>
                <td width="90">
                    <input type="hidden" name="rno" value="${lookupDTO.rno}">
                    <input type="submit" value="예약 취소">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
