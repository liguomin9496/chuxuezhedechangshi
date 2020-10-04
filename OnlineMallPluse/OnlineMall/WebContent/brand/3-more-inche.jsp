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
		<link href="../css/3-more-inche.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"/>
		<style type="text/css">
			#notlogin{
				width: 700px;
				height: 285px;
				background: white;
				position: fixed;
				top: 150px;
				left: 400px;
				z-index: 2000;
				display: none;
				text-align: center;	
			}
			#notlogin>div:first-child{
				text-align: right;
				font-size: 25px;
				color: #ebebeb;
				font-weight: 1;
				cursor: pointer;
			}
		</style>
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
	%>
	<script type="text/javascript">
		var name = "";
		var price = "";
		var src = "";
		var href = "";
		var cookiename = '<%=username %>';
		function show(i){
			console.log(i);			
			if(cookiename != ''){
				$.ajax({
					type:"GET",
					url:"http://localhost:8080/OnlineMall/goodsa?id="+i,
					dataType:"json",
					success:function(msg)
					{				
						if(msg!=null&&msg.length>0)
						{
							for(var i=0; i<msg.length ;i++){
								name = msg[i].name;
								price = msg[i].price;
								src = msg[i].src;
								href = msg[i].href;	
								$("#name").html(name);
								$("#price").html("￥"+price);
								$("#img").attr({ src: src});
							}					
						}					
					}	   
				});
				$("#shop").fadeIn("speed");
				document.getElementById("shop").style.boxShadow="10px 10px  10000px rgba(0,0,0,.5)";
			}else{
				console.log(cookiename + "sss");
				$("#notlogin").fadeIn("speed");
				document.getElementById("notlogin").style.boxShadow="10px 10px  10000px rgba(0,0,0,.5)";
			}
			
		}
		function hiddens(){
			// document.getElementById("shop").style.display="none";
			if(cookiename != ''){
				$("#shop").fadeOut("speed");
			}else{
				$("#notlogin").fadeOut("speed");
			}
			
		}
		function skip(){
			window.location.href="../classify/cart.jsp";
		}
		
		
		function addgoods(i){
			var name = '<%= username%>';
			if(name != ''){
				i = name + i;
				$.ajax({
					type:"GET",
					url:"http://localhost:8080/OnlineMall/addgoods?id="+i,
					dataType:"json",
					success:function(msg)
					{				
									
					}	   
				});
			}else{
				
			}
			
		}
	</script>
	<body>
		<% 
			commodityDao cd = new commodityDao();
			List<commodity> list = cd.findAll();
		%>
		<div id="shop">
			<div onclick="hiddens()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			</div>
			<h2>1商品 已加入购物车</h2>
			<div class="information">
				<div style="float: left;">
					<img src="" id="img" />
				</div>
				
				<div style="float: left;width: 450px;margin-top: 20px;">
					<h4 id="name"></h4>
					<h3 style="font-weight: bold;margin-top: 20px;"id="price"></h3>
				</div>
			</div>
			<div class="count">
				
			</div>
			<div class="but">
				<div onclick="hiddens()">继续购物</div>
				<div onclick="skip()">查看购物车</div>
			</div>
		</div>
		
		<div id="notlogin" >
			<div onclick="hiddens()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			</div>
			<h2 style="line-height: 200px;">您未登录，请<a href="../classify/login.jsp">登录</a>后添加购物车！</h2>
		</div>
		
		
		<jsp:include page="../Home_page_components/head.jsp" flush="true" ></jsp:include>
		<jsp:include page="../Home_page_components/navigation-Bar.jsp" flush="true" ></jsp:include>
		<div class="brand-Container" id="brand-Container" style="margin-bottom: 100px;min-height: 1300px;">
			<div>
				<a href="../classify/promotions.jsp">首页</a>/3''' More Inches
			</div>
			<div class="commodity-Content">
				<div class="left">
					<h3 class="facets_filtersPanelTitle">
							筛选选项
					</h3>
					<h3 class="facets_filtersPanelTitle">
							护发产品
					</h3>
					<h3 class="facets_filtersPanelTitle">
							价格
					</h3>
				</div>
				<div class="right">
					<div>
						<span class="title">3''' More Inches</span>
						<span class="count"><%= list.size() %>结果</span>
					</div>
					<div>
						分类：
						<select style="width: 200px;height: 40px;">
							<option>默认</option>
							<option>受欢迎程度</option>
							<option>价格：从低到高</option>
							<option>价格：从高到低</option>
							<option>产品名</option>
							<option>新品上架</option>
							<option>折扣力度</option>
						</select>
					</div>
					<div class="commodity-List">
						<c:forEach var="commodity" items="<%= list %>" varStatus="status">
							<div>
								<img src="${ commodity.src }" />
								<div style="font-size: 16px;text-align: left;height: 41px;margin-top: 10px;">${commodity.name}</div>
								<div style="text-align: left;">
									<span style="line-height: 45px;font-size: 1.5em;">¥${commodity.price}</span>
									<div class="cart" onclick="show(${status.count }), addgoods('${ commodity.getId()}')">
										<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true" style="line-height: 45px; color: #28bdb7;font-size: 18px;"></span>
									</div>			
															
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../Home_page_components/foot.jsp" flush="true" ></jsp:include>
	</body>
	
</html>
