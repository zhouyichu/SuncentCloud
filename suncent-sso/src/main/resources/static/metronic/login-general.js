"use strict";
var KTLogin=function(){
	var t,
	i=function(i){
		var o="login-"+i+"-on";
		i="kt_login_"+i+"_form";
		t.removeClass("login-forgot-on"),
		t.removeClass("login-signin-on"),
		t.removeClass("login-signup-on"),
		t.addClass(o),
		KTUtil.animateClass(KTUtil.getById(i),
		"animate__animated animate__backInUp")
	};
	return{
		init:function(){
			var o;
			t=$("#kt_login"),
			o=FormValidation.formValidation(KTUtil.getById("kt_login_signin_form"),{
				fields:{
					account:{
						validators:{
							notEmpty:{
								message:"请输入有效邮箱或手机号"
							},
							remote: {
								url: "../validate/checkAccount",
								message: '账号不存在，请检查后重输',
								delay: 1000,
								type: 'POST'
							}
						}
					},
					password:{
						validators:{
							notEmpty:{
								message:"请输入密码"
							}
						}
					}
				},
				plugins:{
					trigger:new FormValidation.plugins.Trigger,
					submitButton:new FormValidation.plugins.SubmitButton,
					bootstrap:new FormValidation.plugins.Bootstrap
				}
			}),
			$("#kt_login_signin_submit").on("click",(function(t){
				t.preventDefault(),
				o.validate().then(
					(
						function(t){
							if("Valid"==t){
								var account = $("#account").val();
								var password = $("#password").val();
								var returnUrl = $("#returnUrl").val();
								var param = {};
								if(/^1[34578]\d{9}$/.test(account)){
									param.phone = account;
								}else{
									param.email = account;
								}
								param.pwd = password;
								param.returnUrl = returnUrl;
								$.ajax({
									url:"login",
									data:param,
									async:false,
									type:"post",
									dataType:"json",
									success:function(data){
										console.log(data);
										swal.fire({
											text:"登录成功，正在为您跳转...",
											icon:"success",
											buttonsStyling:!1,
											confirmButtonText:"确定",
											customClass:{confirmButton:"btn font-weight-bold btn-light-primary"}
										});
									},
									error:function(data){
										
									}
								});
							}else{
								swal.fire({
									text:"登录失败，请输入正确信息并重试！",
									icon:"error",
									buttonsStyling:!1,
									confirmButtonText:"确定",
									customClass:{confirmButton:"btn font-weight-bold btn-light-primary"}
								});
							}
						}
					)
				)
			})),
			$("#kt_login_forgot").on("click",(function(t){
				t.preventDefault(),i("forgot")}
			)),
			$("#kt_login_signup").on("click",(function(t){
				t.preventDefault(),i("signup")}
			)),
			function(t){
				var o,n=KTUtil.getById("kt_login_signup_form");
				o=FormValidation.formValidation(n,{
					fields:{
						fullname:{
							validators:{
								notEmpty:{message:"Username is required"}
							}
						},
						email:{
							validators:{
								notEmpty:{
									message:"Email address is required"
								},
								emailAddress:{
									message:"The value is not a valid email address"
								}
							}
						},
						password:{
							validators:{
								notEmpty:{
									message:"The password is required"
								}
							}
						},
						cpassword:{
							validators:{
								notEmpty:{
									message:"The password confirmation is required"
								},
								identical:{
									compare:function(){
										return n.querySelector('[name="password"]').value
									},
									message:"The password and its confirm are not the same"
								}
							}
						},
						agree:{
							validators:{
								notEmpty:{
									message:"You must accept the terms and conditions"
								}
							}
						}
					},
					plugins:{
						trigger:new FormValidation.plugins.Trigger,
						bootstrap:new FormValidation.plugins.Bootstrap
					}
				}),
			$("#kt_login_signup_submit").on("click",(
				function(t){
					t.preventDefault(),
					o.validate().then((
						function(t){
							"Valid"==t?swal.fire({
								text:"恭喜，注册成功！",
								icon:"success",
								buttonsStyling:!1,
								confirmButtonText:"确定",
								customClass:{confirmButton:"btn font-weight-bold btn-light-primary"}
							}).then((function(){KTUtil.scrollTop()})):swal.fire({
								text:"信息有误，注册失败。请重试！",
								icon:"error",
								buttonsStyling:!1,
								confirmButtonText:"确定",
								customClass:{confirmButton:"btn font-weight-bold btn-light-primary"}
							}).then((function(){KTUtil.scrollTop()}))
						})
					)
			})),
			$("#kt_login_signup_cancel").on("click",(
				function(t){
					t.preventDefault(),
					i("signin")
				}
			))
		}(),
		function(t){
			var o;
			o=FormValidation.formValidation(
				KTUtil.getById("kt_login_forgot_form"),
				{
					fields:{
						email:{
							validators:{
								notEmpty:{message:"请填写邮箱地址"},
								emailAddress:{message:"邮箱地址不合法"}
							}
						}
					},
					plugins:{
						trigger:new FormValidation.plugins.Trigger,
						bootstrap:new FormValidation.plugins.Bootstrap
					}
				}
			),
			$("#kt_login_forgot_submit").on("click",(
				function(t){
					t.preventDefault(),
					o.validate().then(
						(
							function(t){
								"Valid"==t?KTUtil.scrollTop():swal.fire({
									text:"请输入正确的邮箱地址！",
									icon:"error",buttonsStyling:!1,
									confirmButtonText:"确定",
									customClass:{confirmButton:"btn font-weight-bold btn-light-primary"}
								}).then(
									(
										function(){
											KTUtil.scrollTop()
										})
									)
							}
						)
					)
				}
			)),
			$("#kt_login_forgot_cancel").on("click",(
				function(t){
					t.preventDefault(),
					i("signin")
				})
			)}()
		}
	}
}();
jQuery(document).ready(
	(
		function(){
			KTLogin.init()
		}
	)
);