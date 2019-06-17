<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24 0024
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>资源详情</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/123.css"/>

</head>
<body>
<c:forEach items="${sessionScope.PAS_IFFO}" var="img" varStatus="vs">
    <div id="div1">
        <p><span style="visibility: hidden;">资</span>资源名:<span
                style="visibility: hidden;">1</span>${img.resourcename}</p>
        <p><span style="visibility: hidden;">源</span>标签:<span style="visibility: hidden;">1</span>${img.antistop}
        </p>
        <p><span style="visibility: hidden;">源</span>大小:<span style="visibility: hidden;">1</span>${img.size}</p>
        <p><span style="visibility: hidden;">源</span>上传时间:<span
                style="visibility: hidden;">1</span>${img.uploadtime}</p>
        <p><span style="visibility: hidden;">源</span>提供者:<span style="visibility: hidden;">1</span>${img.username}
        </p>
        <p><span style="visibility: hidden;">源</span>需要积分:<span
                style="visibility: hidden;">1</span>${img.downintegral}</p>
        <p><span style="visibility: hidden;">源</span>资源描述:<span
                style="visibility: hidden;">1</span>${img.description}</p>
    </div>

</c:forEach>
<c:remove var="PAS_IFFO" scope="session"></c:remove>
</body>
</html>
