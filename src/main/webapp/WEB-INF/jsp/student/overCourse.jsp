<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>已修课程</title>
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
					    	<h1 class="col-md-5">已修课程</h1>
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
									<th>成绩</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${overCourseList}" var="item">
								<c:if test="${item.over}">
									<tr>
										<td>${item.couseCustom.courseId}</td>
										<td>${item.couseCustom.courseName}</td>
										<td>${item.couseCustom.courseTime}</td>
										<td>${item.couseCustom.classroom}</td>
										<td>${item.couseCustom.courseWeek}</td>
										<td>${item.couseCustom.courseType}</td>
										<td>${item.couseCustom.score}</td>
										<c:if test="${item.mark >= 60}">
											<td style="color: lawngreen">${item.mark}</td>
										</c:if>
										<c:if test="${item.mark < 60}">
											<td style="color: red">${item.mark}</td>
										</c:if>
									</tr>
								</c:if>
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