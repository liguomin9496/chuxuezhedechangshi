<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录账号</title>
		<script src="../js/jquery.min.js" type="text/javascript"></script>
		<link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
	</head>
	<script type="text/javascript">
		
	</script>

	<body>
		<div class="login_box">			
			<div class="login_box_head">
				<div>
					<a href="">
						<img src="../img/login/logo.jpg" width="280px" height="50px" style="margin-top: 25px;" />
					</a>
					<li style="list-style: none;float: right;">
						<select class="login_box_head_select" id="language" name="language">
							<option>中文</option>
							<option>English</option>
						</select>
					</li>
				</div>
			</div>
			
			<div class="login_box_bottom">
				<div>
					<a href="promotions.jsp">
						<img src="../img/login/bigpicture.jpg" height="400px" width="680px" />
					</a>
					<li class="login_box_bottom_li">
						<h2 style="font-size: 19px; margin-left: 25px; margin-top: 25px">已注册顾客</h2>
						<a style="font-size: 15px;float: right; margin-top: -28px;margin-right: 25px;color: #34b3a1;" href="registered.jsp">免费注册</a>
						<h2 style="font-size: 15px; float: right; margin-top: -25px;margin-right: 90px;">没有账号？</h2>
						<div style="height: 15px;width: 480px; "></div>
						
						<form method="post" id="login_post" action="/OnlineMall/login">
							
							<img src="../img/login/zhucerentou.jpg" height="61px" width="60px" style="margin-left:25px; margin-top: -3px;" />
							<input type="text" class="login_box_bottom_input" placeholder="请输入用户名" id="" name="username" />
							
							<img src="../img/login/mimasuo.jpg" height="61px" width="60px" style="margin-left:25px; margin-top: -3px;" />
							<input type="password" class="login_box_bottom_input" placeholder="请输入密码" id="" name="passward" style="margin-top: 25px;" />

							<a style="font-size: 15px;float: left; margin-top: 35px;margin-left: 25px;color: #34b3a1;" href="">忘记密码？</a>
							<button type="submit" id="login_submit" class="login_box_bottom_button">登录我的账户</button>
						</form>
					</li>
				</div>
			</div>
		</div>
	</body>

</html>