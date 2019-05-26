<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<div align="center">
		<form action="${pageContext.request.contextPath}/register" method="post">
			用户名<input type="text" name="nickName" placeholder="请输入用户名"><br>
			真实姓名<input type="text" name="name" placeholder="请输入真实姓名"><br>
			密码<input type="password"  name="password" placeholder="请输入密码"><br>
			确认密码<input type="password"  name="repassword" placeholder="请输入确认密码"><br>
			电话<input type="text" name="phone" placeholder="请输入电话"><br>
			性别<input type="radio"	name="sex" id="sex1" value="male">男
			<input type="radio"	name="sex" id="sex2" value="female">女<br>
			邮箱<input type="text" name="email" placeholder="Email"><br>
			出生日期<input type="date" name="birthday" ><br>
			<input type="submit" value="注册">
		</form>
	</div>
</body>
</html>