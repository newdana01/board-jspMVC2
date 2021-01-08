<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-12-22
  Time: 오후 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        h2{
            color: red;
            text-align: center;
        }
        #container{
            width: 300px;
            margin: auto;
        }
        .row::after{
            content: "";
            display: table;
            clear: both;
            /*padding: 5px;*/
        }
        .column{
            float: left;
            width: 10%;
        }
        .row > :only-child{
            margin: 0px 125px;
        }
    </style>
</head>
<body>
<c:if test="${msg!=null}">
    <script>
        alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
    </script>
</c:if>
<div id="container">
    <h2>Log in</h2>
    <form action="LoginProcCon" method="post">
        <div class="row">
            <div class="column">
                <label>아이디</label>
            </div>
            <div class="column">
                <input type="text" name="id" size="20">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label>비밀번호</label>
            </div>
            <div class="column">
                <input type="password" name="pass" size="20">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="로그인">
        </div>
    </form>
</div>
</body>
</html>
