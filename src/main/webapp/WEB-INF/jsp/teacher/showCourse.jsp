<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>课程信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">我教授的课程</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/teacher/searchCourse" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入课程名" name="findByName">
									<span class="input-group-addon btn" onclick="document.getElementById('form1').submit()" id="sub">搜索</span>
								</div>
							</form>
						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>课程号</th>
									<th>课程名称</th>
									<th>上课时间</th>
									<th>上课地点</th>
									<th>周数</th>
									<th>课程类型</th>
									<th>学分</th>
									<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${courseList}" var="item">
								<tr>
									<td>${item.courseId}</td>
									<td>${item.courseName}</td>
									<td>${item.courseTime}</td>
									<td>${item.classroom}</td>
									<td>${item.courseWeek}</td>
									<td>${item.courseType}</td>
									<td>${item.score}</td>
									<td><button class="btn btn-default btn-xs btn-info" onClick="location.href='/teacher/showGrade?id=${item.courseId}'">查看</button></td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</body>
</html>