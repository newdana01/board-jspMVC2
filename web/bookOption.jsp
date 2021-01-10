<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2021-01-07
  Time: 오전 10:25
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
        history.back();
    </script>
</c:if>
<h3>■ 옵션 선택</h3>
<form action="BookProCon" method="post">
    <table width="1000">
        <tr height="60" align="center">
            <td width="500" rowspan="6 ">
                <img src="img/${img}" alt="차이미지" width="450" height="300">
            </td>
            <td width="250">대여 날짜</td>
            <td width="250">
                <input type="date" name="rent_date">
            </td>
        </tr>
        <tr align="center">
            <td width="250">반납 날짜</td>
            <td width="250">
                <input type="date" name="return_date">
            </td>
        </tr>
        <tr align="center">
            <td width="250">보험 적용</td>
            <td width="250">
                <select name="ins">
                    <option value="1">적용 (1일 1만원)</option>
                    <option value="2" selected>비적용</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td width="250">와이파이</td>
            <td width="250">
                <select name="wifi">
                    <option value="1">적용 (1일 1만원)</option>
                    <option value="2" selected>비적용</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td width="250">네비게이션</td>
            <td width="250">
                <select name="nav">
                    <option value="1">적용 (무료)</option>
                    <option value="2" selected>비적용</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td width="250">베이비시트</td>
            <td width="250">
                <select name="seat">
                    <option value="1">적용 (1일 1만원)</option>
                    <option value="2" selected>비적용</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td width="250" colspan="3">
                <input type="hidden" name="img" value="${img}">
                <input type="hidden" name="cno" value="${cno}">
                <input type="hidden" name="id" value="${id}">
                <input type="submit" value="차량 예약하기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
