<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>头部</title>
<script src="../js/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/head.css" />
</head>
	<script>
		function open_hiddenbox() {
			$("#show_mycount").css("display", "block");
		}

		function close_hiddenbox() {
			$("#show_mycount").css("display", "none");
		}

		function open_QR_code() {
			$("#show_QR_code").css("display", "block");
		}

		function close_QR_code() {
			$("#show_QR_code").css("display", "none");
		}
		/*
		function open_brand_catalog() {
			$("#show_brand_catalog").css("display", "block");
		}

		function close_brand_catalog() {
			$("#show_brand_catalog").css("display", "none");
		}
		
		$(function() {
			$('#brand').click(function() { //点击brandbox标签
				if($('#brandbox').is(':hidden')) { //如果当前隐藏
					$('#brandbox').show(); //那么就显示div
				} else { //否则
					$('#brandbox').hide(); //就隐藏div

				}
			})
		})
		*/
		function open_brand_catalog() {
			document.getElementById('show_brand_catalog').style.display = 'block';
		}

		function close_brand_catalog() {

			document.getElementById('show_brand_catalog').style.display = 'none';
		}
		
		function remove(){
			document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/OnlineMall;";
		}
		
		
	</script>
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
		<div class="head_box">
			<div class="head_topbox">
				<div>
					<div>
						<span>您好</span>
						<span>
							<c:if test="<%= flag %>">
								<a class="link" href="" onclick="remove()"><%= username %></a>															
							</c:if>
							<c:if test="<%= !flag %>">
								<a class="link" href="../classify/login.jsp">请登录</a>						
							</c:if>
						</span>
					</div>
					<div>
						<span style="margin-left: 100px;"><a class="link" href="">英国直邮</a></span>
						<span><a class="link" href="">阳光清关</a></span>
					</div>
					<div>
						<img src="../img/headtop/yingguo.jpg" width="76" height="25" style="margin-top: 0px;" />
						<img src="../img/headtop/zhengping.jpg" width="76" height="25" style="margin-top: 0px;" />
					</div>
					<div>
						<div>
							<img src="../img/headtop/guoqi.jpg" style="margin-top: 0px;" />
						</div>
						<div>
							<a style="color: gray; text-decoration: none;" href="">CN-￥</a>
						</div>
						<div style="margin-right: 10px;">
							<img src="../img/headtop/erweima.jpg" style="margin-top: -2px;" onmouseleave="close_QR_code()" onmousemove="open_QR_code()" />
						</div>
						<div onmouseleave="close_QR_code()" onmousemove="open_QR_code()" style="margin-right: 2px;">
							<a class="link" href="">关注公众号</a>
							<div id="show_QR_code" class="QR_code">
								<div>
									<div>
										<div>
											<img src="../img/headmid/QR_code.jpg" width="85px" height="85px" />
										</div>
										<div>
											<div>
												<img src="../img/headmid/weixin.jpg" width="40px" height="40px" style="margin-top: 8px;" />
											</div>
											<div>
												<li style="list-style: none;color: #34b3a1;font-size: 12px;">
													扫码关注微信公众号
												</li>
												<li style="list-style: none;color: gray;font-size: 13px;margin-top: -25px;">
													获取最新福利信息
												</li>
											</div>
										</div>
									</div>
									<div>
										<div>
											<img src="../img/headmid/QR_code.jpg" width="85px" height="85px" style="margin-top: 5px;" />
										</div>
										<div>
											<div>
												<img src="../img/headmid/weibo.jpg" width="40px" height="40px" style="margin-top: 8px;" />
											</div>
											<div>
												<li style="list-style: none;color: #34b3a1;font-size: 12px;">
													扫码关注微博公众号
												</li>
												<li style="list-style: none;color: gray;font-size: 13px;margin-top: -25px;">
													获取最新活动资讯
												</li>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div onmouseleave="close_hiddenbox()" onmousemove="open_hiddenbox()" style="margin-right: 10px;">
							<a class="link" href="cart.jsp" title="登录您的账户">我的账户</a>
							<div id="show_mycount" class="mycount">
								<li style="list-style: none;margin-top: -5px;">
									<a class="link" href="cart.jsp" title="查看您的历史购物记录" style="margin-left: 40px;">您的订单</a>
								</li>
								<li style="list-style: none; margin-top: -15px;">
									<a class="link" href="" title="查看您的账户设置" style="margin-left: 40px;">您的设置</a>
								</li>
							</div>
						</div>
						<div style="margin-right: 10px;">
							<a class="link" href="" title="帮助和常见问题">帮助</a>
						</div>
					</div>
				</div>
			</div>
		
			<div class="head_midbox">
				<div class="head_midbox_logo-search">
					<div class="head_midbox_logo">
						<img src="../img/headmid/logo.jpg" width="280px" height="50px" style="margin-top: 25px;">
					</div>
					<div class="head_midbox_search">						
						<div>
							<div style="cursor: pointer;" id="open_brand" onclick="open_brand_catalog();">
								<span style="margin-left: 1em;">品牌目录</span>
								<div id="show_brand_catalog" class="brand_catalog">
									<div>
										<img src="../img/headmid/fangdajing.jpg" width="40px" height="40px" style="margin-left: 14px;margin-top: -2.5px;"/>								
										<input type="text" name="brandsearch" style="height: 40px;width: 240px; margin-top: 10px;margin-left: -6px;border: none; outline:none;" />
									</div>
									<div>
										<div class="independentbox">
											<li class="brandli" style="margin-top: 5px;">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>		
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>	
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											<li class="brandli" style="">
												<a style="color: #34b3a1;" href="">123456</a>
											</li>
											
								
										</div>
									</div>
								</div>
							</div>
							<div id="close_brand" onclick="close_brand_catalog();">
								<img src="../img/headmid/jiantou.jpg" width="17px" height="12px" style="margin-left: 13px;margin-top: 15px;cursor: pointer;" />
							</div>
						</div>
						<div>
							<div>
								<input type="text" name="search" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;搜索" class="head_midbox_search_sousuo" style="outline:none" />
							</div>
							<div>
								<img src="../img/headmid/sousuo.jpg" width="23px" height="23px" style="margin-left: 11px;margin-top: 9px;" />
							</div>
						</div>
						<div>
							<a class="link" href="../classify/cart.jsp">购物车</a>
						</div>

					</div>
				</div>
			</div>
	</body>
</html>