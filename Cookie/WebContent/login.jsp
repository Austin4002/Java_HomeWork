<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动登录</title>
</head>
<body>

	<div align="center" >
		<form action="${pageContext.request.contextPath}/AutoLogin" method="post">
		<table border="0">
		<tr>
			<td>用户名:</td>
			<td><input type="text" name = "username" /></td>
		<tr>
			<td>密码:</td>
			<td><input  type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="autoLogin"/>自动登录</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="登录"/></td>
		</tr>
		</table>
		</form>
	</div>

</body>
</html>