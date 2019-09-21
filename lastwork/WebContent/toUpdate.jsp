<%@page import="com.hk.bean.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新页面</title>
</head>
<body>

	    用户: ${sessionScope.userName}登录系统了
        &nbsp;&nbsp;&nbsp;<a href='logout.do'>退出系统</a>
        <c:if test="${!empty requestScope.emp}">
        <form action='update.do'  method='post'>
        员工编号：<input type='text' name='empno' value='${requestScope.emp.empno}' readonly><br>
   员工姓名：<input type='text' name='ename' value='${requestScope.emp.ename}'><br>
   工作岗位：<input type='text' name='job' value='${requestScope.emp.job}'><br>  
   领导编号：<input type='text' name='mgr' value='${requestScope.emp.mgr }'><br>   
   入职日期：<input type='text' name='hiredate' value='<fmt:formatDate value='${requestScope.emp.hiredate}' pattern='yyyy-MM-dd'/>'><br>
   员工工资：<input type='text' name='sal' value='${requestScope.emp.sal}'><br>
   员工津贴：<input type='text' name='comm' value='${requestScope.emp.comm}'><br>
   部门编号：<input type='text' name='deptno' value='${requestScope.emp.deptno}'><br>
   <input type='submit' value='修改'>
        </form>
        </c:if>
         <c:if test="${empty requestScope.emp}">
                      查无此人
         </c:if>

</body>
</html>