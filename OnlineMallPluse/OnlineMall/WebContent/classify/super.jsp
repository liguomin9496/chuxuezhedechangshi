<%@page import="mall.dao.cartDao"%>
<%@page import="mall.domain.commodity"%>
<%@page import="java.util.List"%>
<%@page import="mall.dao.commodityDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="../css/super.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"/>
		<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%  
			commodityDao commoditys = new commodityDao();
			List<commodity> list1 =  commoditys.findAll();
			cartDao cart = new cartDao();
			List<commodity> list2 =  cart.findAll("all");
		%>
		<jsp:include page="../Home_page_components/super_top.jsp" flush="true" ></jsp:include>
		<!-- 导航区 -->
		<ul class="nav nav-tabs" role="tablist" style="width: 1000px; margin: 0 250px;">  
			<li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">商品详情</a></li>    
			<li role="presentation"><a href="#profile" role="tab" data-toggle="tab">订单详情</a></li>
			<li style="float: right;"><a href="promotions.jsp" onclick="removecookie()">退出系统</a></li>
		</ul> 
		
		<!-- 面板区 --> 
		<div class="tab-content" >    
			<div role="tabpanel" class="tab-pane active" id="home" style="margin: 0 250px;">
				<div class="commodity-details" style="border: none">
					<form action="/OnlineMall/SearchGood" method="post">
						<table class="table table-hover" border="1">
							<tr>
								<span>按商品号查询：</span><input type="text" name="gid" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>按名称查询：</span><input type="text" name="gname"/>
								<input type="submit" name="" value="查询"/>&nbsp;&nbsp;
								<a href="../other/addgood.jsp">添加</a>
							</tr>
							<tr>
								<th>商品号</th>
								<th>商品图片</th>
								<th>商品名称</th>
								<th>价格</th>
								<th></th>
							</tr>
							<c:forEach var="commodity" items="<%= list1 %>">
								<tr>
									<td>${ commodity.getId() }</td>
									<td><img src="${ commodity.getSrc() }" style="width: 40px;"/></td>
									<td>${ commodity.getName() }</td>
									<td>￥${ commodity.getPrice() }</td>
									<td style="cursor: pointer;"><a href="../other/updategood.jsp?id=${ commodity.getId() }">更改</a> &nbsp<a onclick="removegood('${ commodity.getId() }')">删除</a></td>
								</tr>	
							</c:forEach>
						</table>
					</form>
				</div>
			</div>  
			<div role="tabpanel" class="tab-pane" id="profile" style="margin: 0 250px;">
				<div class="order-details">
					<table class="table table-hover" border="1">
						<tr>
							<th>订单号</th>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>价格</th>
							<th>数量</th>
							<th>订单时间</th>
							<th></th>
						</tr>
						<c:forEach var="commodity" items="<%= list2 %>">
							<tr>
								<td>${ commodity.getId() }</td>
								<td><img src="${ commodity.getSrc() }" style="width: 40px;"/></td>
								<td>${ commodity.getName() }</td>
								<td>￥${ commodity.getPrice() }</td>
								<td>${ commodity.getCount() }</td>
								<td>${ commodity.getOrderDate() }</td>
								<td style="cursor: pointer;"><a onclick="removeorder('${ commodity.getId() }')">删除</a></td>
							</tr>
						</c:forEach>
					</table>
					
					
				</div>
				
			</div>   
		</div>  
		<div style="height: 50px;width: 100%;background: #ebebeb;text-align: center;line-height: 50px;font-size: 14px;">
    		厦门工学院计算机与科学工程系2017级软件工程专业4班------第2组
    	</div>
	</body>
	<script type="text/javascript">
	    $(function () {
			$('#myTab a:last').tab('show');//初始化显示哪个tab		  
			$('#myTab a').click(function (e) {
			  e.preventDefault();//阻止a链接的跳转行为
			  $(this).tab('show');//显示当前选中的链接及关联的content
			})
      })
      
      function removegood(i){
		var flag = confirm("是否确认删除？");

		if(flag){
			window.location.href="http://localhost:8080/OnlineMall/removegoodInfo?id="+i;
		}
	  }
	   
	  function removeorder(i){
		var flag = confirm("是否确认删除？");
		if(flag){
			window.location.href="http://localhost:8080/OnlineMall/removeorderInfo?id="+i;
		}
	  }
	  function removecookie(){
			document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/OnlineMall;";
			console.log("sss");
		}
	</script>
</html>