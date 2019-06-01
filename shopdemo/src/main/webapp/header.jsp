<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--引入bootstrap,jquery-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<body>
	<ul class="nav nav-pills" style="background-color: #34374C">
			<c:if test="${empty loginUser}">
				<li><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
				<li><a href="${pageContext.request.contextPath }/register.jsp">注册</a></li>
			</c:if>
			<c:if test="${!empty loginUser}">
				<li><a href="javascript:;">${loginUser.nickName }</a></li>
				<li><a href="javascript:;">退出</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/cart.jsp">购物车</a></li>
			<li><a href="javascript:;">我的订单</a></li>
	</ul>
	
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="${pageContext.request.contextPath }"><span class="glyphicon glyphicon-home">首页</span></a>
	</div>
	<div>
		<ul class="nav navbar-nav" id="categoryUl">
		
		</ul>
	</div>
	</nav>

</body>

<script type="text/javascript">
	//header.jsp加载完毕后去服务端获得所有的category数据
	$(function() {
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/product?method=categoryList",
			function(data) {
				//动态创建<li><a href="#">${category.cname }</a></li>
				for (var i = 0; i < data.length; i++) {
						content += "<li><a href='${pageContext.request.contextPath}/product?method=productList&cid="
								+ data[i].cid
								+ "'>"
								+ data[i].cname
								+ "</a></li>"
					}
					//将拼接好的li放置到ul中
					$("#categoryUl").html(content);
				}, "json");
	})
</script>

</html>