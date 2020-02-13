<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>评分</title>
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
					    	<h1 style="text-align: center;">课程评分</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form name="reset" class="form-horizontal" role="form" action="/teacher/mark" id="editfrom" method="post">
							<div class="form-group">
								<label for="courseId" class="col-sm-2 control-label">课程编号</label>
								<div class="col-sm-10">
									<input  readonly="readonly" type="text" class="form-control" name="courseId" id="courseId" value="${selectedCourse.courseId}">
								</div>
							</div>
							<div class="form-group">
							    <label for="studentId" class="col-sm-2 control-label">学号</label>
							    <div class="col-sm-10">
							      <input  readonly="readonly" type="text" class="form-control" name="studentId" id="studentId" value="${selectedCourse.studentId}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="name" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input  readonly="readonly" type="text" name="name" class="form-control" id="name" value="${selectedCourse.studentCustom.userName}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="mark" class="col-sm-2 control-label">成绩</label>
							    <div class="col-sm-10">
							      <input type="number" name="mark" class="form-control" id="mark" placeholder="请输入成绩">
							    </div>
							  </div>
							  <div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default">重置</button>
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