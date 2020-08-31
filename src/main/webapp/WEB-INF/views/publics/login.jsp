<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<title>Elmer I Fast build Admin dashboard for any platform</title>
		<meta name="description" content="Elmer is a Dashboard & Admin Site Responsive Template by hencework." />
		<meta name="keywords" content="admin, admin dashboard, admin template, cms, crm, Elmer Admin, Elmeradmin, premium admin templates, responsive admin, sass, panel, software, ui, visualization, web app, application" />
		<meta name="author" content="hencework"/>
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="icon" href="favicon.ico" type="image/x-icon">
		
		<!-- vector map CSS -->
		<link href="vendors/bower_components/jasny-bootstrap/dist/css/jasny-bootstrap.min.css" rel="stylesheet" type="text/css"/>
		
		<!--alerts CSS -->
		<link href="vendors/bower_components/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
		
		<!-- Custom CSS -->
		<link href="dist/css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<!--Preloader-->
		<div class="preloader-it">
			<div class="la-anim-1"></div>
		</div>
		<!--/Preloader-->
		
		<div class="wrapper  pa-0">
			<header class="sp-header">
				<div class="sp-logo-wrap pull-left">
					<a href="index.do">
						<img class="brand-img mr-10" src="dist/img/logo.png" alt="brand"/>
						<span class="brand-text">Elmer</span>
					</a>
				</div>
				<div class="form-group mb-0 pull-right">
					<span class="inline-block pr-10">还没有账号?</span>
					<a class="inline-block btn btn-primary  btn-rounded btn-outline" href="signup.do">注册</a>
				</div>
				<div class="clearfix"></div>
			</header>
			
			<!-- Main Content -->
			<form class="container"  action="<%=basePath%>login.do" method="post"> 
			<div class="page-wrapper pa-0 ma-0 auth-page">
				<div class="container-fluid">
					<!-- Row -->
					<div class="table-struct full-width full-height">
						<div class="table-cell vertical-align-middle auth-form-wrap">
							<div class="auth-form  ml-auto mr-auto no-float">
								<div class="row">
									<div class="col-sm-12 col-xs-12">
										<div class="mb-30">
											<h3 class="text-center txt-dark mb-10">登录到会员积分管理系统</h3>
											<h6 class="text-center nonecase-font txt-grey">在下面输入您的详细信息</h6>
										</div>	
										<div class="form-wrap">
												<div class="form-group">
													<label class="control-label mb-10" for="exampleInputEmail_2">您的联系方式</label>
													<input type="tel" class="form-control" required="required" id="exampleInputEmail_2" name="exampleInputEmail_2" placeholder="输入手机号码">
												</div>
												<div class="form-group">
													<label class="pull-left control-label mb-10" for="exampleInputpwd_2">密码</label>
													<a class="capitalize-font txt-primary block mb-10 pull-right font-12" href="forgot_pwd.do">忘记密码?</a>
													<div class="clearfix"></div>
													<input type="password" class="form-control" required="required" id="exampleInputpwd_2" name="exampleInputpwd_2" placeholder="输入密码">
												</div>
												
												<div class="form-group">
													<div class="checkbox checkbox-primary pr-10 pull-left">
														<input id="checkbox_2" required="required" type="checkbox">
														<label for="checkbox_2"><span class="txt-primary">同意并接收《用户协议》</span></label>
													</div>
													<div class="clearfix"></div>
												</div>
												<div class="form-group text-center">
													<button type="submit" class="btn btn-primary  btn-rounded">登入</button>
												</div>
										</div>
									</div>	
								</div>
							</div>
						</div>
					</div>
					<!-- /Row -->	
				</div>
			</div>
			</form>
			<!-- /Main Content -->
		
		</div>
		<!-- /#wrapper -->
		
		<!-- JavaScript -->
		
		<!-- jQuery -->
		<script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
		
		<!-- Bootstrap Core JavaScript -->
		<script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="vendors/bower_components/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"></script>
		
		<!-- Slimscroll JavaScript -->
		<script src="dist/js/jquery.slimscroll.js"></script>
		
		<!-- Sweet-Alert  -->
		<script src="vendors/bower_components/sweetalert/dist/sweetalert.min.js"></script>
		
		<script src="dist/js/sweetalert-data.js"></script>
		
		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>
		
		<script type="text/javascript">
			var msg = '${msg}';
			if(msg!=null&&msg!=''){
				if(msg=='1'){
					swal("修改成功!", "密码修改成功，请重新登录！", "success");  
				}
				else{
					swal({  
			            title: "警告",   
			            text: msg,   
			            type: "warning",
			            confirmButtonColor: "#f8b32d",   
			            confirmButtonText: "知道了",   
			            closeOnConfirm: false 
			     	});
				} 
			}
		</script>
	</body>
</html>
