<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>员工信息管理</title>
</head>
<body>
	<h1>Emp MIS</h1>
	<table border="1">
		<tr>
			<td>empno</td>
			<td>ename</td>
			<td>sal</td>
			<td>hiredate</td>
			<td>option</td>
		</tr>
	<c:forEach items="${empListFromServer}" var="emp">
		<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.sal }</td>
			<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy年MM月dd日"/></td>
			<td>
				<a href="${pageContext.request.contextPath }/EmpDeleteAction?empno=${emp.empno }" onclick="return confirm('确认删除吗？')">delete</a>
				<a href="${pageContext.request.contextPath }/EmpFindByIdAction?empno=${emp.empno}&type=update">update</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	<form action="${pageContext.request.contextPath }/EmpFindByIdAction" method="post">
		ID:<input type="text" name="empno" value="4">
		<input type="submit" value="findById">
	</form>
	<form action="${pageContext.request.contextPath }/EmpFindByNameAction" method="post">
		Name:<input type="text" name="ename" value="S">
		<input type="submit" value="findByName">
	</form>
</body>
</html>