<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>员工信息修改</title>
</head>
<body>
	<h1>Emp Info Update</h1>
	<form action="${pageContext.request.contextPath }/EmpUpdateAction" method="post" onsubmit="return confirm('确定更新吗？')">
	<table border="1">
		<tr>
			<td>empno</td>
			<td>${updateEmp.empno } <input type="hidden" name="empno" value="${updateEmp.empno }"></td>
		</tr>

		<tr>
			<td>ename</td>
			<td><input type="text" name="ename" value="${updateEmp.ename }"></td>
		</tr>
		<tr>
			<td>sal</td>
			<td><input type="text" name="sal" value="${updateEmp.sal }"></td>
		</tr>
		<tr>
			<td>hiredate</td>
			<td><input type="date" name="hiredate" value="${updateEmp.hiredate }"></td>
		</tr>
		<tr>
			<td><input type="submit" value="update"></td>
			<td><input type="reset" value="reset"></td>
		</tr>
	</table>
	</form>
</body>
</html>