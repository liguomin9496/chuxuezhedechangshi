<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录账号</title>		
<link rel="stylesheet" type="text/css" href="../css/register and login.css" />
</head>	
<body>			
		<div class="lbottom">									
				<div style="height: 400px;width: 680px; "></div>						
				<li class="li">
					<h2 style="font-size: 19px; margin-left: 25px; margin-top: 25px">已注册顾客</h2>
					<a style="font-size: 15px;float: right; margin-top: -28px;margin-right: 25px;color: #34b3a1;" href="register.jsp">免费注册</a>
					<h2 style="font-size: 15px; float: right; margin-top: -28px;margin-right: 90px;">没有账号？</h2>
					<div style="height: 15px;width: 480px; "></div>						
					<form method="post" id="login_post" action="/OnlineMall/login">							
						<span class="lspan">用户名：</span>
						<input type="text" class="input" placeholder="请输入用户名" id="" name="username" />							
						<span class="lspan">&nbsp;&nbsp;&nbsp;&nbsp;密码：</span>
						<input type="password" class="input" placeholder="请输入密码" id="" name="passward" />							
						<button type="submit" id="login_submit" class="button">登录我的账户</button>
					</form>
				</li>				
			</div>		
		<div style="margin-top: 50px;">
		   <jsp:include page="../classify/foot.jsp"></jsp:include>
		</div>
</body>
</html>