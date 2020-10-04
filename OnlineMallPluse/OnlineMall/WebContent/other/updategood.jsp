<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"/>

</head>
<body>
<script type="text/javascript">	
	var id = window.location.href.split("?")[1].split("=")[1];
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/OnlineMall/FillInput?id="+id,
		dataType:"json",
		success:function(msg)
		{
			if(msg!=null&&msg.length>0)
			{
				for(var i=0; i<msg.length ;i++){
					$("#id").val(msg[i].id);
					$("#name").val(msg[i].name);
					$("#price").val("￥"+msg[i].price);
					$("#src").val(msg[i].src);
					$("#href").val(msg[i].href);
				}					
			}	
		}
	});
	
	
</script>
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
 	<jsp:include page="../Home_page_components/super_top.jsp" flush="true" ></jsp:include>
	<form action="/OnlineMall/updategoodinfo"  method="post">
			<div style="width: 500px;margin: 20px auto;">
				<table class="table table-hover" border="1" width="400">
					<tr>
						<th>商品ID</th>
						<td>
							<input type="text" name="id" id="id"/>
						</td>
						
					</tr>
					<tr>
						<th>商品名称</th>
						<td>
							<input type="text" name="name" id="name"/>
						</td>
					</tr>
					<tr>
						<th>商品价格</th>
						<td>
							<input type="text" name="price" id="price"/>
						</td>
					</tr>
					<tr>
						<th>商品图片路径</th>
						<td>
							<input type="text" name="src" id="src"/>
						</td>
					</tr>
					<tr>
						<th>商品链接</th>
						<td>
							<input type="text" name="href" id="href"/>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="更改"/></td>
						<td><input type="button" value="退出" onclick="window.location.href='../classify/super.jsp'"/></td>
					</tr>
				</table>
			</div>
		</form>
		<div style="height: 50px;width: 100%;background: #ebebeb;text-align: center;line-height: 50px;font-size: 14px;">
    		厦门工学院计算机与科学工程系2017级软件工程专业4班------第2组
    	</div>
</body>
</html>