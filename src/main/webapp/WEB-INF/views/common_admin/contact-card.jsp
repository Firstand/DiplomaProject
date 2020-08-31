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
		
		<!--alerts CSS -->
		<link href="vendors/bower_components/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
		
		<!-- switchery CSS -->
		<link href="vendors/bower_components/switchery/dist/switchery.min.css" rel="stylesheet" type="text/css"/>
		
		<!-- Custom CSS -->
		<link href="dist/css/style.css" rel="stylesheet" type="text/css">
		
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
							<h5 class="txt-dark">contact cards</h5>
						</div>
						<!-- Breadcrumb -->
						<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
							<ol class="breadcrumb">
								<li><a href="index.do">Dashboard</a></li>
								<li><a href="#"><span>apps</span></a></li>
								<li class="active"><span>contact cards</span></li>
							</ol>
						</div>
						<!-- /Breadcrumb -->
					</div>
					<!-- /Title -->
					
					<!-- Row -->
					<div class="row">
						<c:forEach items="${manager_not }" var="m_not" varStatus="num">
							<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
								<div class="panel panel-primary contact-card card-view">
									<div class="panel-heading">
										<div class="pull-left">
											<div class="pull-left user-img-wrap mr-15">
												<c:if test="${empty m_not.profileimg}">
													<img class="card-user-img img-circle pull-left" src="dist/img/user2.png" alt="user"/>
												</c:if>
												<c:if test="${not empty m_not.profileimg}">
													<c:set var="flag" value="0"></c:set>
													<c:forEach items="${m_not.profileimg}" var="pf">
														<c:if test="${pf.pro_file_img_type==1}">
															<img class="card-user-img img-circle pull-left" src="/pro_head_portrait/${pf.pro_file_img_path }" alt="user"/>
															<input type="hidden" value="${flag=1 }"> 
														</c:if>
													</c:forEach>
													<c:if test="${flag==0}">
														<img class="card-user-img img-circle pull-left" src="dist/img/user2.png" alt="user"/>
													</c:if>
												</c:if>
											</div>
											<div class="pull-left user-detail-wrap">	
												<span class="block card-user-name">
													${m_not.manager_name }
												</span>
												<c:if test="${m_not.manager_type==1 }">
													<span class="block card-user-desn">
														普通管理员
													</span>
												</c:if>
												<c:if test="${m_not.manager_type==2 }">
													<span class="block card-user-desn">
														官方
													</span>
												</c:if>
											</div>
										</div>
										<div class="pull-right">
											<a class="pull-left inline-block mr-15" href="#">
												<i class="zmdi zmdi-edit txt-light"></i>
											</a>
											<a class="pull-left inline-block mr-15" href="#">
												<i class="zmdi zmdi-delete txt-light"></i>
											</a>
											<div class="pull-left inline-block dropdown">
												<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false" role="button"><i class="zmdi zmdi-more-vert txt-light"></i></a>
												<ul class="dropdown-menu bullet dropdown-menu-right"  role="menu">
													<li role="presentation"><a href="javascript:void(0)" role="menuitem"><i class="icon wb-reply" aria-hidden="true"></i>详情</a></li>
													<li role="presentation"><a href="javascript:void(0)" role="menuitem"><i class="icon wb-share" aria-hidden="true"></i>发消息</a></li>
													<li role="presentation"><a href="javascript:void(0)" role="menuitem"><i class="icon wb-trash" aria-hidden="true"></i>更多</a></li>
												</ul>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="panel-wrapper collapse in">
										<div class="panel-body row">
											<div class="user-others-details pl-15 pr-15">
												<div class="mb-15">
													<i class="zmdi zmdi-email-open inline-block mr-10"></i>
													<span class="inline-block txt-dark">${m_not.manager_email }</span>
												</div>
												<div class="mb-15">
													<i class="zmdi zmdi-smartphone inline-block mr-10"></i>
													<span class="inline-block txt-dark">${m_not.manager_tel }</span>
												</div>
												<!-- <div class="mb-15">
													<i class="zmdi zmdi-phone inline-block mr-10"></i>
													<span class="inline-block txt-dark">0203878654</span>
												</div> -->
												<div>	
													<i class="zmdi zmdi zmdi-skype inline-block mr-10"></i>
													<span class="inline-block txt-dark">${m_not.manager_regist_time }</span>
												</div>
											</div>
											<hr class="light-grey-hr mt-20 mb-20"/>
											<div class="emp-detail pl-15 pr-15">
												<div class="mb-5">
													<span class="inline-block capitalize-font mr-5">添加好友时间:</span>
													<span class="txt-dark">${m_not.manager_regist_time }</span>
												</div>
												<div>
													<span class="inline-block capitalize-font mr-5">销售额:</span>
													<span class="txt-dark">$${m_not.district.dis_id-(num.count*20000) }</span>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- Row -->
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
		
		<!-- Slimscroll JavaScript -->
		<script src="dist/js/jquery.slimscroll.js"></script>
	
		<!-- Fancy Dropdown JS -->
		<script src="dist/js/dropdown-bootstrap-extended.js"></script>		
		
		<!-- Owl JavaScript -->
		<script src="vendors/bower_components/owl.carousel/dist/owl.carousel.min.js"></script>
	
		<!-- Switchery JavaScript -->
		<script src="vendors/bower_components/switchery/dist/switchery.min.js"></script>
	
		<!-- Sweet-Alert  -->
		<script src="vendors/bower_components/sweetalert/dist/sweetalert.min.js"></script>
		
		<script src="dist/js/sweetalert-data.js"></script>
	
		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>
		
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