<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	     <!-- 引入JQuery -->
	    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
	    </script>
	    
	    <script>
	    $(function(){
	    	//页面加载完毕后去异步获取分类数据
	    	$.post(
	    			"${pageContext.request.contextPath}/admin?method=findAllCategory",
					function(data) {
	    				console.log(data[0].cname)
	    				//拼接多个<option value=""></option>放到select中去
	    				var content="";
	    				for(var i=0;i<data.length;i++){
	    					content+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>"
	    				}
	    				$("#cid").html(content);
					},
				    //这里注明会掉数据类型为json，所以后端在传数据的时候，需要转化为json类型
				    "json"
				   );
		});
	    </script>
	</HEAD>
	
	<body>
		<!-- 提交表单 -->
		<!-- 涉及多部分表单提交request域失效，不能把方法名放在request域中去调用servlet相应的方法 -->
		<!-- 解决办法：新建一个单独的servlet处理这个表单提交，不继承BaseSeervlet不进行方法名判断 -->
		<form id="userActionSaveProduct" name="Form1" action="${pageContext.request.contextPath}/adminAddProduct" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加商品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="product_name" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="product_price" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="product_image" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="cid" id="cid">
							
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="product_description" rows="5" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>