<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta charset="UTF-8">
	    <title>Suncent聊天室</title>
	    <link rel="shortcut icon" href="static/image/logo-icon.png" type="image/x-icon">
		<script src="static/js/jquery3.4.1.js" type="text/javascript"></script>
		<script src="static/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="static/js/jquery.slimscroll.min.js" type="text/javascript"></script>
		<script src="static/js/chatroom.js" type="text/javascript"></script>
		<link href="static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="static/css/chatroom.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="main-body">
			<div class="msg-list">
				<div class="inbox">
					<div class="inbox-body"></div>
				</div>
			</div>
			<form class="form-horizontal">
				<div class="form-body">
					<div class="form-group">
						<label class="col-md-2 control-label">ID</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="nick" name="nick" value="${nick!""}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">消息</label>
						<div class="col-md-8">
							<textarea class="form-control" rows="3" id="msg"></textarea>
						</div>
					</div>
					<div class="form-group text-center">
						<div class="btn btn-info" id="send-msg">发送</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>