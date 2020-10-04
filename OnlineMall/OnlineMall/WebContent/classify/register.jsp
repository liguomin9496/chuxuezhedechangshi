<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册账号</title>	
<link rel="stylesheet" href="../css/register and login.css" type="text/css" />
</head>
<body>				
		<div class="body">
			<div style="height: 600px;width: 600px; "></div>				
			<div class="reglist" >	
		        <h2 style="font-size: 31px; margin-left: 25px; margin-top: 25px;color: black;">免费注册</h2>					
			    <div style="height: 15px;width: 500px; "></div>
				<form method="post" id="registered_post" action="/OnlineMall/register">
					 <ul>
						<li class="rli" >
							<span class="rspan">您的姓名</span>
							<input class="rinput" type="text" name="username" id="" />
						</li>
						<li class="rli">
							<span class="rspan">邮箱地址</span>
							<input class="rinput" type="email" name="" id="" />
						</li>						
						<li class="rli">
							<span class="rspan">您的密码</span>
							<input class="rinput" type="password" name="passward" id="" />
						</li>
						<li class="rli">
							<span class="rspan">确认密码</span>
							<input class="rinput" type="password" name="repassward" id="" />
						</li>
						<li class="rli">
							<span style="margin-left: 2em; margin-top: 5px; color: #4e504f;font-weight: 100;">注册账号，既表示同意我们的&nbsp;<a href="" style="color: #34b3a1;">服务条款</a>&nbsp;和&nbsp;<a href="" style="color: #34b3a1;" >隐私条款</a></span>
						</li>
						</ul>
						<button class="rbutton" type="submit" id="registered_submit">免费注册</button>						
					</form>				
			</div>
		</div>	
	<div style="margin-top: 50px;">
		  <jsp:include page="../classify/foot.jsp"></jsp:include>
	</div>
</body>
</html>