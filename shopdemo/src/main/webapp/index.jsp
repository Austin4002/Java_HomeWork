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
	<jsp:include page="/header.jsp"></jsp:include>
	<br>
	<!-- 
	<c:forEach items="${topProduct }" var="product">
		<li value="${product.product_id }"><a href="" >${product.product_price }:${product.product_name }</a></li>
	</c:forEach>
	 -->

	<div class="container">
		<div class="jumbotron">
			<h1 align="center">最新商品</h1>
		</div>
	</div>

	<div align="center" style="magin: auto; float: right">
		<c:forEach items="${topProduct }" var="pro">
			<div class="col-sm-6 col-md-3">
				<a class="thumbnail"
					href="${pageContext.request.contextPath }/product?method=productInfo&product_id=${pro.product_id}&cid=${pro.cid}">
					<img src="${pro.product_image }" alt="图片找到不啦">
				</a> <a class="caption" align="center"
					href="${pageContext.request.contextPath }/product?method=productInfo&product_id=${pro.product_id}&cid=${pro.cid}">
					<h3>${pro.product_name }</h3>
					<p>售价:${pro.product_price }</p>
				</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>