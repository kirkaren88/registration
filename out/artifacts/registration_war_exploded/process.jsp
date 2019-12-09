<%--
  Created by IntelliJ IDEA.
  User: Karen Kirakosyan
  Date: 12/7/2019
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page import="RegisterDao"%>
<jsp:useBean id="obj" class="User"/>

<jsp:setProperty property="*" name="obj"/>

<%
    int status=RegisterDao.registerUser(obj);
    if(status>0)
        out.print("You are successfully registered");

%>
</body>
</html>
