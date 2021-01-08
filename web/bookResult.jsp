<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2021-01-07
  Time: 오후 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h3{
            color: red;
        }
    </style>
</head>
<body>
<h3>■ 옵션 선택</h3>
<table width="1000">
    <tr>
        <td align="center" colspan="2">
            <img src="img/${img}" alt="차량 이미지" width="470">
        </td>
    </tr>
    <tr align="center">
        <td>
            <span>
                대여 금액: ${price * days1} 원<br>
                <span style="color: grey">${price} (원) * ${days1} (대여일)<br></span>
                옵션 금액: ${options} 원<br>
                총 금액 : ${total_cost} 원<br>
            </span>
    </tr>
    <tr align="center">
        <td colspan="2">
            <input type="button" onclick="location.href='#'" value="예약 확인하기">
        </td>
    </tr>
</table>
</body>
</html>
