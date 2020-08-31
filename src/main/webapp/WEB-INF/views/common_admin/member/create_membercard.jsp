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

		<!-- Custom CSS -->
		<link href="dist/css/style.css" rel="stylesheet" type="text/css">
		
		<!--alerts CSS -->
		<link href="vendors/bower_components/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
		
		<!-- bootstrap-tagsinput CSS -->
		<link href="vendors/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet" type="text/css"/>
		
		<!-- bootstrap-select CSS -->
		<link href="vendors/bower_components/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
		
	</head>
	<body>
		<!--Preloader-->
		<div class="preloader-it">
			<div class="la-anim-1"></div>
		</div>
		<!--/Preloader-->
		<div class="wrapper  theme-1-active pimary-color-blue">
			<!-- Top Menu Items -->
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="mobile-only-brand pull-left">
					<div class="nav-header pull-left">
						<div class="logo-wrap">
							<a href="index.do">
								<img class="brand-img" src="dist/img/logo.png" alt="brand"/>
								<span class="brand-text">Elmer</span>
							</a>
						</div>
					</div>	
					<a id="toggle_nav_btn" class="toggle-left-nav-btn inline-block ml-20 pull-left" href="javascript:void(0);"><i class="zmdi zmdi-menu"></i></a>
					<a id="toggle_mobile_search" data-toggle="collapse" data-target="#search_form" class="mobile-only-view" href="javascript:void(0);"><i class="zmdi zmdi-search"></i></a>
					<a id="toggle_mobile_nav" class="mobile-only-view" href="javascript:void(0);"><i class="zmdi zmdi-more"></i></a>
					<form id="search_form" role="search" class="top-nav-search collapse pull-left">
						<div class="input-group">
							<input type="text" name="example-input1-group2" class="form-control" placeholder="Search">
							<span class="input-group-btn">
							<button type="button" class="btn  btn-default"  data-target="#search_form" data-toggle="collapse" aria-label="Close" aria-expanded="true"><i class="zmdi zmdi-search"></i></button>
							</span>
						</div>
					</form>
				</div>
				<div id="mobile_only_nav" class="mobile-only-nav pull-right">
					<ul class="nav navbar-right top-nav pull-right">
						<li>
							<a id="open_right_sidebar" href="#"><i class="zmdi zmdi-settings top-nav-icon"></i></a>
						</li>
						<li class="dropdown app-drp">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="zmdi zmdi-apps top-nav-icon"></i></a>
							<ul class="dropdown-menu app-dropdown" data-dropdown-in="slideInRight" data-dropdown-out="flipOutX">
								<li>
									<div class="app-nicescroll-bar">
										<ul class="app-icon-wrap pa-10">
											<li>
												<a href="weather.html" class="connection-item">
												<i class="zmdi zmdi-cloud-outline txt-info"></i>
												<span class="block">weather</span>
												</a>
											</li>
											<li>
												<a href="inbox.html" class="connection-item">
												<i class="zmdi zmdi-email-open txt-success"></i>
												<span class="block">e-mail</span>
												</a>
											</li>
											<li>
												<a href="calendar.html" class="connection-item">
												<i class="zmdi zmdi-calendar-check txt-primary"></i>
												<span class="block">calendar</span>
												</a>
											</li>
											<li>
												<a href="vector-map.html" class="connection-item">
												<i class="zmdi zmdi-map txt-danger"></i>
												<span class="block">map</span>
												</a>
											</li>
											<li>
												<a href="chats.html" class="connection-item">
												<i class="zmdi zmdi-comment-outline txt-warning"></i>
												<span class="block">chat</span>
												</a>
											</li>
											<li>
												<a href="contact-card.html" class="connection-item">
												<i class="zmdi zmdi-assignment-account"></i>
												<span class="block">contact</span>
												</a>
											</li>
										</ul>
									</div>	
								</li>
								<li>
									<div class="app-box-bottom-wrap">
										<hr class="light-grey-hr ma-0"/>
										<a class="block text-center read-all" href="javascript:void(0)"> more </a>
									</div>
								</li>
							</ul>
						</li>
						<li class="dropdown full-width-drp">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="zmdi zmdi-more-vert top-nav-icon"></i></a>
							<ul class="dropdown-menu mega-menu pa-0" data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
								<li class="product-nicescroll-bar row">
									<ul class="pa-20">
										<li class="col-md-3 col-xs-6 col-menu-list">
											<a href="javascript:void(0);"><div class="pull-left"><i class="zmdi zmdi-landscape mr-20"></i><span class="right-nav-text">Dashboard</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
											<hr class="light-grey-hr ma-0"/>
											<ul>
												<li>
													<a href="index.do">Analytical</a>
												</li>
												<li>
													<a href="index2.html">Demographic</a>
												</li>
												<li>
													<a href="index3.html">Project</a>
												</li>
												<li>
													<a href="index4.html">Hospital</a>
												</li>
												<li>
													<a href="index5.html">HRM</a>
												</li>
												<li>
													<a href="index6.html">Real Estate</a>
												</li>
												<li>
													<a href="profile.html">profile</a>
												</li>
											</ul>
										</li>
										<li class="col-md-3 col-xs-6 col-menu-list">
											<a href="javascript:void(0);">
												<div class="pull-left">
													<i class="zmdi zmdi-shopping-basket mr-20"></i><span class="right-nav-text">E-Commerce</span>
												</div>	
												<div class="pull-right"><span class="label label-primary">hot</span>
												</div>
												<div class="clearfix"></div>
											</a>
											<hr class="light-grey-hr ma-0"/>
											<ul>
												<li>
													<a href="e-commerce.html">Dashboard</a>
												</li>
												<li>
													<a href="product.html">Products</a>
												</li>
												<li>
													<a href="product-detail.html">Product Detail</a>
												</li>
												<li>
													<a href="add-products.html">Add Product</a>
												</li>
												<li>
													<a href="product-orders.html">Orders</a>
												</li>
												<li>
													<a href="product-cart.html">Cart</a>
												</li>
												<li>
													<a href="product-checkout.html">Checkout</a>
												</li>
											</ul>
										</li>
										<li class="col-md-6 col-xs-12 preview-carousel">
											<a href="javascript:void(0);"><div class="pull-left"><span class="right-nav-text">latest products</span></div><div class="clearfix"></div></a>
											<hr class="light-grey-hr ma-0"/>
											<div class="product-carousel owl-carousel owl-theme text-center">
												<a href="#">
													<img src="dist/img/chair.jpg" alt="chair">
													<span>Circle chair</span>
												</a>
												<a href="#">
													<img src="dist/img/chair2.jpg" alt="chair">
													<span>square chair</span>
												</a>
												<a href="#">
													<img src="dist/img/chair3.jpg" alt="chair">
													<span>semi circle chair</span>
												</a>
												<a href="#">
													<img src="dist/img/chair4.jpg" alt="chair">
													<span>wooden chair</span>
												</a>
												<a href="#">
													<img src="dist/img/chair2.jpg" alt="chair">
													<span>square chair</span>
												</a>								
											</div>
										</li>
									</ul>
								</li>	
							</ul>
						</li>
						<li class="dropdown alert-drp">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="zmdi zmdi-notifications top-nav-icon"></i><span class="top-nav-icon-badge">5</span></a>
							<ul  class="dropdown-menu alert-dropdown" data-dropdown-in="bounceIn" data-dropdown-out="bounceOut">
								<li>
									<div class="notification-box-head-wrap">
										<span class="notification-box-head pull-left inline-block">notifications</span>
										<a class="txt-danger pull-right clear-notifications inline-block" href="javascript:void(0)"> clear all </a>
										<div class="clearfix"></div>
										<hr class="light-grey-hr ma-0"/>
									</div>
								</li>
								<li>
									<div class="streamline message-nicescroll-bar">
										<div class="sl-item">
											<a href="javascript:void(0)">
												<div class="icon bg-green">
													<i class="zmdi zmdi-flag"></i>
												</div>
												<div class="sl-content">
													<span class="inline-block capitalize-font  pull-left truncate head-notifications">
													New subscription created</span>
													<span class="inline-block font-11  pull-right notifications-time">2pm</span>
													<div class="clearfix"></div>
													<p class="truncate">Your customer subscribed for the basic plan. The customer will pay $25 per month.</p>
												</div>
											</a>	
										</div>
										<hr class="light-grey-hr ma-0"/>
										<div class="sl-item">
											<a href="javascript:void(0)">
												<div class="icon bg-yellow">
													<i class="zmdi zmdi-trending-down"></i>
												</div>
												<div class="sl-content">
													<span class="inline-block capitalize-font  pull-left truncate head-notifications txt-warning">Server #2 not responding</span>
													<span class="inline-block font-11 pull-right notifications-time">1pm</span>
													<div class="clearfix"></div>
													<p class="truncate">Some technical error occurred needs to be resolved.</p>
												</div>
											</a>	
										</div>
										<hr class="light-grey-hr ma-0"/>
										<div class="sl-item">
											<a href="javascript:void(0)">
												<div class="icon bg-blue">
													<i class="zmdi zmdi-email"></i>
												</div>
												<div class="sl-content">
													<span class="inline-block capitalize-font  pull-left truncate head-notifications">2 new messages</span>
													<span class="inline-block font-11  pull-right notifications-time">4pm</span>
													<div class="clearfix"></div>
													<p class="truncate"> The last payment for your G Suite Basic subscription failed.</p>
												</div>
											</a>	
										</div>
										<hr class="light-grey-hr ma-0"/>
										<div class="sl-item">
											<a href="javascript:void(0)">
												<div class="sl-avatar">
													<img class="img-responsive" src="dist/img/avatar.jpg" alt="avatar"/>
												</div>
												<div class="sl-content">
													<span class="inline-block capitalize-font  pull-left truncate head-notifications">Sandy Doe</span>
													<span class="inline-block font-11  pull-right notifications-time">1pm</span>
													<div class="clearfix"></div>
													<p class="truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
												</div>
											</a>	
										</div>
										<hr class="light-grey-hr ma-0"/>
										<div class="sl-item">
											<a href="javascript:void(0)">
												<div class="icon bg-red">
													<i class="zmdi zmdi-storage"></i>
												</div>
												<div class="sl-content">
													<span class="inline-block capitalize-font  pull-left truncate head-notifications txt-danger">99% server space occupied.</span>
													<span class="inline-block font-11  pull-right notifications-time">1pm</span>
													<div class="clearfix"></div>
													<p class="truncate">consectetur, adipisci velit.</p>
												</div>
											</a>	
										</div>
									</div>
								</li>
								<li>
									<div class="notification-box-bottom-wrap">
										<hr class="light-grey-hr ma-0"/>
										<a class="block text-center read-all" href="javascript:void(0)"> read all </a>
										<div class="clearfix"></div>
									</div>
								</li>
							</ul>
						</li>
						<li class="dropdown auth-drp">
							<a href="#" class="dropdown-toggle pr-0" data-toggle="dropdown">
							<c:if test="${empty manager.profileimg}">
								<img src="dist/img/user1.png" alt="user_auth" class="user-auth-img img-circle" id="upload_file3_img"/>
							</c:if>
							<c:if test="${not empty manager.profileimg}">
								<c:set var="flag" value="0"></c:set>
								<c:forEach items="${manager.profileimg}" var="pf">
									<c:if test="${pf.pro_file_img_type==1}">
										<img src="/pro_head_portrait/${pf.pro_file_img_path }" alt="user_auth" class="user-auth-img img-circle" id="upload_file3_img"/>
										<input type="hidden" value="${flag=1 }"> 
									</c:if>
								</c:forEach>
								<c:if test="${flag==0}">
									<img src="dist/img/user1.png" alt="user_auth" class="user-auth-img img-circle" id="upload_file3_img"/>
								</c:if>
							</c:if>
							<span class="user-online-status"></span>
						</a>
						<ul class="dropdown-menu user-auth-dropdown" data-dropdown-in="flipInX" data-dropdown-out="flipOutX">
							<li>
								<a href="profile.do"><i class="zmdi zmdi-account"></i><span>个人信息</span></a>
							</li>
							<li>
								<a href="#"><i class="zmdi zmdi-card"></i><span>我的账单</span></a>
							</li>
							<li>
								<a href="#"><i class="zmdi zmdi-email"></i><span>收件箱</span></a>
							</li>
							<li>
								<a href="#"><i class="zmdi zmdi-settings"></i><span>设置</span></a>
							</li>
							<li class="divider"></li>
							<li class="sub-menu show-on-hover">
								<a href="#" class="dropdown-toggle pr-0 level-2-drp"><i class="zmdi zmdi-check text-success"></i> 在线</a>
								<ul class="dropdown-menu open-left-side">
									<li>
										<a href="#"><i class="zmdi zmdi-check text-success"></i><span>在线</span></a>
									</li>
									<li>
										<a href="#"><i class="zmdi zmdi-circle-o text-warning"></i><span>忙碌</span></a>
									</li>
									<li>
										<a href="#"><i class="zmdi zmdi-minus-circle-outline text-danger"></i><span>请勿打扰</span></a>
									</li>
								</ul>	
							</li>
							<li class="divider"></li>
							<li>
								<a href="logout.do"><i class="zmdi zmdi-power"></i><span>注销</span></a>
							</li>
						</ul>
						</li>
					</ul>
				</div>	
			</nav>
			<!-- /Top Menu Items -->
			
			<!-- Left Sidebar Menu -->
			<div class="fixed-sidebar-left">
				<ul class="nav navbar-nav side-nav nicescroll-bar">
					<li class="navigation-header">
						<span>门店管理</span> 
						<i class="zmdi zmdi-more"></i>
					</li>
					<li>
						<a class="active" href="javascript:void(0);" data-toggle="collapse" data-target="#dashboard_dr"><div class="pull-left"><i class="zmdi zmdi-landscape mr-20"></i><span class="right-nav-text">聊天室</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
						<ul id="dashboard_dr" class="collapse collapse-level-1">
							<li>
								<a class="active-page" href="chats.do">聊天</a>
							</li>
							<li>
								<a href="contact_card.do">我的联系人</a>
							</li>
						</ul>
					</li>
					<li><hr class="light-grey-hr mb-10"/></li>
					<li class="navigation-header">
						<span>会员</span> 
						<i class="zmdi zmdi-more"></i>
					</li>
					<li>
						<a href="javascript:void(0);" data-toggle="collapse" data-target="#ui_dr"><div class="pull-left"><i class="zmdi zmdi-smartphone-setup mr-20"></i><span class="right-nav-text">会员卡管理</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
						<ul id="ui_dr" class="collapse collapse-level-1 two-col-list">
							<li>
								<a href="create_card.do">会员卡创建</a>
							</li>
							<li>
								<a href="putin_membercard.do">会员卡管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:void(0);" data-toggle="collapse" data-target="#form_dr"><div class="pull-left"><i class="zmdi zmdi-edit mr-20"></i><span class="right-nav-text">卡券管理</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
						<ul id="form_dr" class="collapse collapse-level-1 two-col-list">
							<li>
								<a href="create_card.do">卡券创建</a>
							</li>
							<li>
								<a href="putin_membercard.do">卡券管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:void(0);" data-toggle="collapse" data-target="#chart_dr"><div class="pull-left"><i class="zmdi zmdi-chart-donut mr-20"></i><span class="right-nav-text">会员管理</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
						<ul id="chart_dr" class="collapse collapse-level-1 two-col-list">
							<li>
								<a href="inquire_member.do">会员信息查询</a>
							</li>
						</ul>
					</li>
					<li><hr class="light-grey-hr mb-10"/></li>
					<li class="navigation-header">
						<span>个人信息维护</span> 
						<i class="zmdi zmdi-more"></i>
					</li>
					<li>
						<a href="javascript:void(0);" data-toggle="collapse" data-target="#pages_dr"><div class="pull-left"><i class="zmdi zmdi-google-pages mr-20"></i><span class="right-nav-text">个人信息</span></div><div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div><div class="clearfix"></div></a>
						<ul id="pages_dr" class="collapse collapse-level-1 two-col-list">
							<li>
								<a href="profile.do">个人信息查询</a>
							</li>
							<li>
								<a href="reset_password.do">密码修改</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="locked.do"><div class="pull-left"><i class="zmdi zmdi-book mr-20"></i><span class="right-nav-text">系统锁定</span></div><div class="clearfix"></div></a>
					</li>
				</ul>
			</div>
			<!-- /Left Sidebar Menu -->
			
			<!-- Right Sidebar Menu -->
			<div class="fixed-sidebar-right">
				<ul class="right-sidebar">
					<li>
						<div  class="tab-struct custom-tab-1">
							<ul role="tablist" class="nav nav-tabs" id="right_sidebar_tab">
								<li class="active" role="presentation"><a aria-expanded="true"  data-toggle="tab" role="tab" id="chat_tab_btn" href="#chat_tab">chat</a></li>
								<li role="presentation" class=""><a  data-toggle="tab" id="messages_tab_btn" role="tab" href="#messages_tab" aria-expanded="false">messages</a></li>
								<li role="presentation" class=""><a  data-toggle="tab" id="todo_tab_btn" role="tab" href="#todo_tab" aria-expanded="false">todo</a></li>
							</ul>
							<div class="tab-content" id="right_sidebar_content">
								<div  id="chat_tab" class="tab-pane fade active in" role="tabpanel">
									<div class="chat-cmplt-wrap">
										<div class="chat-box-wrap">
											<div class="add-friend">
												<a href="javascript:void(0)" class="inline-block txt-grey">
													<i class="zmdi zmdi-more"></i>
												</a>	
												<span class="inline-block txt-dark">好友</span>
												<a href="javascript:void(0)" class="inline-block text-right txt-grey"><i class="zmdi zmdi-plus"></i></a>
												<div class="clearfix"></div>
											</div>
											<form role="search" class="chat-search pl-15 pr-15 pb-15">
												<div class="input-group">
													<input type="text" id="example-input1-group21" name="example-input1-group2" class="form-control" placeholder="Search" oninput="onSearch()">
													<span class="input-group-btn">
													<button type="button" class="btn  btn-default"><i class="zmdi zmdi-search"></i></button>
													</span>
												</div>
											</form>
											<div id="chat_list_scroll">
												<div class="nicescroll-bar">
													<input type="hidden" id="uname" name="uname" value="Manager_${manager.manager_tel }">
													<input type="hidden" id="table_name_sender" name="table_name_sender" value="manager_table_${manager.manager_id }">
													<ul class="chat-list-wrap" id="chat_list_ul">
														<c:forEach items="${manager_not }" var="m_not" varStatus="num">
															<li class="chat-list">
																<div class="chat-body" id="user_first_${num.index }">
																	<a href="javascript:void(0)" onclick="chat_select(${m_not.manager_id },${m_not.manager_tel })">
																		<div class="chat-data">
																			<c:if test="${empty m_not.profileimg}">
																				<img class="user-img img-circle"  src="dist/img/user.png" alt="user"/>
																			</c:if>
																			<c:forEach items="${m_not.profileimg }" var="pf">
																				<c:if test="${empty pf.pro_file_img_path && pf.pro_file_img_type==1}">
																					<img class="user-img img-circle"  src="dist/img/user.png" alt="user"/>
																				</c:if>
																				<c:if test="${not empty pf.pro_file_img_path && pf.pro_file_img_type==1}">
																					<img class="user-img img-circle"  src="/pro_head_portrait/${pf.pro_file_img_path }" alt="user"/>
																				</c:if>
																			</c:forEach>
																			<div class="user-data">
																				<input type="hidden" id="manager_name${m_not.manager_id }" name="manager_name${m_not.manager_id }" value = "Manager_${m_not.manager_tel }"> 
																				<span class="name block capitalize-font">${m_not.manager_name }</span>
																				<span class="time block truncate txt-grey" id="span_finally_${m_not.manager_id }">${m_not.manager_context_finally }</span>
																			</div>
																			<div class="clearfix" id="chat_data_f_${m_not.manager_id }">
																				<c:if test="${m_not.manager_context_num>0 }">
																					<div class="status away"></div>
																				</c:if>
																			</div>
																			<div class="clearfix"></div>
																		</div>
																	</a>
																</div>
																<div id="user_last_${num.index }" style="display: none">${m_not.manager_name }</div>
															</li>
														</c:forEach>
													</ul>
												</div>
											</div>
										</div>
										<div class="recent-chat-box-wrap">
											<div class="recent-chat-wrap" id="index_div">
												<div class="panel-heading ma-0">
													<div class="goto-back">
														<a  id="goto_back" href="javascript:void(0)" class="inline-block txt-grey">
															<i class="zmdi zmdi-chevron-left"></i>
														</a>	
														<div id="u_nick"><span class="inline-block txt-dark">&nbsp;</span></div>
														<a href="javascript:void(0)" class="inline-block text-right txt-grey"><i class="zmdi zmdi-more"></i></a>
														<div class="clearfix"></div>
													</div>
												</div>
												<div class="panel-wrapper collapse in">
													<div class="panel-body pa-0">
														<div class="chat-content">
															<ul class="nicescroll-bar pt-20" id="chat-content-my">
																
															</ul>
														</div>
														<div id="we_chats"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
									
								<div id="messages_tab" class="tab-pane fade" role="tabpanel">
									<div class="message-box-wrap">
										<div class="msg-search">
											<a href="javascript:void(0)" class="inline-block txt-grey">
												<i class="zmdi zmdi-more"></i>
											</a>	
											<span class="inline-block txt-dark">messages</span>
											<a href="javascript:void(0)" class="inline-block text-right txt-grey"><i class="zmdi zmdi-search"></i></a>
											<div class="clearfix"></div>
										</div>
										<div class="set-height-wrap">
											<div class="streamline message-box nicescroll-bar">
												<a href="javascript:void(0)">
													<div class="sl-item unread-message">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Clay Masse</span>
															<span class="inline-block font-11  pull-right message-time">12:28 AM</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Themeforest message sent via your envato market profile</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsu messm quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user1.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Evie Ono</span>
															<span class="inline-block font-11  pull-right message-time">1 Feb</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Pogody theme support</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user2.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Madalyn Rascon</span>
															<span class="inline-block font-11  pull-right message-time">31 Jan</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Congratulations from design nominees</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item unread-message">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user3.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Ezequiel Merideth</span>
															<span class="inline-block font-11  pull-right message-time">29 Jan</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Themeforest item support message</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item unread-message">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user4.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Jonnie Metoyer</span>
															<span class="inline-block font-11  pull-right message-time">27 Jan</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Help with beavis contact form</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Priscila Shy</span>
															<span class="inline-block font-11  pull-right message-time">19 Jan</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject">Your uploaded theme is been selected</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
												<a href="javascript:void(0)">
													<div class="sl-item">
														<div class="sl-avatar avatar avatar-sm avatar-circle">
															<img class="img-responsive img-circle" src="dist/img/user1.png" alt="avatar"/>
														</div>
														<div class="sl-content">
															<span class="inline-block capitalize-font   pull-left message-per">Linda Stack</span>
															<span class="inline-block font-11  pull-right message-time">13 Jan</span>
															<div class="clearfix"></div>
															<span class=" truncate message-subject"> A new rating has been received</span>
															<p class="txt-grey truncate">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</p>
														</div>
													</div>
												</a>
											</div>
										</div>
									</div>
								</div>
								<div  id="todo_tab" class="tab-pane fade" role="tabpanel">
									<div class="todo-box-wrap">
										<div class="add-todo">
											<a href="javascript:void(0)" class="inline-block txt-grey">
												<i class="zmdi zmdi-more"></i>
											</a>	
											<span class="inline-block txt-dark">todo list</span>
											<a href="javascript:void(0)" class="inline-block text-right txt-grey"><i class="zmdi zmdi-plus"></i></a>
											<div class="clearfix"></div>
										</div>
										<div class="set-height-wrap">
											<!-- Todo-List -->
											<ul class="todo-list nicescroll-bar">
												<li class="todo-item">
													<div class="checkbox checkbox-default">
														<input type="checkbox" id="checkbox01"/>
														<label for="checkbox01">Record The First Episode</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
												<li class="todo-item">
													<div class="checkbox checkbox-pink">
														<input type="checkbox" id="checkbox02"/>
														<label for="checkbox02">Prepare The Conference Schedule</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
												<li class="todo-item">
													<div class="checkbox checkbox-warning">
														<input type="checkbox" id="checkbox03" checked/>
														<label for="checkbox03">Decide The Live Discussion Time</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
												<li class="todo-item">
													<div class="checkbox checkbox-success">
														<input type="checkbox" id="checkbox04" checked/>
														<label for="checkbox04">Prepare For The Next Project</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
												<li class="todo-item">
													<div class="checkbox checkbox-danger">
														<input type="checkbox" id="checkbox05" checked/>
														<label for="checkbox05">Finish Up AngularJs Tutorial</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
												<li class="todo-item">
													<div class="checkbox checkbox-purple">
														<input type="checkbox" id="checkbox06" checked/>
														<label for="checkbox06">Finish Infinity Project</label>
													</div>
												</li>
												<li>
													<hr class="light-grey-hr"/>
												</li>
											</ul>
											<!-- /Todo-List -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<!-- /Right Sidebar Menu -->
			
			
			
			<!-- Main Content -->
			<div class="page-wrapper">
				<div class="container-fluid">
					<!-- Title -->
					<div class="row heading-bg">
						<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						  <h5 class="txt-dark">创建会员卡</h5>
						</div>
						<!-- Breadcrumb -->
						<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						  <ol class="breadcrumb">
							<li><a href="javascript:void(0);">会员管理</a></li>
							<li><a href="javascript:void(0);"><span>卡券创建</span></a></li>
							<li class="active"><span>创建会员卡</span></li>
						  </ol>
						</div>
						<!-- /Breadcrumb -->
					</div>
					<!-- /Title -->
					
					<!-- Row -->
					<div class="row">
						<div class="col-sm-12">
							<div class="panel panel-default card-view">
								<div class="panel-wrapper collapse in">
									<div class="panel-body">
										<div class="form-wrap">
											<form id="myFrom">
												<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-info-outline mr-10"></i></a>必填字段</h6>
												<hr class="light-grey-hr"/>
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">商户名字</label>
															<input type="text" id="brand_name" name="brand_name" class="form-control" placeholder="商户名字,字数上限为12个汉字。" required="required" maxlength="12">
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">卡券名</label>
															<input type="text" id="title" name="title" class="form-control" placeholder="卡券名，字数上限为9个汉字 (建议涵盖卡券属性、服务及金额)。" required="required" maxlength="9">
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">是否显示积分</label>  <a href="javascript:void(0);"><i class="icon-question" data-toggle="modal" data-target="#myModal"></i></a>
															<div class="radio-list">
																<div class="radio-inline pl-0">
																	<div class="radio radio-info">
																		<input type="radio" name="supply_bonus" id="radio1_supply_bonus" value="true" checked="checked">
																		<label for="radio1">显示</label>
																	</div>
																</div>
																<div class="radio-inline">
																	<div class="radio radio-info">
																		<input type="radio" name="supply_bonus" id="radio2_supply_bonus" value="false">
																		<label for="radio2">不显示</label>
																	</div>
																</div>
															</div>
														</div>
														<!-- sample modal content -->
														<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																		<h5 class="modal-title" id="myModalLabel">说明</h5>
																	</div>
																	<div class="modal-body">
																		<h5 class="mb-15">会员卡上是否显示积分，选择"显示"或"不显示"</h5>
																		<p>如选择"显示"，积分相关字段均为必填，若设置为"显示"则后续不可以被关闭。</p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
														<!-- /.modal -->
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">是否支持储值</label>  <a href="javascript:void(0);"><i class="icon-question" data-toggle="modal" data-target="#myModal_"></i></a>
															<div class="radio-list">
																<div class="radio-inline pl-0">
																	<div class="radio radio-info">
																		<input type="radio" name="supply_balance" id="radio1_supply_balance" value="true" checked="checked">
																		<label for="radio1">支持</label>
																	</div>
																</div>
																<div class="radio-inline">
																	<div class="radio radio-info">
																		<input type="radio" name="supply_balance" id="radio2_supply_balance" value="false">
																		<label for="radio2">不支持</label>
																	</div>
																</div>
															</div>
														</div>
														<!-- sample modal content -->
														<div id="myModal_" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																		<h5 class="modal-title" id="myModalLabel">说明</h5>
																	</div>
																	<div class="modal-body">
																		<h5 class="mb-15">会员卡是否支持储值，选择"支持"或"不支持"</h5>
																		<p>如选择"支持"，储值相关字段均为必填若设置为"支持"则后续不可以被关闭。</p>
																		<p>该字段须开通储值功能后方可使用， 详情见：<a href="javascript:void(0);">《获取特殊权限》</a></p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
														<!-- /.modal -->
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">是否自动激活</label>  <a href="javascript:void(0);"><i class="icon-question" data-toggle="modal" data-target="#myModalAutoActivate"></i></a>
															<div class="radio-list">
																<div class="radio-inline pl-0">
																	<div class="radio radio-info">
																		<input type="radio" name="auto_activate" id="radio1_auto_activate" value="true" checked="checked">
																		<label for="radio1">自动激活</label>
																	</div>
																</div>
																<div class="radio-inline">
																	<div class="radio radio-info">
																		<input type="radio" name="auto_activate" id="radio2_auto_activate" value="false">
																		<label for="radio2">非自动激活</label>
																	</div>
																</div>
															</div>
														</div>
														<!-- sample modal content -->
														<div id="myModalAutoActivate" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																		<h5 class="modal-title" id="myModalLabel">说明</h5>
																	</div>
																	<div class="modal-body">
																		<h5 class="mb-15">会员卡是否自动激活，选择"自动激活"或"非自动激活"</h5>
																		<p>当选择"自动激活"时用户领取会员卡后系统自动将其激活，无需点击"激活会员卡" 。</p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
														<!-- /.modal -->
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">是否支持一键开卡</label>  <a href="javascript:void(0);"><i class="icon-question" data-toggle="modal" data-target="#myModalWxActivate"></i></a>
															<div class="radio-list">
																<div class="radio-inline pl-0">
																	<div class="radio radio-info">
																		<input type="radio" name="wx_activate" id="radio1_wx_activate" value="true">
																		<label for="radio1">支持</label>
																	</div>
																</div>
																<div class="radio-inline">
																	<div class="radio radio-info">
																		<input type="radio" name="wx_activate" id="radio2_wx_activate" value="false" checked="checked">
																		<label for="radio2">不支持</label>
																	</div>
																</div>
															</div>
														</div>
														<!-- sample modal content -->
														<div id="myModalWxActivate" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																		<h5 class="modal-title" id="myModalLabel">说明</h5>
																	</div>
																	<div class="modal-body">
																		<h5 class="mb-15">会员卡是否支持一键开卡，选择"支持"或"不支持"</h5>
																		<p>如选择"支持"后，需设置开卡项方可生效，详情见<a href="javascript:void(0);">《一键开卡》</a></p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
														<!-- /.modal -->
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<!-- row -->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">卡券背景颜色</label>  <a href="javascript:void(0);"><i class="icon-question" data-toggle="modal" data-target=".bs-example-modal-lg"></i></a>
															<select class="form-control" data-placeholder="Choose a Category" tabindex="1" id="color" name="color">
																<option value="Color010">Color010</option>
																<option value="Color020">Color020</option>
																<option value="Color030">Color030</option>
																<option value="Color040">Color040</option>
																<option value="Color050">Color050</option>
																<option value="Color060">Color060</option>
																<option value="Color070">Color070</option>
																<option value="Color080">Color080</option>
																<option value="Color081">Color081</option>
																<option value="Color082">Color082</option>
																<option value="Color090">Color090</option>
																<option value="Color100">Color100</option>
																<option value="Color101">Color101</option>
																<option value="Color102">Color102</option>
															</select>
														</div>
														<!-- sample modal content -->
														<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
															<div class="modal-dialog modal-lg">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																		<h5 class="modal-title" id="myLargeModalLabel">以下十种色值的共计十四种色值供您选择</h5>
																	</div>
																	<div class="modal-body">
																		<img alt="卡券颜色详情图片" src="dist/img/wxcolor.jpg" style="margin-left: 2%;">
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-danger text-left" data-dismiss="modal">关闭</button>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
														<!-- /.modal -->
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">Code展示类型</label>
															<select class="form-control" data-placeholder="Choose a Category" tabindex="1" name="code_type" id="code_type">
																<option value="2">二维码</option>
																<option value="1">一维码  </option>
																<option value="0">文本</option>
															</select>
														</div>
													</div>
												</div>
												<!--/row-->
												<!--row-->
												<div class="row">	
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">库存</label>
															<input type="number" id="quantity" name="quantity" class="form-control" placeholder="卡券库存的数量，不支持填写0，上限为100000000。" required="required" max="100000000" min="1">
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">时间类型 </label>
															<select class="form-control" data-placeholder="Choose a Category" tabindex="1" id="select_time" name="select_time">
																<option value="DATE_TYPE_PERMANENT">永久有效类型</option>
																<option value="1">固定时长有效类型</option>
																<option value="2">固定日期有效类型</option>
															</select>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<div id="setTime" style="display: none">
													<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-comment-text mr-10"></i></a>时间设置</h6>
													<hr class="light-grey-hr"/>
													<div class="row" >
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label mb-10">起用时间</label>
																<input type="date" id="begin_timestamp" name="begin_timestamp" class="form-control" placeholder="起用时间">
															</div>
														</div>
														<!--/span-->
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label mb-10">结束时间</label>
																<input type="date" id="end_timestamp" name="end_timestamp" class="form-control" placeholder="结束时间">
															</div>
														</div>
														<!--/span-->
													</div>
													<hr class="light-grey-hr"/>
												</div>
												<!--/row-->
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">卡券使用提醒</label>
															<input type="text" id="notice" name="notice" class="form-control" placeholder="卡券使用提醒，字数上限为16个汉字。" required="required" maxlength="16">
														</div>
													</div>
													<!--/span-->
													<!-- <div class="col-md-6" style="display: block" id="div_activate_url">
														<div class="form-group">
															<label class="control-label mb-10">激活会员卡的url</label>
															<input type="url" id="activate_url" name="activate_url" class="form-control" placeholder="激活会员卡的url。" required="required">
														</div>
													</div> -->
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">卡券使用说明</label>
															<textarea rows="6" cols="" class="form-control" id="description" name="description" placeholder="卡券使用说明，字数上限为1024个汉字。" required="required" maxlength="1024"></textarea>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">会员卡特权说明</label>
															<textarea rows="6" cols="" class="form-control" id="prerogative" name="prerogative" placeholder="会员卡特权说明,限制1024汉字。" required="required" maxlength="1024"></textarea>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-comment-text mr-10"></i></a>自定义会员信息类目，会员卡激活后显示</h6>
												<hr class="light-grey-hr"/>
												<!--row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">入口名称</label>
															<input type="text" id="custom_cell_name" name="custom_cell_name" class="form-control" placeholder="入口名称。" required="required">
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">入口右侧提示语</label>
															<input type="text" id="custom_cell_tips" name="custom_cell_tips" class="form-control" placeholder="入口右侧提示语，6个汉字内。" required="required" maxlength="6">
														</div>
													</div>
													<!--/span-->
													<!-- <div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">入口跳转链接</label>
															<input type="url" id="custom_cell_url" name="custom_cell_url" class="form-control" placeholder="入口跳转链接。例如：http://www.baidu.com" required="required">
														</div>
													</div> -->
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<div class="row" id="setWxActivate" style="display: none">
													<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-comment-text mr-10"></i></a>设置一键激活的开卡字段</h6>
													<hr class="light-grey-hr"/>
													<div class="col-md-6">
														<div class="form-group">
														<label class="control-label mb-10">选择要添加的用户必填字段(至多5个)</label>
														<ul>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_mobile" name="required_form"  value="USER_FORM_INFO_FLAG_MOBILE" onclick="doCheck(this)" class="checkbox">
																	<label for="required_form_mobile">手机号</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_sex" name="required_form"  value="USER_FORM_INFO_FLAG_SEX" onclick="doCheck(this)">
																	<label for="required_form_sex">性别</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_name" name="required_form"  value="USER_FORM_INFO_FLAG_NAME" onclick="doCheck(this)">
																	<label for="required_form_name">姓名</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_birthday" name="required_form"  value="USER_FORM_INFO_FLAG_BIRTHDAY" onclick="doCheck(this)">
																	<label for="required_form_birthday">生日</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_idcard" name="required_form"  value="USER_FORM_INFO_FLAG_IDCARD" onclick="doCheck(this)">
																	<label for="required_form_idcard">身份证</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_email" name="required_form"  value="USER_FORM_INFO_FLAG_EMAIL" onclick="doCheck(this)">
																	<label for="required_form_email">邮箱</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="required_form_location" name="required_form"  value="USER_FORM_INFO_FLAG_LOCATION" onclick="doCheck(this)">
																	<label for="required_form_location">详细地址</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="required_form_industry" name="required_form"  value="USER_FORM_INFO_FLAG_INDUSTRY" onclick="doCheck(this)">
																	<label for="required_form_industry">行业</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="required_form_industry_select" name="required_form_industry_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="required_form_industry_div" style="visibility:hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="required_form_industry_input" name="required_form_industry_input"/>
																		</div>
																	</div>
																</div>
																<hr class="light-grey-hr" style="margin-top: 4.1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="required_form_income" name="required_form"  value="USER_FORM_INFO_FLAG_INCOME" onclick="doCheck(this)">
																	<label for="required_form_income">收入</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="required_form_income_select" name="required_form_income_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="required_form_income_div" style="visibility: hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="required_form_income_input" name="required_form_income_input"/>
																		</div>
																	</div>
																</div>
																<hr class="light-grey-hr" style="margin-top: 4.1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="required_form_habit" name="required_form"  value="USER_FORM_INFO_FLAG_HABIT" onclick="doCheck(this)">
																	<label for="required_form_habit">兴趣爱好</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="required_form_habit_select" name="required_form_habit_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="required_form_habit_div" style="visibility: hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="required_form_habit_input" name="required_form_habit_input"/>
																		</div>
																	</div>
																</div>
															</li>
														</ul>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
														<label class="control-label mb-10">选择要添加的用户选填字段(至多5个)</label>
														<ul>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_mobile" name="optional_form"  value="USER_FORM_INFO_FLAG_MOBILE" onclick="doCheck_(this)" class="checkbox">
																	<label for="optional_form_mobile">手机号</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_sex" name="optional_form"  value="USER_FORM_INFO_FLAG_SEX" onclick="doCheck_(this)">
																	<label for="optional_form_sex">性别</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_name" name="optional_form"  value="USER_FORM_INFO_FLAG_NAME" onclick="doCheck_(this)">
																	<label for="optional_form_name">姓名</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_birthday" name="optional_form"  value="USER_FORM_INFO_FLAG_BIRTHDAY" onclick="doCheck_(this)">
																	<label for="optional_form_birthday">生日</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_idcard" name="optional_form"  value="USER_FORM_INFO_FLAG_IDCARD" onclick="doCheck_(this)">
																	<label for="optional_form_idcard">身份证</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_email" name="optional_form"  value="USER_FORM_INFO_FLAG_EMAIL" onclick="doCheck_(this)">
																	<label for="optional_form_email">邮箱</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info">
																	<input type="checkbox" id="optional_form_location" name="optional_form"  value="USER_FORM_INFO_FLAG_LOCATION" onclick="doCheck_(this)">
																	<label for="optional_form_location">详细地址</label>
																</div>
																<hr class="light-grey-hr" style="margin-top: 1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="optional_form_industry" name="optional_form"  value="USER_FORM_INFO_FLAG_INDUSTRY" onclick="doCheck_(this)">
																	<label for="optional_form_industry">行业</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="optional_form_industry_select" name="optional_form_industry_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="optional_form_industry_div" style="visibility: hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="optional_form_industry_input" name="optional_form_industry_input "/>
																		</div>
																	</div>
																</div>
																<hr class="light-grey-hr" style="margin-top: 4.1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="optional_form_income" name="optional_form"  value="USER_FORM_INFO_FLAG_INCOME" onclick="doCheck_(this)">
																	<label for="optional_form_income">收入</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="optional_form_income_select" name="optional_form_income_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="optional_form_income_div" style="visibility: hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="optional_form_income_input" name="optional_form_income_input"/>
																		</div>
																	</div>
																</div>
																<hr class="light-grey-hr" style="margin-top: 4.1% !important;margin-bottom: 1% !important;"/>
															</li>
															<li>
																<div class="checkbox checkbox-info col-sm-2">
																	<input type="checkbox" id="optional_form_habit" name="optional_form"  value="USER_FORM_INFO_FLAG_HABIT" onclick="doCheck_(this)">
																	<label for="optional_form_habit">兴趣爱好</label>
																</div>
																<div class="col-md-5">
																	<div class="form-group">
																		<select class="selectpicker" data-style="form-control btn-default btn-outline" id="optional_form_habit_select" name="optional_form_habit_select">
																			<option value="">默认样式</option>
																			<option value="FORM_FIELD_RADIO">自定义单选</option>
																			<option value="FORM_FIELD_SELECT">自定义选择项 </option>
																			<option value="FORM_FIELD_CHECK_BOX">自定义多选</option>
																		</select>
																	</div>
																</div>
																<div class="panel-wrapper collapse in" id="optional_form_habit_div" style="visibility: hidden;">
																	<div>
																		<div class="tags-default">
																			<input class="form-control" type="text" value="" data-role="tagsinput" placeholder="添加一个字段后回车，填下一个！" id="optional_form_habit_input" name="optional_form_habit_input"/>
																		</div>
																	</div>
																</div>
															</li>
														</ul>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<!--row-->
												<!-- <div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">Price</label>
															<div class="input-group">
																<div class="input-group-addon"><i class="ti-money"></i></div>
																<input type="text" class="form-control" id="exampleInputuname" placeholder="153">
															</div>
														</div>
													</div>
													/span
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">Discount</label>
															<div class="input-group">
																<div class="input-group-addon"><i class="ti-cut"></i></div>
																<input type="text" class="form-control" id="exampleInputuname_1" placeholder="36%">
															</div>
														</div>
													</div>
													/span
												</div> -->
												<!--/row-->
												<!-- <div class="seprator-block"></div>
												<h6 class="txt-dark capitalize-font"><i class="zmdi zmdi-comment-text mr-10"></i>Product Description</h6>
												<hr class="light-grey-hr"/>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<textarea class="form-control" rows="4" style="resize: none !important;">Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. but the majority have suffered alteration in some form, by injected humour</textarea>
														</div>
													</div>
												</div> -->
												<!--/row-->
												<!-- <div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">Meta Title</label>
															<input type="text" class="form-control">
														</div>
													</div>
													/span
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label mb-10">Meta Keyword</label>
															<input type="text" class="form-control">
														</div>
													</div>
												</div> -->
												<!-- <div class="seprator-block"></div> -->
												<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-collection-image mr-10" data-toggle="modal" data-target="#myModal_logo"></i></a>上传logo</h6>
												<hr class="light-grey-hr"/>
												<div class="row">
													<div class="col-lg-12">
														<div class="col-sm-1 img-upload-wrap">
															<img src="dist/img/big/circle.jpg" alt="user_auth" class="img-responsive img-circle" id="img_logo">
														</div>
														<div class="fileupload btn btn-info btn-anim"><i class="fa fa-upload"></i><span class="btn-text" >上传图片</span>
															<input type="file" class="upload" id="input_logo" name="input_logo" required="required">
														</div>
													</div>
													<!-- sample modal content -->
													<div id="myModal_logo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																	<h5 class="modal-title" id="myModalLabel">说明</h5>
																</div>
																<div class="modal-body">
																	<h5 class="mb-15">上传logo</h5>
																	<p>卡券的商户logo，建议像素为300*300。</p>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
													<!-- /.modal -->
												</div>
												<br/>
												<h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-collection-image mr-10" data-toggle="modal" data-target="#myModal_background"></i></a>上传卡券背景图片</h6>
												<hr class="light-grey-hr"/>
												<div class="row">
													<div class="col-lg-12">
														<div class="col-sm-3 img-upload-wrap">
															<img class="img-responsive img-rounded" src="dist/img/big/img1.jpg" alt="upload_img" id="img_background"> 
														</div>
														<div class="fileupload btn btn-info btn-anim"><i class="fa fa-upload"></i><span class="btn-text">上传图片</span>
															<input type="file" class="upload" id="input_background" name="input_background">
														</div>
													</div>
													<!-- sample modal content -->
													<div id="myModal_background" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																	<h5 class="modal-title" id="myModalLabel">说明</h5>
																</div>
																<div class="modal-body">
																	<h5 class="mb-15">商家自定义会员卡背景图</h5>
																	<p>卡面设计请遵循 微信会员卡自定义背景设计规范 ,像素大小控制在 1000像素*600像素以下</p>
																	<p>注意：上传会员背景图片将不会显示卡券所选颜色。</p>
																	
																	
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
													<!-- /.modal -->
												</div>
												<div class="seprator-block"></div>
												<!-- <h6 class="txt-dark capitalize-font"><a href="javascript:void(0);"><i class="zmdi zmdi-calendar-note mr-10"></i></a>非必填字段</h6>
												<hr class="light-grey-hr"/>
												
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Brand">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Stellar">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Delivery Condition">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Knock Down">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Seat Lock Included">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Yes">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Type">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Office Chair">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Style">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Contemporary & Modern">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Wheels Included">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Yes">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Upholstery Included">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Yes">
														</div>
													</div>
												</div> -->
												<div class="form-actions">
													<button class="btn btn-success btn-icon left-icon mr-10 pull-left" id="MakeSureToCreate" type="submit"> <i class="fa fa-check"></i> <span>创建</span></button>
													<button type="button" class="btn btn-warning pull-left">取消</button>
													<div class="clearfix"></div>
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
				
				<!-- Footer -->
				<footer class="footer container-fluid pl-30 pr-30">
					<div class="row">
						<div class="col-sm-12">
							<p>2017 &copy; Elmer. Pampered by Hencework</p>
						</div>
					</div>
				</footer>
				<!-- /Footer -->
				
			</div>
			<!-- /Main Content -->
		
		</div>
		<!-- /#wrapper -->
		
		<!-- JavaScript -->
		
		<!-- jQuery -->
		<script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
		
		<!-- Bootstrap Core JavaScript -->
		<script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		
		<!-- Sweet-Alert  -->
		<script src="vendors/bower_components/sweetalert/dist/sweetalert.min.js"></script>
		
		<script src="dist/js/sweetalert-data.js"></script>
		
		<!-- Slimscroll JavaScript -->
		<script src="dist/js/jquery.slimscroll.js"></script>
	
		<!-- Fancy Dropdown JS -->
		<script src="dist/js/dropdown-bootstrap-extended.js"></script>
		
		<!-- Owl JavaScript -->
		<script src="vendors/bower_components/owl.carousel/dist/owl.carousel.min.js"></script>
	
		<!-- Switchery JavaScript -->
		<script src="vendors/bower_components/switchery/dist/switchery.min.js"></script>
	
		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>
		
		<!-- Bootstrap Tagsinput JavaScript -->
		<script src="vendors/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
		
		<!-- Bootstrap Select JavaScript -->
		<script src="vendors/bower_components/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
		
		<!-- my js -->
		<script src="dist/videos/js_zy/create_membercard_zy.js"></script>
		<!-- cookie -->
		<script src="dist/js/cookie.js"></script>
		<!-- 聊天 -->
		<script type="text/javascript">
			//路径
			var path = "ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket";
			setCookie("path",path,0.1);
			//发消息的人
			var sender = document.getElementById("uname").value;
			setCookie("sender",sender,0.1);
		</script>
		<script src="dist/js/my-chats.js"></script>
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