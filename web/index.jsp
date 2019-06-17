<%@ page import="pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <span class="navbar-brand">SOFTEEM资源共享系统</span>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${pageContext.request.contextPath}/all?number=2&index=1">所有资源</a></li>
                <li><a href="upload.jsp" >上传资源</a></li>
                <li><a href="${pageContext.request.contextPath}/my?number=2&index=1">我的资源</a></li>
                <li><a href="#">${sessionScope.LONGIN_INFO.userName},已登录</a></li>
                <li><a href="#">上次登录时间：${sessionScope.LONGIN_INFO.lasttime}
                </a></li>
                <li><a href="${pageContext.request.contextPath}/longout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="btn-group btn-group-sm col-md-5">
        <button class="btn btn-info active">按上传时间</button>
        <button class="btn btn-info">按下载量</button>
    </div>
    <form class="form-inline col-md-5 text-right col-md-offset-2">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入需要查询关键字"/>
        </div>
        <button class="btn btn-primary">搜索</button>
    </form>
    <hr/>
    <table class="table table-striped table-hover">
        <tr>
            <th>序号</th>
            <th>资源名</th>
            <th>标签</th>
            <th>大小</th>
            <th>上传时间</th>
            <th>提供者</th>
            <th>需要积分</th>
            <th>下载量</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.ALL_INFO.imgs}" var="img" varStatus="vs">
            <tr>
                <td>${vs.index+1+(ALL_INFO.thisPage-1)*2}</td>
                <td>${img.resourcename}</td>
                <td>
                    <c:forTokens items="${img.antistop}" delims="," var="v">
                        <span class="label label-success">${v}</span>
                    </c:forTokens>
                </td>
                <td>${img.size}</td>
                <td>${img.uploadtime}</td>
                <td>${img.username}</td>
                <td>${img.downintegral}</td>
                <td>${img.downloads}</td>
                
                <td>
                    <a href="${pageContext.request.contextPath}/particulars?id=${img.id}">详情</a>
                    <a href="${pageContext.request.contextPath}/download?fileName=${img.filename}&downloads=${img.downloads}&id=${img.id}">下载</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav class="text-center">
        <ul class="pagination">
            <c:if test="${requestScope.ALL_INFO.thisPage == 1}">
                <li><a href="javascript:;" title="上一页">&lt;</a></li>
            </c:if>
            <c:if test="${requestScope.ALL_INFO.thisPage != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/all?number=2&index=${requestScope.ALL_INFO.thisPage-1}"
                       title="上一页">&lt;</a></li>
            </c:if>
            <c:forEach begin="1" end="${requestScope.ALL_INFO.pageNumber}" varStatus="vs">
                <c:if test="${vs.index == requestScope.ALL_INFO.thisPage}">
                    <li class="active"><a href="javascript:;">${vs.index}</a></li>
                </c:if>
                <c:if test="${vs.index != requestScope.ALL_INFO.thisPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/all?number=2&index=${vs.index}">${vs.index}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${requestScope.ALL_INFO.thisPage == requestScope.ALL_INFO.pageNumber}">
                <li><a href="javascript:;" title="下一页">&gt;</a></li>
            </c:if>
            <c:if test="${requestScope.ALL_INFO.thisPage != requestScope.ALL_INFO.pageNumber}">
                <li>
                    <a href="${pageContext.request.contextPath}/all?number=2&index=${requestScope.ALL_INFO.thisPage+1}"
                       title="上一页">&gt;</a></li>
            </c:if>
        </ul>
    </nav>
</div>
<footer class="navbar navbar-fixed-bottom text-center">
    <span>软帝集团&nbsp;版权所有&copy; since 2006</span>
</footer>
<script src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
