<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="../css/navigation-Bar.css" rel="stylesheet" type="text/css"/>
		<script src="../js/jquery.min.js" type="text/javascript"></script>
	</head>
	<body>
		
		<div class="navigation-Bar-Container">
			<div class="navigation-Head">
				<div class="navigation-Title">
					<a href="../classify/promotions.jsp"><div><span onmouseover="mouseovers(1)" onmouseout="mouseouts(1)">优惠活动</span></div></a>
					<a href="../classify/theBrand.jsp"><div><span onmouseover="mouseovers(2)" onmouseout="mouseouts(2)">品牌一览</span></div></a>
					<a><div><span onmouseover="mouseovers(3)" onmouseout="mouseouts(3)">新品上市</span></div></a>
					<a><div><span onmouseover="mouseovers(4)" onmouseout="mouseouts(4)">美容护肤</span></div></a>
					<a><div><span onmouseover="mouseovers(5)" onmouseout="mouseouts(5)">美发护发</span></div></a>
					<a><div><span onmouseover="mouseovers(6)" onmouseout="mouseouts(6)">美容彩妆</span></div></a>
					<a><div><span onmouseover="mouseovers(7)" onmouseout="mouseouts(7)">美容仪</span></div></a>
					<a><div><span onmouseover="mouseovers(8)" onmouseout="mouseouts(8)">身体护理</span></div></a>
					<a><div><span onmouseover="mouseovers(9)" onmouseout="mouseouts(9)">男士</span></div></a>			
					<a><div><span onmouseover="mouseovers(10)" onmouseout="mouseouts(10)">美妆礼盒</span></div></a>
					<a><div><span onmouseover="mouseovers(11)" onmouseout="mouseouts(11)">博客</span></div></a>
				</div>
			</div>
			
		
			<div class="youhui">
				<span>尽享 8 折优惠 ！折扣码：LFCN20 （*部分产品不参加)</span>
			</div>
	</body>
	<script type="text/javascript">
		function mouseovers(i){
			console.log("ss");
			$("#content" + i).fadeIn(200);
		}
		function mouseouts(i){
			console.log("aa");
			$("#content" + i).fadeOut(200);		
		}
		
	</script>
</html>
