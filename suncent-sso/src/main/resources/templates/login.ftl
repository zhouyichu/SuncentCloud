<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta charset="UTF-8">
	    <link rel="shortcut icon" href="${request.contextPath}/static/images/toubosi_ico.png" type="image/x-icon">
		<link href="${request.contextPath}/static/bootstrap4.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="${request.contextPath}/static/metronic/plugins.bundle.css" rel="stylesheet" type="text/css">
		<link href="${request.contextPath}/static/metronic/style.bundle.css" rel="stylesheet" type="text/css">
		<link href="${request.contextPath}/static/metronic/login-4.css" rel="stylesheet" type="text/css">
		<link href="${request.contextPath}/static/css/login.css" rel="stylesheet" type="text/css">
		
		<script src="${request.contextPath}/static/js/jquery.js" type="text/javascript"></script>
		<script src="${request.contextPath}/static/metronic/scripts.bundle.js" type="text/javascript"></script>
		<script src="${request.contextPath}/static/metronic/plugins.bundle.js" type="text/javascript"></script>
		<script src="${request.contextPath}/static/metronic/login-general.js" type="text/javascript"></script>
	    <script src="${request.contextPath}/static/js/login.js" type="text/javascript"></script>
	    <title>拓博斯-统一登录平台</title>
	</head>
	<body>
		<div class="d-flex bg-block flex-column flex-root">
			<div class="login login-4 login-signin-on d-flex flex-row-fluid" id="kt_login">
				<div class="d-flex flex-center flex-row-fluid bgi-size-cover bgi-position-top bgi-no-repeat">
					<div class="login-form text-center p-7 position-relative overflow-hidden">
						<!--begin::Login Header-->
						<div class="d-flex flex-center mb-15">
							<a href="#">
								<img src="${request.contextPath}/static/images/logo-letter.png" class="max-h-75px" alt="">
							</a>
						</div>
						<!--end::Login Header-->
						<!--begin::Login Sign in form-->
						<div class="login-signin">
							<div class="mb-20">
								<h3>登录到Tuobosi</h3>
								<div class="text-muted font-weight-bold">登录成功后，可访问Tuobosi平台下所有应用</div>
							</div>
							<form class="form fv-plugins-bootstrap fv-plugins-framework" id="kt_login_signin_form">
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="邮箱或手机" id="account" name="account" autocomplete="off">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="密码" name="password" id="password"/>
								</div>
								<div class="form-group d-flex flex-wrap justify-content-between align-items-center">
									<div class="checkbox-inline">
										<label class="checkbox m-0 text-muted">
										<input type="checkbox" name="remember">
										<span></span>记住我，下次免登录</label>
									</div>
									<a href="javascript:;" id="kt_login_forgot" class="text-muted text-hover-primary">忘记密码了吗?</a>
								</div>
								<button id="kt_login_signin_submit" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-4">登录</button>
							</form>
							<div class="mt-10">
								<span class="opacity-70 mr-4">还没有账号？</span>
								<a href="javascript:;" id="kt_login_signup" class="text-muted text-hover-primary font-weight-bold">注册！</a>
							</div>
						</div>
						<!--end::Login Sign in form-->
						<!--begin::Login Sign up form-->
						<div class="login-signup">
							<div class="mb-20">
								<h3>欢迎注册Toubosi</h3>
							</div>
							<form class="form fv-plugins-bootstrap fv-plugins-framework" id="kt_login_signup_form">
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="姓名" name="name">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="英文名" name="nameEn">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="电话" name="phone">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="邮箱" name="email">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<select class="form-control h-auto form-control-solid py-4 px-8" placeholder="一级部门" name="core">
										<option value="">一级部门</option>
										<#list core as c>
										<option value="${c.id}">${c.core}</option>
										</#list>
									</select>
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<select class="form-control h-auto form-control-solid py-4 px-8" placeholder="二级部门" name="dept">
										<option value="">二级部门</option>
										<#list dept as d>
										<option value="${d.id}">${d.dept}</option>
										</#list>
									</select>
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="密码" name="password">
								</div>
								<div class="form-group mb-5 fv-plugins-icon-container">
									<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="再次输入密码" name="cpassword">
								</div>
								<div class="form-group mb-5 text-left fv-plugins-icon-container">
									<div class="checkbox-inline">
										<label class="checkbox m-0">
											<input type="checkbox" name="agree">
											<span></span>我同意
											<a href="#" class="font-weight-bold ml-1 mr-1">服务政策</a>和
											<a href="#" class="font-weight-bold ml-1">隐私声明</a>
										</label>
									</div>
								</div>
								<div class="form-group d-flex flex-wrap flex-center mt-10">
									<button id="kt_login_signup_submit" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-2">注册</button>
									<button id="kt_login_signup_cancel" class="btn btn-light-primary font-weight-bold px-9 py-4 my-3 mx-2">返回</button>
								</div>
							</form>
						</div>
						<!--end::Login Sign up form-->
						<!--begin::Login forgot password form-->
						<div class="login-forgot">
							<div class="mb-20">
								<h3>忘记密码了?</h3>
								<div class="text-muted font-weight-bold">通过注册绑定的邮箱来找回密码</div>
							</div>
							<form class="form fv-plugins-bootstrap fv-plugins-framework" id="kt_login_forgot_form">
								<div class="form-group mb-10 fv-plugins-icon-container">
									<input class="form-control form-control-solid h-auto py-4 px-8" type="text" placeholder="Email" name="email" autocomplete="off">
								</div>
								<div class="form-group d-flex flex-wrap flex-center mt-10">
									<button id="kt_login_forgot_submit" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-2">提交</button>
									<button id="kt_login_forgot_cancel" class="btn btn-light-primary font-weight-bold px-9 py-4 my-3 mx-2">返回</button>
								</div>
							</form>
						</div>
						<!--end::Login forgot password form-->
						<input id="returnUrl" value="${returnUrl!""}" type="hidden"/>
					</div>
				</div>
			</div>
			<!--begin::Footer-->
			<div class="footer py-4 d-flex flex-lg-column">
				<div class="container-fluid d-flex flex-column flex-md-row align-items-center justify-content-between">
					<div class="text-dark order-2 order-md-1 footer-display">
						<span class="text-muted font-weight-bold mr-2">2020©</span>
						<span class="text-muted font-weight-bold mr-2">深圳拓博斯软件技术有限公司 版权所有</span>
						<a href="#" target="_blank" class="text-dark-75 text-hover-primary mr-5">Tuobosi</a>
						<span class="text-muted font-weight-bold mr-2">粤ICP备 19155510号</span>
					</div>
				</div>
			</div>
			<!--end::Footer-->
		</div>
	</body>
	<script>var KTAppSettings = { "breakpoints": { "sm": 576, "md": 768, "lg": 992, "xl": 1200, "xxl": 1400 }, "colors": { "theme": { "base": { "white": "#ffffff", "primary": "#3699FF", "secondary": "#E5EAEE", "success": "#1BC5BD", "info": "#8950FC", "warning": "#FFA800", "danger": "#F64E60", "light": "#E4E6EF", "dark": "#181C32" }, "light": { "white": "#ffffff", "primary": "#E1F0FF", "secondary": "#EBEDF3", "success": "#C9F7F5", "info": "#EEE5FF", "warning": "#FFF4DE", "danger": "#FFE2E5", "light": "#F3F6F9", "dark": "#D6D6E0" }, "inverse": { "white": "#ffffff", "primary": "#ffffff", "secondary": "#3F4254", "success": "#ffffff", "info": "#ffffff", "warning": "#ffffff", "danger": "#ffffff", "light": "#464E5F", "dark": "#ffffff" } }, "gray": { "gray-100": "#F3F6F9", "gray-200": "#EBEDF3", "gray-300": "#E4E6EF", "gray-400": "#D1D3E0", "gray-500": "#B5B5C3", "gray-600": "#7E8299", "gray-700": "#5E6278", "gray-800": "#3F4254", "gray-900": "#181C32" } }, "font-family": "Poppins" };</script>
</html>