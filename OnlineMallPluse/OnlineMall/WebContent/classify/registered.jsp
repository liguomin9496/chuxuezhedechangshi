<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册账号</title>
		<script src="../js/jquery.min.js" type="text/javascript"></script>
		<link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="../css/registered.css" />
		<link rel="stylesheet" href="../css/login.css" type="text/css" />
	</head>
	<%
		HttpSession sess = request.getSession();
		String message = (String)sess.getAttribute("mes");
		if(message == ""){
			%>
			<%
		}else{
			%>
				 <script type="text/javascript">
				 	var mes = "<%= message%>";
				 	if(mes != "" || mes != null){
			 			alert("<%=message %>");
			 		}
				 </script>
			<%
			sess.setAttribute("mes", "");
		}
 	%>
	<body>
		<div class="registered_box">
			<div class="registered_box_head">
				<div>
					<a href="promotions.jsp">
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
			<div class="registered_box_body">
				<a href="promotions.jsp">
					<img src="../img/registered/registered.jpg" />
				</a>

				<div class="registered_box_body_reglist">
					<h2 style="font-size: 31px; margin-left: 25px; margin-top: 25px;color: black;">免费注册</h2>
					<a style="font-size: 14px;float: right; margin-top: -45px;margin-right: 30px;color: #34b3a1;" href="">免费注册</a>
					<h2 style="font-size: 14px; float: right; margin-top: -42px;margin-right: 90px;">没有账号？</h2>
					<div style="height: 15px;width: 500px; "></div>
					<form method="post" id="registered_post" action="/OnlineMall/register">
						<li class="registered_box_body_reglist_li" style="margin-top: 0px;">
							<span class="registered_box_body_reglist_span">您的姓名</span>
							<input class="registered_box_body_reglist_input" type="text" name="username" id="" />
						</li>
						<li class="registered_box_body_reglist_li">
							<span class="registered_box_body_reglist_span">邮箱地址</span>
							<input class="registered_box_body_reglist_input" type="email" name="" id="" />
						</li>
						<li class="registered_box_body_reglist_li">
							<span class="registered_box_body_reglist_span">确认邮箱地址</span>
							<input class="registered_box_body_reglist_input" style="margin-left: 25px;" type="email" name="" id="" />
						</li>
						<li class="registered_box_body_reglist_li">
							<span class="registered_box_body_reglist_span">密码</span>
							<input class="registered_box_body_reglist_input" style="margin-left: 80px;" type="password" name="passward" id="" />
						</li>
						<li class="registered_box_body_reglist_li">
							<span class="registered_box_body_reglist_span">确认密码</span>
							<input class="registered_box_body_reglist_input" type="password" name="repassward" id="" />
						</li>
						<li class="registered_box_body_reglist_li">
							<span style="margin-left: 6.5em; color: #4e504f;font-weight: 100;">注册账号，既表示同意我们的&nbsp;<a href="" style="color: #34b3a1;">服务条款</a>&nbsp;和&nbsp;<a href="" style="color: #34b3a1;" >隐私条款</a></span>
						</li>
						<button class="registered_box_body_reglist_button" type="submit" id="registered_submit">免费注册</button>
					</form>

				</div>
			</div>
		</div>
	</body>

</html>