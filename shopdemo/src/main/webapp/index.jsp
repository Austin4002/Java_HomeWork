<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城首页</title>
</head>
<body>
	<c:if test="${empty loginUser }">
		<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
		<li><a href="${pageContext.request.contextPath}/register.jsp">注册</a></li>
	</c:if>
	<li><a href="">购物车</a></li>
	<c:if test="${not empty loginUser }">
		<div>欢迎:${loginUser.nickName }</div>
		<li><a href="">我的订单</a></li>
		<li><a href="">退出</a></li>
	</c:if>
	<br>
	<c:forEach items="${allCategory }" var="category">
		<li value="${category.cid }"><a href="" >${category.cname }</a></li>
	</c:forEach>
	
	<c:forEach items="${topProduct }" var="product">
		<li value="${product.product_id }"><a href="" >${product.product_price }:${product.product_name }</a></li>
	</c:forEach>
</body>
</html>