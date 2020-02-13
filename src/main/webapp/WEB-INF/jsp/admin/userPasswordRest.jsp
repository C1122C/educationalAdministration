<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>密码重置</title>
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
					    	<h1 style="text-align: center;">重置用户密码</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" name="reset" role="form" action="/admin/userPasswordRest" id="editfrom" method="post">
							  <div class="form-group">
							    <label for="userName" class="col-sm-2 control-label">账号</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="userName" id="userName" placeholder="请输入用户名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="password" class="col-sm-2 control-label">密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword2" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" name="password2" id="inputPassword2" placeholder="请再次输入密码">
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