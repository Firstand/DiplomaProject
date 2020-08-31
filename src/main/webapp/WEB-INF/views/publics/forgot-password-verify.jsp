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
		
		<!-- Custom CSS -->
		<link href="dist/css/style.css" rel="stylesheet" type="text/css">
		<link href="dist/css/signup.css" rel="stylesheet" type="text/css">
		
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
					<span class="inline-block pr-10">密码想起来了?</span>
					<a class="inline-block btn btn-primary  btn-rounded btn-outline" href="login.do">登录</a>
				</div>
				<div class="clearfix"></div>
			</header>
			
			<!-- Main Content -->
			<div class="page-wrapper pa-0 ma-0 auth-page">
				<div class="container-fluid">
					<!-- Row -->
					<div class="table-struct full-width full-height">
						<div class="table-cell vertical-align-middle auth-form-wrap">
							<div class="auth-form  ml-auto mr-auto no-float">
								<div class="row">
									<div class="col-sm-12 col-xs-12">
										<div class="sp-logo-wrap text-center pa-0 mb-30">
											<a href="index.html">
												<img class="brand-img mr-10" src="dist/img/logo.png" alt="brand"/>
												<span class="brand-text">Elmer</span>
											</a>
										</div>
										<div class="mb-30">
											<h3 class="text-center txt-dark mb-10">忘记密码了吗?</h3>
											<h6 class="text-center txt-grey nonecase-font">我们需要验证您的身份，请获取验证码。</h6>
										</div>	
										<div class="form-wrap">
											<form action="<%=basePath%>forgot_pwd.do" method="post">
												<div class="form-group relative">
													<label class="control-label mb-10" for="exampleInputEmail_2">短信验证码</label>
													<input type="hidden" id="u_tel1" name="u_tel1" value="${u_tel }">
													<input type="hidden" id="flag" name="flag" value="2">
													<input type="number" class="form-control width_75" required="required" id="u_verify" name="u_verify" placeholder="输入验证码">
													<input type="button" class="btn btn-success absolute_btn_pwdver" id="geting" onclick="ver()" value="获取验证码">
												</div>
												<div class="form-group text-center">
													<button type="submit" class="btn btn-primary btn-rounded">开始验证</button>
												</div>
											</form>
										</div>
									</div>	
								</div>
							</div>
						</div>
					</div>
					<!-- /Row -->	
				</div>
				
			</div>
			<!-- /Main Content -->
		</div>
		<!-- /#wrapper -->
		
		<!-- JavaScript -->
		
		<!-- jQuery -->
		<script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
		<!-- Cookie -->
		<script src="dist/js/jquery.cookie.js"></script>
		<!-- XiaoYan -->
		<script type="text/javascript" src="dist/js/registerVerify.js" ></script>
		<script type="text/javascript" src="dist/js/check.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="vendors/bower_components/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"></script>
		
		<!-- Slimscroll JavaScript -->
		<script src="dist/js/jquery.slimscroll.js"></script>
		
		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>
		
		<script type="text/javascript">
			function ver() {
				   var mobi = $("#u_tel1").val();
				   if(mobi!=null&&mobi!=''){
					   $.ajax({
					         type:"get",    //发送请求的方式，默认请求方式为get
					         url:"telverify.do",           //发送到什么位置
					         data:{
					        	 "verify":mobi
					        	 },      //要传给服务器的参数
					         success:function(data){//会在返回完整，请求成功时调用，其中的参数是返回值
					          //对返回值进行操作
					          if(data==1){
					        	  alert("验证码发送成功");
					          }else{
					        	  alert("验证码发送失败，请检查手机号是否正确！"); 
					          }
				             },
				            //若返回值的类型为json，则需要指定dataType
				             dataType:"json"  //告知此次请求的返回值是json串
				      });  
				   }
				   else{
					   alert("您的手机号没填！");
					   localtion.href="forgot-pwd.do";
				   }
				   
			 }
			
			var msg = '${msg}';
			if(msg!=null&&msg!='')
				alert(msg);
		</script>
	</body>
</html>
