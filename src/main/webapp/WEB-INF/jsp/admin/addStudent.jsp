<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>添加学生</title>
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
					    	<h1 style="text-align: center;">添加学生信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="/admin/addStudent" id="editfrom" method="post">
							  <div class="form-group">
							    <label for="userId" class="col-sm-2 control-label">学号</label>
							    <div class="col-sm-10">
							      <input type="number" class="form-control" id="userId" name="userId" placeholder="请输入学号"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="userName" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入姓名"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="sex" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10">
								    <label class="checkbox-inline">
									   	<input type="radio" id="sex" name="sex" value="男" checked>男
									</label>
									<label class="checkbox-inline">
										<input type="radio" name="sex" value="女">女
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
							    <label for="grade" class="col-sm-2 control-label">入学时间</label>
							    <div class="col-sm-10">
								    <input type="date" value="2015-09-02" id="grade" name="grade"/>
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