<%@page import="mall.dao.brandDao"%>
<%@page import="mall.domain.brand"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="../css/brands.css" rel="stylesheet" type="text/css" />
		<script type="text/jscript" src="../js/jquery.min.js"></script>
	</head>
	<body>
			<div style="height: 30px;"></div>
			<div class="title">
				<span>美妆品牌</span>
			</div>
			
		
		<div id="flag-Container">
			<div id="flag">
				
			</div>
		</div>
		
		<div class="brand-Container">
			<div id="brand-Content">
				<% 	brandDao branddao = new brandDao();  
					List<brand> list = branddao.find('Q');
				%>
				<div>					
					<div>0-9</div>
					<div>			
						<% for(int i = 0; i < list.size(); i++){
							brand b = list.get(i);
						%>
							<a href=<%= b.getHref() %> style="text-decoration: none;" class="xxx"><%= b.getBrandName() %></a>
						<% } %>
					</div>
				</div>
				
				<div>
					<div></div>
					<div>
					
					</div>
					
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
				<div>
					<div></div>
					<div></div>
				</div>
			</div>
			
			
		</div>
	</body>
	<script type="text/javascript">
		var a = document.createElement("a");
		a.setAttribute("id", "nn");
		a.href = "#n";
		
		var number = document.createElement("div");
		number.setAttribute("id", "nnn");	
			
		var flag = document.getElementById("flag");
		flag.appendChild(a);
		
		var nn = document.getElementById("nn");
		nn.appendChild(number);
		$("#nnn").html("0-9");
		$("#nnn").addClass("flags");
		
		document.getElementById("brand-Content").children[0].setAttribute("id", "n")
		document.getElementById("n").children[0].setAttribute("class", "letter");
		document.getElementById("n").children[1].setAttribute("class", "ww");
		for(var i = 65; i < 91; i++){
			var count = i - 64;
			// 创建小标志
			var ss = i;
			if(String.fromCharCode(i) != "Q"){
				var a = document.createElement("a");
				a.setAttribute("id", String.fromCharCode(i) + i);
				a.href = "#" + String.fromCharCode(i);
				
				var number = document.createElement("div");
				number.setAttribute("id", i);	
					
				var flag = document.getElementById("flag");
				flag.appendChild(a);
				
				var aa = document.getElementById(String.fromCharCode(i) + i);
				aa.appendChild(number);
				$("#" + i).html(String.fromCharCode(i));
				$("#" + i).addClass("flags");
				
				document.getElementById("brand-Content").children[count].setAttribute("id", String.fromCharCode(i));
				document.getElementById(String.fromCharCode(i)).children[0].innerHTML = String.fromCharCode(i);
				document.getElementById(String.fromCharCode(i)).children[0].setAttribute("class", "letter");
				document.getElementById(String.fromCharCode(i)).children[1].setAttribute("class", "ww");
				// document.getElementById(String.fromCharCode(i))	
			}	
 		}
		
		
		
		var brandContent = document.getElementById("brand-Content");
		var flag = document.getElementById("flag-Container");
		$(document).scroll(function(){   //页面加载时，获取滚动条初始高度
			var distance = $(document).scrollTop();  //获取滚动条初始高度的值 ：0
			console.log(distance); //打印滚动条不同高度的位置的值
			
			if(distance >= 480){
				flag.style.position = "fixed";
				flag.style.top = "0px";
				flag.style.left = "0px";
				flag.style.borderBottom = "solid 1px #c4c4c4";		
			}else{
				$("#flag").fadeIn(200);
				flag.style.position = "static";
				// flag.style.top = "0px";
				flag.style.borderBottom = "none";
				// brandContent.style.marginTop = "200px";
			}
		})
		
		
		//渲染品牌列表
		
		<%
			char flagName;
			int count;
			int num;
			String namew;
			for(int i = 1; i<=4;i++){
				flagName = (char)(96+i);
				flagName = Character.toUpperCase(flagName);
		        System.out.println(flagName);
				if(flagName != 'Q'){
					num = 0;
					brandDao branddao1 = new brandDao();  
					List<brand> list1 = branddao.find(flagName);
					count = list1.size();
					for(int x = 0; x < count; x++){
						num = x;
						brand b1 = list1.get(x);
						namew = b1.getBrandName();
						System.out.println(namew);
		%>				
						var a2 = document.createElement("a");
						a2.href = "<%= b1.getHref() %>";
						a2.setAttribute("id", "<%= num %>"+ "<%= flagName %>");
						var ids = "<%= num %>"+ "<%= flagName %>"; 
						var idw = "<%= flagName %>";
						document.getElementById(idw).children[1].setAttribute("class", "ww");
						$("#" + ids).addClass("xxx");
						document.getElementById("<%= flagName %>").children[1].appendChild(a2);
						
						$("#" + ids).html("<%= b1.getBrandName() %>");
						document.getElementById(ids).style.textDecoration = "none";					
		<%			}
		%>				
		<%				
				}
			}
		%>
		
		
	</script>
</html>

