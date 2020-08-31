/** *************Init JS*********************
	
    TABLE OF CONTENTS
	---------------------------
	1.Ready function
	2.Load function
	3.Full height function
	4.elmer function
	5.Chat App function
	6.Resize function
 ** ***************************************/
 
 "use strict"; 
 
/*****Ready function start*****/
$(document).ready(function(){
	elmer();
	$('.preloader-it > .la-anim-1').addClass('la-animate');
});
/*****Ready function end*****/

var lockReconnect = false;//避免重复连接
var path;
var socket;
var tt;
function createWebSocket() {
  try {
	path = getCookie("path");
	socket = new WebSocket(path);
//	alert("创建一个socket连接："+socket);
	console.log("创建一个socket连接："+socket);
    init();
  } catch(e) {
    console.log('发生异常啦！');
    reconnect(path);
  }
}
function init() {
	socket.onclose = function () {
    console.log('链接关闭');
    reconnect(path);
  };
  	socket.onerror = function() {
    console.log('发生异常了');
    reconnect(path);
  };
  	socket.onopen = function () {
    //心跳检测重置
    heartCheck.start();
  };
  	socket.onmessage = function (event) {
    //拿到任何消息都说明当前连接是正常的
//	alert("event.data:"+event.data);
  		console.log("event.data:"+event.data);
	var obj1 = event.data;
    if(obj1!=null&&obj1!=""){
    	var obj = eval("("+event.data+")");
    	addMessage(obj);
//    	alert("消息返回！");
    	console.log("消息返回！");
    }
    else{
    	console.log("接收到回复："+obj1);
//    	alert("接收到回复："+obj1);
    }
    	
    heartCheck.start();
    
  };
}
function reconnect(url) {
  console.log('开始重连，路径为：'+url+"lockReconnect:"+lockReconnect);
  if(lockReconnect) {
    return;
  };
  lockReconnect = true;
  //没连接上会一直重连，设置延迟避免请求过多
  tt && clearTimeout(tt);
  tt = setTimeout(function () {
    createWebSocket(url);
    lockReconnect = false;
  }, 4000);
}
//心跳检测
var heartCheck = {
  timeout: 3000,
  timeoutObj: null,
  serverTimeoutObj: null,
  start: function(){
    console.log('开始！');
    var self = this;
    this.timeoutObj && clearTimeout(this.timeoutObj);
    this.serverTimeoutObj && clearTimeout(this.serverTimeoutObj);
    this.timeoutObj = setTimeout(function(){
      //这里发送一个心跳，后端收到后，返回一个心跳消息，
      console.log('发送一个心跳！');
      var sender = getCookie("sender");
      socket.send('{"sender":"'+sender+'","content":"","flag":"","accepter":"",table_name_sender:"",table_name_accepter:""}');
      self.serverTimeoutObj = setTimeout(function() {
        console.log("连接已经断开！");
       // alert("无法连接到服务器，请检查网络是否正常！");
       /* console.log(socket);*/
        socket.close();
        /*alert("无法连接到服务器，请检查网络是否正常！");*/
        $.toast().reset('all');
		$("body").removeAttr('class');
		$.toast({
            heading: '哎呀！网咋断了？',
            text: '别担心我正在想办法重连！.',
            position: 'top-right',
            loaderBg:'#fec107',
            icon: 'error',
            hideAfter: 3500
        });
        // createWebSocket();
      }, self.timeout);

    }, this.timeout)
  }
}

function addMessage(msg){
	var accepter_id = getCookie("accepter_id");
	//发送者
	var sender = getCookie("sender");
	//接收者
	var accepter = getCookie("accepter");
	var resultMap_4 = getCookie("resultMap_4");
	if(accepter_id!=null&&accepter_id!=""){
		document.getElementById("span_finally_"+accepter_id).innerHTML = msg.content;
	}
	if(!msg.isSelf){
		document.getElementById("chat_data_f_"+accepter_id).innerHTML = "<div class='status offline'></div>";
		var str = '<li class="friend"><div class="friend-msg-wrap">';
		if(resultMap_4!=null&&resultMap_4!=''){
			var obj = eval("("+eval(resultMap_4)+")");
			if(obj.length<1){
				str+='<img src="dist/img/user.png" alt="user" class="user-img img-circle block pull-left" id="upload_file3_img"/>';
			}
			else{
				var flag = 0;
				for(var i=0;i<obj.length;i++){
					if(obj[i].pro_file_img_type==1){
						str+='<img src="/pro_head_portrait/'+obj[i].pro_file_img_path+'" alt="user" class="user-img img-circle block pull-left" id="upload_file3_img"/>';
						flag=1;
    					break;
    				}
    			}
				if(flag==0){
					str+='<img src="dist/img/user.png" alt="user" class="user-img img-circle block pull-left" id="upload_file3_img"/>';
				}
			}
		}
		else{
			str+='<img src="dist/img/user.png" alt="user" class="user-img img-circle block pull-left" id="upload_file3_img"/>';
		}
		$(str+'<div class="msg pull-left"><p>' + msg.content + '</p><div class="msg-per-detail text-right"><span class="msg-time txt-grey">'+msg.date+'</span></div></div><div class="clearfix"></div></div></li>').insertAfter("#chats_div .chat-content  ul li:last-child");//chats.jsp
		$(str+'<div class="msg pull-left"><p>' + msg.content + '</p><div class="msg-per-detail text-right"><span class="msg-time txt-grey">'+msg.date+'</span></div></div><div class="clearfix"></div></div></li>').insertAfter("#profile_div .chat-content  ul li:last-child");
		$(str+'<div class="msg pull-left"><p>' + msg.content + '</p><div class="msg-per-detail text-right"><span class="msg-time txt-grey">'+msg.date+'</span></div></div><div class="clearfix"></div></div></li>').insertAfter("#index_div .chat-content  ul li:last-child");//index.jsp
	}
	else{
		$('<li class="self mb-10"><div class="self-msg-wrap"><div class="msg block pull-right">' + msg.content + '<div class="msg-per-detail mt-5"><span class="msg-time txt-grey">'+msg.date+'</span></div></div></div><div class="clearfix"></div></li>').insertAfter("#chats_div .chat-content  ul li:last-child");
		$('<li class="self mb-10"><div class="self-msg-wrap"><div class="msg block pull-right">' + msg.content + '<div class="msg-per-detail mt-5"><span class="msg-time txt-grey">'+msg.date+'</span></div></div></div><div class="clearfix"></div></li>').insertAfter("#profile_div .chat-content  ul li:last-child");
		$('<li class="self mb-10"><div class="self-msg-wrap"><div class="msg block pull-right">' + msg.content + '<div class="msg-per-detail mt-5"><span class="msg-time txt-grey">'+msg.date+'</span></div></div></div><div class="clearfix"></div></li>').insertAfter("#index_div .chat-content  ul li:last-child");
	}
	var div = document.getElementById('chat-content-my');
	var div1 = document.getElementById('chat-content-my1');
	div.scrollTop = div.scrollHeight;
	div1.scrollTop = div1.scrollHeight;
}

createWebSocket();

/*****Load function start*****/
$(window).load(function(){
	$(".preloader-it").delay(500).fadeOut("slow");
	/*Progress Bar Animation*/
	var progressAnimation = $('.progress-anim');
	if( progressAnimation.length > 0 ){
		for(var i = 0; i < progressAnimation.length; i++){
			var $this = $(progressAnimation[i]);
			$this.waypoint(function() {
			var progressBar = $(".progress-anim .progress-bar");
			for(var i = 0; i < progressBar.length; i++){
				$this = $(progressBar[i]);
				$this.css("width", $this.attr("aria-valuenow") + "%");
			}
			}, {
			  triggerOnce: true,
			  offset: 'bottom-in-view'
			});
		}
	}
});
/*****Load function* end*****/

/***** Full height function start *****/
var setHeightWidth = function () {
	var height = $(window).height();
	var width = $(window).width();
	$('.full-height').css('height', (height));
	$('.page-wrapper').css('min-height', (height));
	
	/*Right Sidebar Scroll Start*/
	if(width<=1007){
		$('#chat_list_scroll').css('height', (height - 270));
		$('.fixed-sidebar-right .chat-content').css('height', (height - 279));
		$('.fixed-sidebar-right .set-height-wrap').css('height', (height - 219));
		
	}
	else {
		$('#chat_list_scroll').css('height', (height - 204));
		$('.fixed-sidebar-right .chat-content').css('height', (height - 213));
		$('.fixed-sidebar-right .set-height-wrap').css('height', (height - 153));
	}	
	/*Right Sidebar Scroll End*/
	
	/*Vertical Tab Height Cal Start*/
	var verticalTab = $(".vertical-tab");
	if( verticalTab.length > 0 ){ 
		for(var i = 0; i < verticalTab.length; i++){
			var $this =$(verticalTab[i]);
			$this.find('ul.nav').css(
			  'min-height', ''
			);
			$this.find('.tab-content').css(
			  'min-height', ''
			);
			height = $this.find('ul.ver-nav-tab').height();
			$this.find('ul.nav').css(
			  'min-height', height + 40
			);
			$this.find('.tab-content').css(
			  'min-height', height + 40
			);
		}
	}
	/*Vertical Tab Height Cal End*/
};
/***** Full height function end *****/

/***** elmer function start *****/
var $wrapper = $(".wrapper");
var elmer = function(){
	
	/*Counter Animation*/
	var counterAnim = $('.counter-anim');
	if( counterAnim.length > 0 ){
		counterAnim.counterUp({ delay: 10,
        time: 1000});
	}
	
	/*Tooltip*/
	if( $('[data-toggle="tooltip"]').length > 0 )
		$('[data-toggle="tooltip"]').tooltip();
	
	/*Popover*/
	if( $('[data-toggle="popover"]').length > 0 )
		$('[data-toggle="popover"]').popover()
	
	
	/*Sidebar Collapse Animation*/
	var sidebarNavCollapse = $('.fixed-sidebar-left .side-nav  li .collapse');
	var sidebarNavAnchor = '.fixed-sidebar-left .side-nav  li a';
	$(document).on("click",sidebarNavAnchor,function (e) {
		if ($(this).attr('aria-expanded') === "false")
				$(this).blur();
		$(sidebarNavCollapse).not($(this).parent().parent()).collapse('hide');
	});
	
	/*Panel Remove*/
	$(document).on('click', '.close-panel', function (e) {
		var effect = $(this).data('effect');
			$(this).closest('.panel')[effect]();
		return false;	
	});
	
	/*Accordion js*/
		$(document).on('show.bs.collapse', '.panel-collapse', function (e) {
		$(this).siblings('.panel-heading').addClass('activestate');
	});
	
	$(document).on('hide.bs.collapse', '.panel-collapse', function (e) {
		$(this).siblings('.panel-heading').removeClass('activestate');
	});
	
	/*Sidebar Navigation*/
	$(document).on('click', '#toggle_nav_btn,#open_right_sidebar,#setting_panel_btn', function (e) {
		$(".dropdown.open > .dropdown-toggle").dropdown("toggle");
		return false;
	});
	$(document).on('click', '#toggle_nav_btn', function (e) {
		$wrapper.removeClass('open-right-sidebar open-setting-panel').toggleClass('slide-nav-toggle');
		return false;
	});
	
	$(document).on('click', '#open_right_sidebar', function (e) {
		$wrapper.toggleClass('open-right-sidebar').removeClass('open-setting-panel');
		return false;
	
	});
	
	$(document).on('click','.product-carousel .owl-nav',function(e){
		return false;
	});
	
	$(document).on('click', 'body', function (e) {
		if($(e.target).closest('.fixed-sidebar-right,.setting-panel').length > 0) {
			return;
		}
		$('body > .wrapper').removeClass('open-right-sidebar open-setting-panel');
		return;
	});
	
	$(document).on('show.bs.dropdown', '.nav.navbar-right.top-nav .dropdown', function (e) {
		$wrapper.removeClass('open-right-sidebar open-setting-panel');
		return;
	});
	
	$(document).on('click', '#setting_panel_btn', function (e) {
		$wrapper.toggleClass('open-setting-panel').removeClass('open-right-sidebar');
		return false;
	});
	$(document).on('click', '#toggle_mobile_nav', function (e) {
		$wrapper.toggleClass('mobile-nav-open').removeClass('open-right-sidebar');
		return;
	});
	

	$(document).on("mouseenter mouseleave",".wrapper > .fixed-sidebar-left", function(e) {
		if (e.type == "mouseenter") {
			$wrapper.addClass("sidebar-hover"); 
		}
		else { 
			$wrapper.removeClass("sidebar-hover");  
		}
		return false;
	});
	
	$(document).on("mouseenter mouseleave",".wrapper > .setting-panel", function(e) {
		if (e.type == "mouseenter") {
			$wrapper.addClass("no-transition"); 
		}
		else { 
			$wrapper.removeClass("no-transition");  
		}
		return false;
	});
	
	/*Todo*/
	var random = Math.random();
	$(document).on("keypress","#add_todo",function (e) {
		if ((e.which == 13)&&(!$(this).val().length == 0))  {
				$('<li class="todo-item"><div class="checkbox checkbox-success"><input type="checkbox" id="checkbox'+random+'"/><label for="checkbox'+random+'">' + $('.new-todo input').val() + '</label></div></li><li><hr class="light-grey-hr"/></li>').insertAfter(".todo-list li:last-child");
				$('.new-todo input').val('');
		} else if(e.which == 13) {
			alert('Please type somthing!');
		}
		return;
	});
	
	/*Chat*/
	$(document).on("keypress","#input_msg_send",function (e) {
		if ((e.which == 13)&&(!$(this).val().length == 0)) {
			$('<li class="self mb-10"><div class="self-msg-wrap"><div class="msg block pull-right">' + $(this).val() + '<div class="msg-per-detail mt-5"><span class="msg-time txt-grey">3:30 pm</span></div></div></div><div class="clearfix"></div></li>').insertAfter(".fixed-sidebar-right .chat-content  ul li:last-child");
			$(this).val('');
		} else if(e.which == 13) {
			alert('Please type somthing!');
		}
		return;
	});
	$(document).on("keypress","#input_msg_send_widget",function (e) {
		if ((e.which == 13)&&(!$(this).val().length == 0)) {
			$('<li class="self mb-10"><div class="self-msg-wrap"><div class="msg block pull-right">' + $(this).val() + '<div class="msg-per-detail mt-5"><span class="msg-time txt-grey">3:30 pm</span></div></div></div><div class="clearfix"></div></li>').insertAfter(".chat-for-widgets .chat-content  ul li:last-child");
			$(this).val('');
		} else if(e.which == 13) {
			alert('Please type somthing!');
		}
		return;
	});
	
	
	$(document).on("keypress","#input_msg_send_chatapp",function (e) {
		if ((e.which == 13)&&(!$(this).val().length == 0)) {
			/*构建一个标准格式的JSON对象*/
			//发送者
			var sender = getCookie("sender");
			//接收者
			var accepter = getCookie("accepter");
			//消息表名
			var table_name_sender = getCookie("table_name_sender");
			var table_name_accepter = getCookie("table_name_accepter");
			/*var info = getCookie("info");*/
			/*alert("init_nickname:"+nickname);*/
	    	var obj = JSON.stringify({
	    			sender:sender,    /*用户名*/
					content:$(this).val(),		/*消息内容*/
					flag:'chatroom',			/*标识--chatroom代表是聊天室的消息*/
					accepter:accepter,	/*消息推送的目的地*/
					table_name_sender:table_name_sender,
					table_name_accepter:table_name_accepter
				});	
	    	$(this).val('');
	    	/*alert("init_info:"+info);*/
	    	
	    	/*var socket = getCookie("socket");*/
	    	/*
	    	CONNECTING：值为0，表示正在连接；
	    	OPEN：值为1，表示连接成功，可以通信了；
	    	CLOSING：值为2，表示连接正在关闭；
	    	CLOSED：值为3，表示连接已经关闭，或者打开连接失败。*/
	    	/*alert("socket.readyState1:"+socket.readyState);*/
	    	//设置连接成功后的回调函数
//	    	var socket = new WebSocket(path);
	    	createWebSocket();
	    	socket.onopen=function () {
	    		socket.send(obj);
//	    		alert(lockReconnect);
//	    		alert("socket.readyState:"+socket.readyState);
	        };
//			alert("socket.readyState2:"+socket.readyState);
			/*alert("socket.readyState2:"+socket.readyState);*/
			var div = document.getElementById('chat-content-my');
			var div1 = document.getElementById('chat-content-my1');
//			alert(div);
			div.scrollTop = div.scrollHeight;
			div1.scrollTop = div1.scrollHeight;
//			alert("Top:"+div.scrollTop+"Hei:"+div.scrollHeight);
		} else if(e.which == 13) {
			alert('请输入一些东西!');
		}
		return;
	});
	
	$(document).on("click",".fixed-sidebar-right .chat-cmplt-wrap .chat-data",function (e) {
		$(".fixed-sidebar-right .chat-cmplt-wrap").addClass('chat-box-slide');
		return false;
	});
	$(document).on("click",".fixed-sidebar-right #goto_back",function (e) {
		$(".fixed-sidebar-right .chat-cmplt-wrap").removeClass('chat-box-slide');
		return false;
	});
	
	/*Chat for Widgets*/
	$(document).on("click",".chat-for-widgets.chat-cmplt-wrap .chat-data",function (e) {
		$(".chat-for-widgets.chat-cmplt-wrap").addClass('chat-box-slide');
		return false;
	});
	$(document).on("click","#goto_back_widget",function (e) {
		$(".chat-for-widgets.chat-cmplt-wrap").removeClass('chat-box-slide');
		return false;
	});
	/*Horizontal Nav*/
	$(document).on("show.bs.collapse",".top-fixed-nav .fixed-sidebar-left .side-nav > li > ul",function (e) {
		e.preventDefault();
	});
	
	/*Slimscroll*/
	$('.nicescroll-bar').slimscroll({height:'100%',color: '#878787', disableFadeOut : true,borderRadius:0,size:'4px',alwaysVisible:false});
	$('.message-nicescroll-bar').slimscroll({height:'229px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.message-box-nicescroll-bar').slimscroll({height:'350px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.product-nicescroll-bar').slimscroll({height:'346px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.app-nicescroll-bar').slimscroll({height:'162px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.todo-box-nicescroll-bar').slimscroll({height:'310px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.users-nicescroll-bar').slimscroll({height:'370px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.users-chat-nicescroll-bar').slimscroll({height:'257px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.chatapp-nicescroll-bar').slimscroll({height:'543px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	$('.chatapp-chat-nicescroll-bar').slimscroll({height:'483px',size: '4px',color: '#878787',disableFadeOut : true,borderRadius:0});
	
	/*Product carousel*/
	if( $('.product-carousel').length > 0 )
	var $owl = $('.product-carousel').owlCarousel({
		loop:true,
		margin:15,
		nav:true,
		navText: ["<i class='zmdi zmdi-chevron-left'></i>","<i class='zmdi zmdi-chevron-right'></i>"],
		dots:false,
		autoplay:true,
		responsive:{
			0:{
				items:1
			},
			400:{
				items:2
			},
			767:{
				items:3
				},
			1399:{
				items:4
			}
		}
	});
	
	/*Refresh Init Js*/
	var refreshMe = '.refresh';
	$(document).on("click",refreshMe,function (e) {
		var panelToRefresh = $(this).closest('.panel').find('.refresh-container');
		var dataToRefresh = $(this).closest('.panel').find('.panel-wrapper');
		var loadingAnim = panelToRefresh.find('.la-anim-1');
		panelToRefresh.show();
		setTimeout(function(){
			loadingAnim.addClass('la-animate');
		},100);
		function started(){} //function before timeout
		setTimeout(function(){
			function completed(){} //function after timeout
			panelToRefresh.fadeOut(800);
			setTimeout(function(){
				loadingAnim.removeClass('la-animate');
			},800);
		},1500);
		  return false;
	});
	
	/*Fullscreen Init Js*/
	$(document).on("click",".full-screen",function (e) {
		$(this).parents('.panel').toggleClass('fullscreen');
		$(window).trigger('resize');
		return false;
	});
	
	/*Nav Tab Responsive Js*/
	$(document).on('show.bs.tab', '.nav-tabs-responsive [data-toggle="tab"]', function(e) {
		var $target = $(e.target);
		var $tabs = $target.closest('.nav-tabs-responsive');
		var $current = $target.closest('li');
		var $parent = $current.closest('li.dropdown');
			$current = $parent.length > 0 ? $parent : $current;
		var $next = $current.next();
		var $prev = $current.prev();
		$tabs.find('>li').removeClass('next prev');
		$prev.addClass('prev');
		$next.addClass('next');
		return;
	});
};
/***** elmer function end *****/


/***** Chat App function Start *****/
var chatAppTarget = $('.chat-for-widgets-1.chat-cmplt-wrap');
var chatApp = function() {
	$(document).on("click",".chat-for-widgets-1.chat-cmplt-wrap .chat-data",function (e) {
		var width = $(window).width();
		if(width<=1007) {
			chatAppTarget.addClass('chat-box-slide');
		}
		return false;
	});
	$(document).on("click","#goto_back_widget_1",function (e) {
		var width = $(window).width();
		if(width<=1007) {
			chatAppTarget.removeClass('chat-box-slide');
		}	
		return false;
	});
};
/***** Chat App function End *****/

var boxLayout = function() {
	if((!$wrapper.hasClass("rtl-layout"))&&($wrapper.hasClass("box-layout")))
		$(".box-layout .fixed-sidebar-right").css({right: $wrapper.offset().left + 300});
		else if($wrapper.hasClass("box-layout rtl-layout"))
			$(".box-layout .fixed-sidebar-right").css({left: $wrapper.offset().left});
}
boxLayout();	



/***** Resize function start *****/
$(window).on("resize", function () {
	setHeightWidth();
	boxLayout();
	chatApp();
}).resize();
/***** Resize function end *****/


//window.onresize = resize;

//function resize(){
//	var height = $(window).height();
//	var width = $(window).width();
//	//alert($wrapper.offset().left);
////	$(".img_my_chats").css({right: $(".img_my_chats").offset().left + 300});
//	if($("#img_my_chats_id").offset().left<800&&$("#img_my_chats_id").offset().left>500){
////		alert($(".img_my_chats").offset().left);
//		$(".img_my_chats").css({left: $(".img_my_chats").offset().left -100});
//	}
//	
//}
