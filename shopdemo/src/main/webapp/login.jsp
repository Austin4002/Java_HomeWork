<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>



<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div align="center">

		<form id="myform" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/login" method="post">
			<div class="form-group">
				<c:if test="${!empty msg }">
					<span>${msg }</span>
				</c:if>
				<label for="firstname" class="col-sm-4 control-label">用户名:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="nickName"
						name="nickName" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-4 control-label">密码：</label>
				<div class="col-sm-4">
					<input type="password" name="password" class="form-control"
						id="password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-default">登录</button>
				</div>
			</div>
		</form>

	</div>
	<script type="text/javascript">
		$(function() {
			$("#myform").validate({
				rules : {
					"nickName" : {
						"required" : true,
					},
					"password" : {
						"required" : true,
						"rangelength" : [ 6, 12 ]
					}
				},
				message : {
					"nickName" : {
						"required" : "用户名不能为空",
					},
					"password" : {
						"required" : "密码不能为空",
						"rangelength" : "密码长度为6-12位"
					}
				}
			})
		});
	</script>
</body>
</html>