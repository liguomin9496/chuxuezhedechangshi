<%@page import="mall.dao.userDao"%>
<%@page import="mall.JavaBean.user"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>		
<link href="../css/cart.css" rel="stylesheet" type="text/css" />		
</head>
<body>		
		<%  
			String username="";				
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++){
				if("username".equals(cookies[i].getName())){
					username = cookies[i].getValue();
				}
			}			
			userDao user = new userDao();
			List<user> list = user.find(username);
		%>		
		<jsp:include page="../classify/head.jsp"></jsp:include>		
		<div class="cart-Container">
			<div class="title">
				<span>您的个人信息</span>				
			</div>
			<div class="table">
				<div style="width: 170px;">用户名</div>
				<div style="width: 170px;">密码</div>
				<div style="width: 170px;">邮箱</div>
				<div style="width: 170px;">年龄</div>
				<div style="width: 170px;">出生日期</div>
				<div style="width: 170px;">地址</div>
			</div>
			<c:forEach var="user" items="<%=list %>">				
				<div class="cart-List">
					<div style="width: 170px;">${ user.getUsername() }</div>
					<div style="width: 170px;">${ user.getPassward() }</div>
					<div style="width: 170px;">${ user.getEmail()}</div>
					<div style="width: 170px;">${ user.getAge() }</div>
					<div style="width: 170px;">${ user.getBirthday()  }</div>
					<div style="width: 170px;">${ user.getAddress() }</div>					
				</div>
			</c:forEach>
			<div class="butn" style="margin-top: -40px;">
				<div><a href="updateUserInfo.jsp" style="color: white;">更改信息</a></div>				
			</div>				
		</div>		
		<div style="margin-top: 100px;">
			<jsp:include page="../classify/foot.jsp"></jsp:include>
		</div>        
</body>
</html>