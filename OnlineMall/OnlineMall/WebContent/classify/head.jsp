<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="../css/components.css" />
</head>
	
<body>
		<% 
			boolean flag = false;
			String username = "";
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++){
				if("username".equals(cookies[i].getName())){
					username = cookies[i].getValue();
					flag = true;
				}
			}	
		%>
		  <div class="hbox">
			<div class="htbox">
				<div>
					<div>
						<span>您好</span>
						<span>						
							<a class="link" href="login.jsp" onclick="remove()"><%= username %></a>	
						</span>
					</div>
					<div style=" margin-left:400px;"><h1>天师大网上商城</h1></div>							
					<div style=" margin-left:950px;">											
						<div style="margin-right: 10px;margin-top:-30px;">
							<a class="link" href="userInfo.jsp" title="查看您的账号设置" style="margin-left: 40px;">账号设置</a>							
						</div>						
					</div>
				</div>
			</div>
		
			<div class="hmbox">
				<div class="search">
					<div class="hmbox_logo">
						<img src="../img/logo.jpg" width="280px" height="50px" style="margin-top: 25px;">
					</div>					
					<div class="search1" style="margin-left: 200px;">				
						<div style="margin-left:800px ;margin-top:-120px;">
							<a class="link" href="../classify/cart.jsp">购物车</a>
						</div>
					</div>
				</div>
			</div>			
	</body>
</html>