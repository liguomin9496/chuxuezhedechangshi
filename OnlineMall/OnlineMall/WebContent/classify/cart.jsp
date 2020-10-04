<%@page import="mall.dao.cartDao"%>
<%@page import="mall.JavaBean.commodity"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link href="../css/cart.css" rel="stylesheet" type="text/css" />
</head>
<%  
	String username="";
	double totalPrice = 0;			
	Cookie[] cookies = request.getCookies();
	for(int i = 0; i < cookies.length; i++){
		if("username".equals(cookies[i].getName())){
			username = cookies[i].getValue();
		}
	}
	cartDao cart = new cartDao();
	List<commodity> list = cart.findAll(username);
%>
<body>
<jsp:include page="../classify/head.jsp" flush="true" ></jsp:include>

<div class="cart-Container">
			<div class="title">
				<span>您的购物车</span>				
			</div>
			<div class="table">
				<div style="width: 178px;">商品</div>
				<div style="width: 178px;">价格</div>
				<div style="width: 178px;">数量</div>
				<div style="width: 178px;">小计</div>
			</div>
			<c:forEach var="commodity" items="<%= list %>">				
				<div class="cart-List">
					<div style="width: 178px;">${ commodity.getName() }</div>
					<div style="width: 178px;">￥${commodity.getPrice() }</div>
					<div style="width: 178px;">${commodity.getCount()}</div>
					<div style="width: 178px;">￥${commodity.getCount() * commodity.getPrice()}</div>
					<div style="width: 178px;">
						<form action="/OnlineMall/removegoods"  method="post">
								<input type="hidden" name="id" value="${ commodity.getId() }" />								
								<input type="submit" value="删除"/>
						</form>
				</div>
				</div>
			</c:forEach>
			<%
				for(int j = 0; j < list.size(); j++){
					totalPrice  += list.get(j).getPrice() * list.get(j).getCount();
				}
			%>
			<div class="total">
				<div style="width: 800px;height: 20px;"></div>
				<div>购物车合计：</div>
				<div class="content" style="margin-left:870px;margin-top:-40px">￥<%= totalPrice %></div>
			</div>			
			<div class="butn">
				<div><a href="Index.jsp" style="color: white;">继续购物</a></div>				
			</div>			
		</div>
<jsp:include page="../classify/foot.jsp"></jsp:include>
</body>
</html>