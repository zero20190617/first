<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
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
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form class="form-horizontal col-md-4 col-md-offset-4" action="${pageContext.request.contextPath}/longin"
          method="post">
        <h2 class="text-center">学员登录</h2>
        <div class="form-group form-group-lg">
            <div class="input-group">
                <span class="input-group-addon">账号</span>
                <input type="text" class="form-control" name="username"/>
            </div>
        </div>
        <div class="form-group form-group-lg" id="div_1" style="position: relative;">
            <div class="input-group">
                <span class="input-group-addon">密码</span>
                <input type="password" class="form-control" name="password"/>
            </div>
            <div class="form-group form-group-lg" id="div_2" style="position: absolute ;left: 16px ;top: 78px ;">
                <div>
                    <a href="register.jsp">没有账号?注册</a>
                </div>
            </div>
            <div class="form-group checkbox text-right"  style="position: absolute ;left: 320px ;top: 71px ;">
                <label>
                    <input type="checkbox" name="remember" value="true"/>自动登录
                </label>
            </div>

            <div class="form-group"  style="width: 100%;position: absolute ;left: 16px ;top: 100px ;">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="登录"></input>
            </div>

    </form>
</div>
<footer class="navbar navbar-fixed-bottom text-center">
    <span>软帝集团&nbsp;版权所有&copy; since 2006</span>
</footer>
<script src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
