<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	
 	<br>
	<div align="center" style="magin:auto;float:right">
		<c:forEach items="${pageBean.list }" var="pro">
			<div class="col-sm-6 col-md-3">
				<a class="thumbnail" href="${pageContext.request.contextPath }/product?method=productInfo&product_id=${pro.product_id}&cid=${cid}&currentPage=${pageBean.currentPage}">
					<img src="${pro.product_image }" alt="图片找到不啦">
				</a>
				<a class="caption" align="center" href="${pageContext.request.contextPath }/product?method=productInfo&product_id=${pro.product_id}&cid=${cid}&currentPage=${pageBean.currentPage}">
					<h3>${pro.product_name }</h3>
					<p>售价:${pro.product_price }</p>
				</a>
			</div>
		</c:forEach>
	</div>

	<!-- 分页 -->
	<div align="center" style="margin:auto">
		<ul class="pagination">

			<!-- 上一页 -->
			<c:if test="${pageBean.currentPage == 1 }">
				<li class="disabled"><a href="javascript:;">&laquo;</a></li>
			</c:if>
			<c:if test="${pageBean.currentPage != 1 }">
				<li><a
					href="${pageContext.request.contextPath }/product?method=productList&cid=${cid}&currentPage=${pageBean.currentPage-1}">&laquo;</a></li>
			</c:if>

			<!-- 显示每一页 -->
			<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<c:if test="${page == PageBean.currentPage }">
					<li class="active"><a href="javascript:;">${page }</a></li>
				</c:if>
				<c:if test="${page != PageBean.currentPage }">
					<li><a
						href="${pageContext.request.contextPath }/product?method=productList&cid=${cid}&currentPage=${page}">${page }</a></li>
				</c:if>
			</c:forEach>

			<!-- 下一页 -->
			<c:if test="${pageBean.currentPage == pageBean.totalPage }">
				<li class="disabled"><a href="javascript:;">&raquo;</a></li>
			</c:if>
			<c:if test="${pageBean.currentPage != pageBean.totalPage }">
				<li><a
					href="${pageContext.request.contextPath }/product?method=productList&cid=${cid}&currentPage=${pageBean.currentPage+1}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>