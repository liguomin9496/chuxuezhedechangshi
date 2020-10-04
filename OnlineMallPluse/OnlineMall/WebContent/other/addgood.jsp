<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"/>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
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
	<form action="/OnlineMall/addgoodInfo" method="post">
		<div style="width: 500px;margin: 20px auto;">
			<table class="table table-hover" border="1" width="400">
				<tr>
					<th>商品ID</th>
					<td>
						<input type="text" name="id"/>
					</td>
					
				</tr>
				<tr>
					<th>商品名称</th>
					<td>
						<input type="text" name="name"/>
					</td>
				</tr>
				<tr>
					<th>商品价格</th>
					<td>
						<input type="text" name="price"/>
					</td>
				</tr>
				<tr>
					<th>商品图片路径</th>
					<td>
						<input type="text" name="src"/>
					</td>
				</tr>
				<tr>
					<th>商品链接</th>
					<td>
						<input type="text" name="href" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="添加"/></td>
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