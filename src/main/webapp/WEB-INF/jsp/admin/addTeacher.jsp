<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">添加教师信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="/admin/addTeacher" id="editfrom" method="post">
							  <div class="form-group">
							    <label for="userId" class="col-sm-2 control-label">工号</label>
							    <div class="col-sm-10">
							      <input type="number" class="form-control" id="userId" name="userId" placeholder="请输入学号">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="userName" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入姓名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="sex" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10" id="sex">
								    <label class="checkbox-inline">
									   	<input type="radio" name="sex" value="男" checked />
									</label>
									<label class="checkbox-inline">
										<input type="radio" name="sex" value="女" />
									</label>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="birthYear" class="col-sm-2 control-label">出生年份</label>
							    <div class="col-sm-10">
								    <input type="date" value="1996-09-02" id="birthYear" name="birthYear"/>
							    </div>
							  </div>
							  <div class="form-group">
								<label for="degree" class="col-sm-2 control-label">学历：</label>
								<div class="col-sm-10">
									<select class="form-control" name="degree" id="degree">
										<option value="本科">本科</option>
										<option value="硕士">硕士</option>
										<option value="博士">博士</option>
									</select>
								</div>
							  </div>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">职称：</label>
								<div class="col-sm-10">
									<select class="form-control" name="title" id="title">
										<option value="普通教师">普通教师</option>
										<option value="助教">助教</option>
										<option value="讲师">讲师</option>
										<option value="副教授">副教授</option>
										<option value="教授">教授</option>
									</select>
								</div>
							</div>
							  <div class="form-group">
							    <label for="grade" class="col-sm-2 control-label">入职时间</label>
							    <div class="col-sm-10">
								    <input type="date" value="2015-09-02" name="grade" id="grade"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="collegeId" class="col-sm-2 control-label">所属院系</label>
							    <div class="col-sm-10">
								    <select class="form-control" name="collegeId" id="collegeId">
										<c:forEach items="${collegeList}" var="item">
											<option value="${item.collegeId}">${item.collegeName}</option>
										</c:forEach>
								    </select>
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
	<script type="text/javascript">
		$("#nav li:nth-child(3)").addClass("active")
	</script>
</html>