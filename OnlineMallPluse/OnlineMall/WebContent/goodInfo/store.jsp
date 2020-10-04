<%@page import="mall.domain.commodity"%>
<%@page import="java.util.List"%>
<%@page import="mall.dao.commodityDao"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<script src="../js/jquery-2.1.4.min.js" type="text/javascript"></script>
		<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="../js/bootstrap.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="../css/registered.css" />
		<link rel="stylesheet" href="../css/store.css" type="text/css" />
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
			console.log(cookiename);
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
		<div class="store_nav">
			<a class="store_nav_a" href="promotions.jsp">首页</a>
			&nbsp;&nbsp;/&nbsp;&nbsp;
			<span class="store_nav_span">NYX 16色眼影 | WARM NEUTRALS</span>
		</div>

		<section class="store_section">
			<div class="store_section_left">
				<div class="store_section_left_title">
					<h1>NYX 16色眼影 | WARM NEUTRALS</h1>
				</div>
				<div class="store_section_left_pic">
					<div class="store_section_left_bigpic">
						<img src="../img/store/store_yanying.png" height="600px" width="600px" style="margin-left: 69px; margin-top: 47px;"/>
					</div>
					<div class="store_section_left_minpic">
						<img src="../img/store/store1.jpg" height="124px" width="114px" />
						<img src="../img/store/store2.jpg" height="124px" width="114px" style="margin-left: 10px;"/>
						<img src="../img/store/store3.jpg" height="124px" width="114px" style="margin-left: 10px;"/>
					</div>
				</div>
				<div class="store_section_left_information">
					<h4 style="margin-top: 80px;">描述</h4>
					<div>
						<p style="margin-top: 15px;">
							<strong>NYX 16</strong>
							<strong>色眼影</strong>
							，重新定义你的眼睛。这款16 色眼影盘是Warm Neutrals 色调：包括缎面、闪光和金属色。
						</p>
						<p style="margin-top: 15px;">
							<strong>NYX</strong>
							<strong>眼影盘16</strong>
							<strong>色教程：</strong>
						</p>
						<ul style="margin-top: 15px;margin-left: -20px;">
							<li>眼影粉末可以轻柔地融化在盖子上，即时使用，能提供高色素、耐久的眼影颜色而且带色带妆效果持久。</li>
							<li>可混合各种颜色使用，创造出独特的沙龙效果。</li>
							<li>可以沾湿使用，打造更强烈的色彩效果。</li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="store_section_right">
				<%-- <div class="store_section_right_price">
					<p>
						<span class="store_section_right_span">￥140.80</span>
						<p style="margin-top: -15px;font-size: 13px;margin-left: 5px;">购物满475元享受免费国际配送!</p>
						<div style="height: 30px;"></div>
						<div>
							数量：<input type="text" class="store_section_right_input" value="1"/>
							<span>
								<strong>有货</strong>通常24小时内发货
							</span>
							<button class="store_section_right_button" type="button" id="store_submit" onclick="show(${ 7 }), addgoods('${ 7}')">加入购物车</button>
						</div>
					</p>
				</div>
				<div>
					<p>如果我对产品不是完全满意？</p>
					<p>
						请查看我们的
						<a href="" style="color: #34b3a1;">退换货政策</a>
					</p>
				</div> --%>
			</div>
			
			
		</section>
		<jsp:include page="../Home_page_components/foot.jsp" flush="true" ></jsp:include>
	</body>

</html>