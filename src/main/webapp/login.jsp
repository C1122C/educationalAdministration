<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>教学支持系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="/css/exam.css">
	<script src="/js/vue.js"></script>
</head>
<body id="login-page">
	<header role="banner" class="head">
		<nav role="navigation" class="nav-inner">
			<div class="container">
				<a class="brand" style="padding-left: 40px">教学支持系统</a>
				<div class="usermenu">
					<span class="login" style="padding-right: 40px">您尚未登录</span>
				</div>
			</div>
		</nav>
	</header>
	<div id="page" class="container-fluid">
		<header style="min-height: 121px;"></header>
		<div id="page-content" class="row-fluid">
			<section id="region-main" style="width: 100%;margin-left: 0;">
				<div role="main">
					<div class="loginbox clearfix">
						<div>
							<h2>登录</h2>
							<div class="loginsub subcontent">
								<form id="login" action="/login" method="post" role="form">
									<div class="loginform">
										<div class="form-label">
											<label for="userId">用户名</label>
										</div>
										<div class="form-input">
											<input type="text" id="userId" name="userId" size="15">
										</div>
										<div class="clearer"></div>
										<div class="form-label">
											<label for="password">密码</label>
										</div>
										<div class="form-input">
											<input type="password" id="password" name="password" size="15">
										</div>
									</div>
									<div class="clearer"></div>
									<input type="submit" id="loginbtn" value="登录">
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</body>
</html>