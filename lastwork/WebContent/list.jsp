<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hk.bean.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
</head>
<body>
<%
String userName=(String)request.getSession().getAttribute("userName");
	if(userName==null){
		response.sendRedirect("login.html");
		return;
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
     <center>用户：${sessionScope.userName}登陆系统了   <br><a href='logout.do'>退出系统</a>
	
	<table border='1px' width='80%'>
	<tr><td>empno</td><td>ename</td><td>job</td><td>mgr</td><td>hiredate</td><td>sal</td><td>comm</td><td>deptno</td><td>操作</td></tr>
	
	<c:forEach items="${requestScope.elist}" var="e">
	<tr>
	<td>${e.empno}</td>
	<td>${e.ename}</td>
	<td>${e.job}</td>
	<td>${e.mgr}</td>
	<td><fmt:formatDate value='${e.hiredate}' pattern='yyyy-MM-dd'/></td>
	<td>${e.sal}</td>
	<td>${e.comm}</td>
	<td>${e.deptno}</td>
	 <td><a href='del.do?empno=${e.empno}'>删除</a>&nbsp;&nbsp;&nbsp;<a href='toUpdate.do?empno=${e.empno}'>修改</a></td>
	</tr>
	</c:forEach>
	</table><br>
	<a href='add.jsp'>添加员工</a></center>

</body>
</html>