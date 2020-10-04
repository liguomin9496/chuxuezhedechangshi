<%@page import="mall.dao.cartDao"%>
<%@page import="mall.JavaBean.commodity"%>
<%@page import="mall.JavaBean.user"%>
<%@page import="java.util.List"%>
<%@page import="mall.dao.commodityDao"%>
<%@page import="mall.dao.userDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html ;charset= UTF-8">
<title>后台管理系统</title>
<link href="../css/components.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%  
		commodityDao commoditys = new commodityDao();
		List<commodity> list1 =  commoditys.findAll();
		cartDao cart = new cartDao();
		List<commodity> list2 =  cart.findAll(" ");
		userDao users = new userDao();
		List<user> list3 =  users.findAll();
	%>
		<div class="super_headbox">
    		天师大网上商城后台管理系统
    	</div>		
		<ul  style="width: 1000px; margin: 0 0px;">			
			<h4>商品详情</h4> 			
			<li style="float: right;"><a href="Index.jsp">退出系统</a></li>
		</ul> 
		
		<!-- 面板区 --> 
		<div >    
			<div style="margin: 0 50px;">
				<div class="cdetails" style="border: none">
					<form action="/OnlineMall/SearchGood" method="post" >
						<tr>
							<span style="margin-left:100px;">按商品号查询：</span><input type="text" name="gid" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>按名称查询：</span><input type="text" name="gname"/>
							<input type="submit" name="" value="查询"/>&nbsp;&nbsp;
							<a href="../classify/addgood.jsp">添加商品</a>
						</tr>
					</form>
						<table border="1">							
							<tr>
								<th>商品号</th>								
								<th>商品名称</th>
								<th>商品库存数</th>
								<th>价格</th>
								<th></th>
							</tr>
							<c:forEach var="commodity" items="<%= list1 %>" varStatus="status">
									<tr>
									<td>${ commodity.getId() }</td>									
									<td>${ commodity.getName() }</td>
									<td>${ commodity.getCount() }</td>
									<td>￥${ commodity.getPrice() }</td>
									<td >
										<a href="../classify/updategood.jsp?id=${ commodity.getId() }">更改</a>
										<form action="/OnlineMall/removegoodInfo"  method="post">
											<input type="hidden" name="id" value="${ commodity.getId() }" />								
											<input type="submit" value="删除"/>
										</form>										
									</td>
									</tr>
							</c:forEach>
						</table>			
				</div>
			</div>
			<ul style="width: 1000px; margin: 0 0px;">				
				<h4>订单详情</h4>
				<li style="float: right;"><a href="Index.jsp">退出系统</a></li>
			</ul> 		
			<div style="margin: 0 50px;">
				<div class="odetails">
					<table border="1">
					<tr>
						<th>订单号</th>							
						<th>商品名称</th>
						<th>订单价格</th>
						<th>订单数量</th>
						<th>订单时间</th>
						<th>购买用户</th>					
					</tr>
					<c:forEach var="commodity" items="<%= list2 %>">
						<tr>
							<td>${ commodity.getId() }</td>								
							<td>${ commodity.getName() }</td>
							<td>￥${ commodity.getPrice() }</td>
							<td>${ commodity.getCount() }</td>
							<td>${ commodity.getOrderDate() }</td>
							<td>${ commodity.getOrderCustomer() }</td>
							<td >
								<form action="/OnlineMall/removeorderInfo"  method="post">
									<input type="hidden" name="id" value="${ commodity.getId() }" />								
									<input type="submit" value="删除"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				 </table>					
				</div>		
			</div>
			<ul style="width: 1000px; margin: 0 0px;">				
				<h4>用户信息</h4>
				<li style="float: right;"><a href="Index.jsp">退出系统</a></li>
			</ul> 		
			<div style="margin: 0 50px;">
				<div class="odetails">
					<table border="1">
					<tr>
						<th>用户名</th>													
						<th>邮箱</th>
						<th>年龄</th>
						<th>出生日期</th>
						<th>地址</th>											
					</tr>
					<c:forEach var="user" items="<%= list3 %>">
						<tr>
							<td>${ user.getUsername() }</td>														
							<td>${ user.getEmail() }</td>
							<td>${ user.getAge() }</td>
							<td>${ user.getBirthday() }</td>
							<td>${ user.getAddress() }</td>							
						</tr>
					</c:forEach>
				 </table>					
				</div>		
			</div>
		</div>
		<div style="margin-top: 100px;">
		   <jsp:include page="../classify/foot.jsp"></jsp:include>
		</div>	
</body>	
</html>