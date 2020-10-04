<%@page import="mall.dao.cartDao"%>
<%@page import="mall.domain.commodity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/cart.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"/>
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
<script type="text/javascript">
	function subNumber(i){
		console.log(i);
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/OnlineMall/subgoods?id="+i,
			dataType:"json",
			success:function(msg)
			{		
			},
			error:function (result) {
				location.reload(true);
            }   
		});
		
	}
	function addNumber(i){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/OnlineMall/addgoods?id="+i,
			dataType:"json",
			success:function(msg)
			{					
			},
			error:function (result) {
				location.reload(true);
            } 
		});
	}
	function removeGoods(i){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/OnlineMall/removegoods?id="+i,
			dataType:"json",
			success:function(msg)
			{					
			},
			error:function (result) {
				location.reload(true);
            } 
		});
	}
</script>
<body>
<jsp:include page="../Home_page_components/head.jsp" flush="true" ></jsp:include>
<jsp:include page="../Home_page_components/navigation-Bar.jsp" flush="true" ></jsp:include>

<div class="cart-Container">
			<div class="title">
				<span>您的购物车</span>
				<div><span class="glyphicon glyphicon-lock lock" aria-hidden="true"></span>&nbsp;安全支付</div>
			</div>
			<div class="table">
				<div style="width: 535px;">商品</div>
				<div style="width: 178px;">价格</div>
				<div style="width: 178px;">数量</div>
				<div style="width: 178px;">小计</div>
			</div>

			<c:forEach var="commodity" items="<%= list %>" varStatus="status">
				
				<div class="cart-List">
					<div style="width: 535px;"><img src="${ commodity.getSrc() }"/><span>${ commodity.getName() }</span></div>
					<div style="width: 178px;">￥${commodity.getPrice() }</div>
					<div style="width: 178px;">
						<div class="count">
							<div onclick="subNumber( '${ commodity.getId() }')">-</div>
							<div>${commodity.count}</div>
							<div onclick="addNumber('${ commodity.getId() }')">+</div>
						</div>
					</div>
					<div style="width: 178px;">￥${commodity.getCount() * commodity.getPrice()}</div>
					<div onclick="removeGoods('${ commodity.getId() }')"><span>x</span></div>
				</div>
			</c:forEach>
			<%
				for(int j = 0; j < list.size(); j++){
					totalPrice  += list.get(j).getPrice() * list.get(j).getCount();
				}
			%>
			<div class="total">
				<div style="width: 800px;height: 37.8px;"></div>
				<div>购物车合计：</div>
				<div class="content">￥<%= totalPrice %></div>
			</div>
			
			<div class="butn">
				<div><a href="theBrand.jsp" style="color: white;">继续购物</a></div>
				<div><span class="glyphicon glyphicon-lock lock" aria-hidden="true"></span>&nbsp;安全支付</div>
			</div>
		</div>
<jsp:include page="../Home_page_components/foot.jsp" flush="true" ></jsp:include>
</body>
</html>