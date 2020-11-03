<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta charset="UTF-8">
	    <script src="${request.contextPath}/static/js/jquery.js" type="text/javascript"></script>
	    <script src="${request.contextPath}/static/js/login.js" type="text/javascript"></script>
	    <title>Suncent-sso请先登录！</title>
	</head>
	<body>
		<div>
			<form action="login" method="post">
				用户名： <input name="account" id="account" value="Sam" type="text"/>
				<br/>
				密码： <input name="pwd" id="pwd" value="abc123" type="password"/>
				<input name="returnUrl" id="returnUrl" value="${returnUrl!""}" type="hidden"/>
				<br/>
				<input type="submit" value="登录"/>
			</form>
		</div>
	</body>
</html>