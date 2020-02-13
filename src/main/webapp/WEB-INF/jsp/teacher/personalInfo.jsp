<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>个人信息</title>
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
						<h1 class="col-md-5">个人信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="/teacher/editInfo" id="editfrom" method="post">
						<div class="form-group ">
							<label class="col-sm-2 control-label" >工号</label>
							<div class="col-sm-10">
								<div style="margin-top: 8px;">${teacher.userId}</div>
							</div>
						</div>
						<div class="form-group">
							<label for="userName" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userName" name="userName" value="${teacher.userName}">
							</div>
						</div>
						<div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="checkbox-inline" id="sex">
									<input type="radio" name="sex" value="男" checked>男
								</label>
								<label class="checkbox-inline">
									<input type="radio" name="sex" value="女">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="birthYear" class="col-sm-2 control-label">出生年份</label>
							<div class="col-sm-10">
								<input type="date" id="birthYear" value="<fmt:formatDate value="${teacher.birthYear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthYear"/>
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