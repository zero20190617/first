<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>

		<title>注册</title>
		<link rel="stylesheet" type="text/css" href="bootstrap/3.3.4/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap-theme.min.css" />
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

		<form class="form-horizontal col-md-4 col-md-offset-4" action="${pageContext.request.contextPath}/register" method="post">
			<h2 class="text-center">学员注册</h2>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">账<span style="visibility: hidden;">账号</span>号</span>
					<input type="text" class="form-control" name="username"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">密<span style="visibility: hidden;">密码</span>码</span>
					<input type="password" class="form-control" name="password"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">邮<span style="visibility: hidden;">邮箱</span>箱</span>
					<input type="text" class="form-control" name="email" />
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">手<span style="visibility: hidden;">密码</span>机</span>
					<input type="text" class="form-control" name="phone"/>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-lg btn-block">立即注册</button>
			</div>
			<footer class="navbar navbar-fixed-bottom text-center">
			<span>软帝集团&nbsp;版权所有&copy; since 2006</span>
		</footer>
		<script src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="bootstrap/3.3.4/js/bootstrap.min.js" ></script>
	</body>
</html>
