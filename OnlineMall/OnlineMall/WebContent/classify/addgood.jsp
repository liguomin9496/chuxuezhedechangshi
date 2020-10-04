<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="../css/components.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加商品</title>
</head>
<body>	
 	<div class="super_headbox">
    		Lookfantastic网上商城后台管理系统
    </div>		
	<form action="/OnlineMall/addgoodInfo" method="post">
		<div style="width: 500px;margin: 20px auto;">
			<table  border="1" width="400">
			    <h4>商品号是主键，不能重复，每个信息都必须输入！</h4>
				<tr>
					<th>商品号</th>
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
					<th>上架商品数量</th>
					<td>
						<input type="text" name="count"/>
					</td>
				</tr>			
				<tr>
					<td><input type="submit" value="添加"/></td>
					<td><input type="button" value="退出" onclick="window.location.href='../classify/super.jsp'"/></td>
				</tr>
			</table>
		</div>
	</form>
	<div style="margin-top: 50px;">
		 <jsp:include page="../classify/foot.jsp"></jsp:include>
	</div>
</body>
</html>