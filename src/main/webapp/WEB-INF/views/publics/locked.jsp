<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="en">
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
										<div class="form-wrap">
											<form action="locked.do" method="post">
												<div class="form-group text-center">
													<c:if test="${empty manager.profileimg}">
														<img class="img-circle" src="dist/img/user.png" alt="user">
													</c:if>
													<c:if test="${not empty manager.profileimg}">
														<c:set var="flag" value="0"></c:set>
														<c:forEach items="${manager.profileimg}" var="pf">
															<c:if test="${pf.pro_file_img_type==1}">
																<img class="img-circle" src="/pro_head_portrait/${pf.pro_file_img_path }" alt="user" width="80px" height="80px">
																<input type="hidden" value="${flag=1 }"> 
															</c:if>
														</c:forEach>
														<c:if test="${flag==0}">
															<img class="img-circle" src="dist/img/user.png" alt="user">
														</c:if>
													</c:if>
													<h3 class="mt-10 txt-dark">${manager.manager_name }</h3>
												</div>
												<div class="form-group">
													<input type="password" id="pwd" name="pwd" class="form-control" required="required" placeholder="请输入您的密码">
												</div>
												<div class="form-group text-center">
													<button type="submit" class="btn btn-primary btn-rounded">确认</button>
												</div>
												<div class="form-group mb-0 text-center">
													<a href="login.do" class="inline-block txt-primary">切换账号</a>
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
				swal({  
		            title: "警告",   
		            text: msg,   
		            type: "warning",
		            confirmButtonColor: "#f8b32d",   
		            confirmButtonText: "知道了",   
		            closeOnConfirm: false 
		     	});
			}
	</script>
	</body>
</html>
