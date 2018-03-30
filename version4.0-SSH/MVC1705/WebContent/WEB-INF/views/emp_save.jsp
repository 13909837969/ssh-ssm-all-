<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>员工注册页面</title>
</head>
<body>
	<h1>Emp Registry</h1>
	<form action="${pageContext.request.contextPath }/emp_save.action" method="post">
	<table border="1">
		<tr>
			<td>ename</td>
			<td><input type="text" name="ename" value="TIGER"></td>
		</tr>
		<tr>
			<td>sal</td>
			<td><input type="text" name="sal" value="4500"></td>
		</tr>
		<tr>
			<td>hiredate</td>
			<td><input type="date" name="hiredate" value="2018-01-01"></td>
		</tr>
		<tr>
			<td><input type="submit" value="registry"></td>
			<td><input type="reset" value="reset"></td>
		</tr>
	</table>
	</form>
</body>
</html>