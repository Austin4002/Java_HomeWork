<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${product.product_name }</title>
</head>
<script type="text/javascript">
function addCart(){
	//获得购买的商品的数量
	var buyNum = $("#buyNum").val();
	
	location.href="${pageContext.request.contextPath}/product?method=addProductToCart&product_id=${product.product_id}&buyNum="+buyNum;
}
</script>

<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<!-- 商品详细信息 -->
	<div class="col-sm-8 col-md-8 col-lg-9" style="margin-left: 250px;">
	  <div class="row">
		<div class="col-md-6">
		  <div><a class="thumbnails"> <img style="height:430px" src="${product.product_image }" alt="图片加载失败" /></a></div>
		</div>
		
		<div class="col-md-6 prodetail caption product-thumb">
		  <h4><a href="javascript:;">${product.product_name }</a></h4>
		  <span>
			<span>
				<span>￥</span>${product.product_price }
			</span>
		  </span>
		  <hr>
		  <ul class="list-unstyled">
			<li>
			  <label>库存:</label>
			  <span> 有货</span>
			</li>
		  </ul>
		  <hr>
		  <p>${product.product_description }</p>
		  <div>
			
			<div class="form-group">
			  <label>购买数量</label>
			  <input id="buyNum" name="buyNum" min="1" value="1" type="number">
			</div>
			<div class="button-group">
			  <div><a href="javascript:;" onclick="addCart()"><span>添加到购物车</span></a></div>
			  <c:if test="${!empty currentPage }">
				  <div><a href="${pageContext.request.contextPath }/product?method=productList&cid=${cid}&currentPage=${currentPage}"><span>返回商品列表</span></a></div>
			  </c:if>
			</div>
		  </div>
		</div>
	  </div>
	</div>

</body>
</html>