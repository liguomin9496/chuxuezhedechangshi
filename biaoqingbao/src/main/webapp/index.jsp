<%@ page import = "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        #img{
            display:block;
            height:500px;
            width:500px;
            border:2px solid black;
            margin:auto;
            position:absolute;
            top:0;
            right:0;
            bottom:0;
            left:0;
        }
    </style>
</head>
<body>
<img src="" alt="" id="img">
<%
    Date now = new Date();
    String dateStr;
    dateStr = String.format("%tH:%tM:%tS",now,now,now);//注意时间输出格式的大小写
%>
<%=dateStr %><p>
        <%
  	response.setHeader("refresh","3");//3秒刷新
        %>
</body>
<script type="text/javascript">
    var num = Math.round(Math.random()*43);
    var g = document.getElementById("img");
    g.src = "img/"+num+".jpg";
</script>
</html>
