<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-12-21
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    #container{
      height: 64px;
      width: 1000px;
      margin: auto;
      padding: 30px;
    }
    #login{
      position: absolute;
      left: 1190px;
      top: 75px;
    }
    #nav { /*전체 메뉴 스타일*/
      list-style: none;
      height: 50px;
      padding: 5px 1px;
      margin: 10px 0px;
      background: red;
    }
    #nav li{
      float: left;
      position: relative;
      margin: 12px 58px;
      padding: 0;
    }
    #nav li a{
      text-decoration: none;
      color: azure;
      font-size: 17px;
    }
  </style>
</head>
<body>
<div id="container">
  <div>
    <a href="#"><img src="img/logo.png" alt="로고이미지"> </a>
    <div id="login">님 <input type="button" onclick="location.href='#'" value="로그인"></div>
  </div>
  <div>
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
</div>
</body>
</html>
