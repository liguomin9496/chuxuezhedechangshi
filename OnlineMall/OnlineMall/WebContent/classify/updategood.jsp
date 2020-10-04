<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/components.css" rel="stylesheet" type="text/css" />
<title>商品更新</title>
</head>
<body>	
 	<div class="super_headbox">
    		天师大网上商城后台管理系统
    </div>		
	<form action="/OnlineMall/updategoodinfo"  method="post">
			<div style="width: 500px;margin: 20px auto;">
			<h4>请注意商品号是主键不能更改，请填写原商品号！！！</h4>
				<table border="1" width="400">				   
					<tr>
						<th>商品号</th>
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
					    <th>商品数量</th>
					<td>
						<input type="text" name="count" id="count"/>
					</td>
				    </tr>					
					<tr>
						<td><input type="submit" value="更改"/></td>
						<td><input type="button" value="退出" onclick="window.location.href='../classify/super.jsp'"/></td>
					</tr>
				</table>
			</div>
		</form>
		<div style="margin-top:80px;">
		   <jsp:include page="../classify/foot.jsp"></jsp:include>
		</div>	
</body>
</html>