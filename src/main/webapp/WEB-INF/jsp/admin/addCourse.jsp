<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>添加课程</title>
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
						<h1 style="text-align: center;">添加课程信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="/admin/addCourse" id="editfrom" method="post">
						<div class="form-group">
							<label for="courseId" class="col-sm-2 control-label">课程号</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="courseId" name="courseId" placeholder="请输入课程号">
							</div>
						</div>
						<div class="form-group">
							<label for="courseName" class="col-sm-2 control-label">课程名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="courseName" name="courseName" placeholder="请输入课程名称">
							</div>
						</div>
						<div class="form-group">
							<label for="teacherId" class="col-sm-2 control-label">授课老师编号</label>
							<div class="col-sm-10">
								<select class="form-control" name="teacherId" id="teacherId">
									<c:forEach items="${teacherList}" var="item">
										<option value="${item.userId}">${item.userName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="courseTime" class="col-sm-2 control-label">上课时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="courseTime" id="courseTime" placeholder="请输入上课时间">
							</div>
						</div>
						<div class="form-group">
							<label for="classroom" class="col-sm-2 control-label">上课地点</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="classroom" id="classroom" placeholder="上课地点">
							</div>
						</div>
						<div class="form-group">
							<label for="courseWeek" class="col-sm-2 control-label">周数</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="courseWeek" name="courseWeek" placeholder="请输入周数">
							</div>
						</div>
						<div class="form-group">
							<label for="courseType" class="col-sm-2 control-label">课程的类型：</label>
							<div class="col-sm-10">
								<select class="form-control" id="courseType" name="courseType">
									<option value="必修课">必修课</option>
									<option value="选修课">选修课</option>
									<option value="公共课">公共课</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="collegeId" class="col-sm-2 control-label">所属院系</label>
							<div class="col-sm-10">
								<select class="form-control" id="collegeId" name="collegeId">
									<c:forEach items="${collegeList}" var="item">
										<option value="${item.collegeId}">${item.collegeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="score" class="col-sm-2 control-label">学分：</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" name="score" id="score" placeholder="请输入学分">
							</div>
						</div>
						<div class="form-group" style="text-align: center">
							<button class="btn btn-default" type="submit">提交</button>
							<button class="btn btn-default" type="reset">重置</button>
						</div>
					</form>
				</div>

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