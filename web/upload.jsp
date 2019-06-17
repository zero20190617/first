<%@ page import="pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>

		<title>上传</title>
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
						<li><a href="${pageContext.request.contextPath}/all?index=1&number=2">所有资源</a></li>
						<li class="active"><a href="upload.jsp">上传资源</a></li>
						<li><a href="${pageContext.request.contextPath}/my?index=1&number=2">我的资源</a></li>
						<li><a href="#">${sessionScope.LONGIN_INFO.userName},已登录</a></li>
						<li><a href="#">上次登录时间：${sessionScope.LONGIN_INFO.lasttime}

						</a></li>
						<li><a href="${pageContext.request.contextPath}/longout">注销</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container">
			<form class="form-horizontal form-upload" action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
				<h3>资源上传</h3>
				<hr />
				<div class="form-group">
					<input type="file" name="files" id="files" style="display: none;"/>
					<div class="col-md-6 col-md-offset-2">
						<button type="button" id="selectFile" class="btn btn-info btn-lg">
							<span class="glyphicon glyphicon-plus"></span>
							选择文件
						</button>
						<small id="fname-box">
							未选择文件,可以上传
							<span class="text-danger">50M</span>
							以内的文件
						</small>
					</div>
				</div>	
				<div class="form-group">
					<label class="col-md-2 control-label">资源名称</label>
					<div class="col-md-6">
						<input type="text" class="form-control"  name="resourceName"/>
					</div>
				</div>	
				<div class="form-group">
					<label class="col-md-2 control-label" >关键词(标签)</label>
					<div class="col-md-6">
						<input type="text" class="form-control" placeholder="多个关键词使用&quot;,&quot;号隔开" name="antistop"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">下载积分</label>
					<div class="col-md-4">
						<input type="number" placeholder="积分规则0-20分" class="form-control" min="0" max="20"  name="downIntegral"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">资源描述</label>
					<div class="col-md-6">
						<textarea class="form-control" rows="3" placeholder="请输入资源描述，不支持HTML标签，请详细填写以便于作为推荐资源以赚取更多积分，如描述不清可能会无法审核通过" name="description"></textarea>
					</div>
				</div>	
				<div class="form-group">
					<div class="col-md-6 col-md-offset-2">
						<div class="checkbox">
						  <label>
						    <input type="checkbox" value="">
						    同意<a href="#">softeem资源共享规则</a>
						  </label>
						</div>
					</div>
				</div>	
				<div class="form-group">
					<div class="col-md-8 text-right">
						<input class="btn btn-primary" type="submit" value="上传"></input>
					</div>
				</div>	
			</form>
		</div>
		<footer class="navbar navbar-fixed-bottom text-center">
			<span>软帝集团&nbsp;版权所有&copy; since 2006</span>
		</footer>
		<script src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="bootstrap/3.3.4/js/bootstrap.min.js" ></script>
		<script>
			$(function(){
				$('#selectFile').click(function(){
					$('#files').click();
				})
				$('#files').change(function(){
					var file = $(this).val();
					$('#fname-box').text(file);
				});
			})
		</script>
	</body>
</html>
