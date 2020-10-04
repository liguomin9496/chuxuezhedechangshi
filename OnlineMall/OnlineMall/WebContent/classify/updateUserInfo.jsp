<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
</head>
<body>
	<jsp:include page="../classify/head.jsp"></jsp:include>
	<form action="/OnlineMall/Updateuserinfo"  method="post">
		<div style="width: 500px;margin: 20px auto;">
				<table  border="1" width="400">			    
					<tr>
						<th>用户名：</th>
						<td>
							<input type="text" name="name" id="name"/>
						</td>					
					</tr>
					<tr>
						<th>密码：</th>
						<td>
							<input type="text" name="passward" id="passward"/>
						</td>
					</tr>
					<tr>
						<th>邮箱：</th>
						<td>
							<input type="text" name="email" id="email"/>
						</td>
					</tr>
					<tr>
						<th>年龄：</th>
						<td>
							<input type="text" name="age" id="age"/>
						</td>
					</tr>
					<tr>
						<th>出生日期：</th>
						<td>
							<input type="text" name="birthday" id="birthday"/>
						</td>
					</tr>
					<tr>
						<th>地址：</th>
						<td>
							<input type="text"  name="address" id="address"/>
						</td>
					</tr>				
					<tr>
						<td><input type="submit" value="修改"  onclick="window.location.href='../classify/userInfo.jsp'"/></td>
						<td><input type="button" value="退出" onclick="window.location.href='../classify/userInfo.jsp'"/></td>
					</tr>
				</table>
			</div>
	</form>
	<div style="margin-top: 50px;">
		 <jsp:include page="../classify/foot.jsp"></jsp:include>
	</div>
</body>
</html>