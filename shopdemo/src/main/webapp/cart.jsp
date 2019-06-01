<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript">
		function delProFromCart(product_id) {
			if (confirm("您确定要删除该项？")) {
				location.href = "${pageContext.request.contextPath }/product?method=delProFromCart&product_id="+product_id;
			}
		}
		
		function clearCart(){
			if(confirm("您是否要清空购物车？")){
				location.href = "${pageContext.request.contextPath }/product?method=clearCart";
			}
			
		}
</script>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
<div>
	<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0" align="center"
		style="margin-left: 200px;">
		<div class="widget dashboard-container my-adslist">
			<h3 class="widget-header">我的购物车</h3>
			<table class="table table-responsive product-dashboard-table">
				<thead>
					<tr>
						<th>图片</th>
						<th class="text-center">物品名称</th>
						<th class="text-center">单价</th>
						<th class="text-center">购买数量</th>
						<th class="text-center">小计</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${cart.cartItems }" var="entry">
						<tr>
							<td class="product-thumb"><img width="100px" height="auto"
								src="${pageContext.request.contextPath }/${entry.value.product.product_image}"
								alt="图片找不到啦"></td>
							<td class="product-thumb">
								<div align="center">
									<strong>${entry.value.product.product_name}</strong>
								</div>
							</td>
							<td class="product-thumb">
								<div align="center">
									<strong>￥${entry.value.product.product_price}</strong>
								</div>
							</td>
							<td class="product-thumb">
								<div align="center">
									<input name="buyNum" min="1" value="${entry.value.buyNum}"
										type="number">
								</div>
							</td>
							<td class="product-thumb">
								<div align="center">
									<strong>￥${entry.value.subtotal}</strong>
								</div>
							</td>
							<!--操作-->
							<td class="action" data-title="Action">
								<div>
									<ul class="list-inline justify-content-center">
										<li class="list-inline-item">
										<!-- 
										<a class="delete" href="${pageContext.request.contextPath }/product?method=delProFromCart&product_id=${entry.value.product.product_id}" onclick="delProFromCart('${entry.value.product.product_id}')"> <i class="fa fa-trash"></i>
										</a>
										 -->
										<button class="btn btn-danger" onclick="delProFromCart('${entry.value.product.product_id}')"><i class="fa fa-trash"></i></button>
										</li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	<div>
		<h3>总计:${cart.total }</h3>
		<button type="button" class="btn btn-danger" onclick="clearCart()">清空购物车</button>
	</div>
	
</body>
</html>