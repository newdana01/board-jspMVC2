<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-12-22
  Time: 오후 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HAPPY RENTCAR</title>
    <style>
/*        #main{
            width: 1000px;
            margin: auto;
            border: 1px solid grey;
        }*/
    </style>
</head>
<body>
<table width="1000" align="center">
    <tr>
        <td>
            <jsp:include page="top.jsp"/>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="${center}"/>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="bottom.jsp"/>
        </td>
    </tr>
</table>
<%--<div id="main">
    <!--top-->
    <div id="top">
        <jsp:include page="top.jsp"/>
    </div>
    <!--center-->
    <div id="center">
        <jsp:include page="${center}"/>
    </div>
    <!--bottom-->
    <div id="bottom">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>--%>
</body>
</html>
