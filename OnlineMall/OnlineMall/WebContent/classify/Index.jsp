<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>			
<link rel="stylesheet" type="text/css" href="../css/Index.css" />		
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
<body>		
	<jsp:include page="../classify/head.jsp"></jsp:include>			
	<form action="/OnlineMall/addorders" method="post">		
	<div class="discount">			
			<h2 style="margin-top: 20px;text-align: center;">大家都在买</h2>
			<div class="allbuy">
				<div class="abox" style="margin-left: 0px;">
					<div class="apicture">						
							<img src="../img/allbuy1.jpg" height="265px" width="255px" />						
					</div>
					<a class="a" style="text-decoration: none;">黑人亮白牙膏</a>					
					<span class="span" style="margin-left: 85px;">￥25</span>				
						<button class="abuttun" id="6">加入购物车</button>					
				</div>
				<div class="abox">
					<div class="apicture">						
							<img src="../img/allbuy2.jpg" height="265px" width="255px" />						
						<div style="margin-top: 60px;">	</div>
						<span class="span" style="margin-left: 85px;">￥348</span>						
							<button class="abuttun" id="3">加入购物车</button>						
					</div>
					<p style="margin-top: 5px;">
						<a class="a">再长 3 英寸保健大梳</a>
					</p>
				</div>
				<div class="abox">
					<div class="apicture">						
							<img src="../img/allbuy3.jpg" height="265px" width="255px" />						
						<div style="margin-top: 58px;">
							<span class="span" style="margin-left: 85px;">￥50</span>
						</div>						
							<button class="abuttun" id="3" style="margin-top: 22px;">加入购物车</button>						
					</div>
					<a class="a" >医用外科口罩</a>
				</div>
				<div class="abox">
					<div class="apicture">						
							<img src="../img/allbuy4.jpg" height="265px" width="255px" />						
						<div style="margin-top: 58px;"></div>
						<span class="span" style="margin-left: 85px;">￥58</span>						
							<button class="abuttun" id="4">加入购物车</button>						
					</div>
					<a class="a">医用免洗消毒液</a>
				</div>
			</div>
			<div class="gift">
			<h2 style="margin-top: 20px;text-align: center;">最新折扣信息</h2>
				<div class="gbox" style="margin-left: 0px;">
					<div class="gpicture">
						<a href="">
							<img src="../img/zhengpin1.jpg" height="207.73px" width="253px" style="margin-left: 0.5px;" />
						</a>
					</div>
					<div class="word">
						<h2 class="wh2">Murad</h2>
						<p class="wp">购满即赠价值￥550套装</p>						
							<button class="wbuttun" id="1" >加入购物车</button>						
					</div>
				</div>
				<div class="gbox">
					<div class="gpicture">						
							<img src="../img/zhengpin2.jpg" height="207.73px" width="253px" style="margin-left: 0.5px;" />						
					</div>
					<div class="word">
						<h2 class="wh2">Revlon</h2>
						<p class="wp">买三免一</p>						
							<button class="wbuttun" id="1">加入购物车</button>						
					</div>
				</div>
				<div class="gbox">
					<div class="gpicture">						
							<img src="../img/zhengpin3.jpg" height="207.73px" width="253px" style="margin-left: 0.5px;" />						
					</div>
					<div class="word">
						<h2 class="wh2">Imedeen</h2>
						<p class="wp">买三免一</p>						
							<button class="wbuttun" id="1">加入购物车</button>						</a>
					</div>
				</div>				
				<div class="gbox">
					<div class="gpicture">						
							<img src="../img/zhengpin4.jpg" height="207.73px" width="253px" style="margin-left: 0.5px;" />						
					</div>
					<div class="word" >
						<h2 class="wh2">ESPA</h2>
						<p class="wp">满既有赠品</p>						
							<button class="wbuttun" id="2">加入购物车</button>						
					</div>
				</div>
			</div>
		</div>
	</form>
	<div style="margin-top: 200px;">
		 <jsp:include page="../classify/foot.jsp"></jsp:include>
	</div>		
</body>
</html>