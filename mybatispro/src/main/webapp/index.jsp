<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>慕课网用户管理中心</title>

    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/2.2.4/jquery-1.12.4.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>慕课网后台管理系统 <small>用户数据管理中心</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h1>MyBatis基础入门课程!</h1>
            <p>通过一个项目来完成基础部分的学习</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多，请上慕课网</a></p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/addusers.jsp" role="button">新增用户</a></p>
        </div>
    </div>
</div>
</body>
</html>
