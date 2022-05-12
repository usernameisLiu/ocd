<%@ page import="com.Bean.StudentInfomation" %><%--
  Created by IntelliJ IDEA.
  User: 36046
  Date: 2022/5/6
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dao" class="com.Dao.StudentDao" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    StudentInfomation studentInfomation=dao.readDataTable();
%>
<table border="1" cellpadding="2" cellspacing="1" bgcolor="white">
    <tr><th align="center" colspan="2">个人详细信息</th></tr>
    <tr align="center"><td>学号：</td><td><%%></td></tr>
    <tr align="center"><td>姓名：</td><td><%%></td></tr>
    <tr align="center"><td>性别：</td><td><%%></td></tr>
    <tr align="center"><td>年龄：</td><td><%%></td></tr>
    <tr align="center"><td>班级：</td><td><%%></td></tr>
    <tr align="center"><td>专业：</td><td><%%></td></tr>
    <tr align="center"><td>院系：</td><td><%%></td></tr>
</table>
</body>
</html>
