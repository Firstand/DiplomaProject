function chat_select(id, u_tel) {
	// 检查浏览器是否支持WebSocket
	if (window.WebSocket) {
		console.log('这个浏览器支持WebSocket');
	} else {
		console.log('这个浏览器不支持WebSocket');
	}
	// 接收消息的人
	var accepter = document.getElementById("manager_name" + id).value;
	setCookie("accepter", accepter, 0.1);
	// 消息表名
	var table_name_sender = document.getElementById("table_name_sender").value;
	setCookie("table_name_sender", table_name_sender, 0.1);
	var table_name_accepter = "manager_table_" + id;
	setCookie("table_name_accepter", table_name_accepter, 0.1);
	setCookie("accepter_id", id, 0.1);
	$
			.ajax({
				type : "post", // 发送请求的方式，默认请求方式为get
				url : "chats.do", // 发送到什么位置
				data : {
					"u_tel" : u_tel
				}, // 要传给服务器的参数
				success : function(data) {// 会在返回完整，请求成功时调用，其中的参数是返回值
					var str_u_nick = "<span class='inline-block txt-dark'>"
							+ data.resultMap.u_nickname + "</span>";
					document.getElementById("u_nick").innerHTML = str_u_nick;/* class="chat-content" */
					var str_we_chats = "";
					str_we_chats += "<li style='display: none'  id='li_" + id
							+ "'></li>";
					for (var i = 0; i < data.resultMap_2.chat_list.length; i++) {
						if (!data.resultMap_2.chat_list[i].isself) {
							str_we_chats += "<li class='friend'>";
							str_we_chats += "<div class='friend-msg-wrap'>";
							str_we_chats += "<img class='user-img img-circle block pull-left'  src='";
							if (data.resultMap_0.manager1.profileimg.length < 1) {
								str_we_chats += "dist/img/user1.png";
							} else {
								var flag = 0;
								for (var j = 0; j < data.resultMap_0.manager1.profileimg.length; j++) {
									if (data.resultMap_0.manager1.profileimg[j].pro_file_img_type == 1) {
										str_we_chats += "/pro_head_portrait/"
												+ data.resultMap_0.manager1.profileimg[j].pro_file_img_path;
										flag = 1;
										break;
									}
								}
								if (flag == 0) {
									str_we_chats += "dist/img/user1.png";
								}
							}
							str_we_chats += "' alt='user'/>";
							str_we_chats += "<div class='msg pull-left'>";
							str_we_chats += "<p>"
									+ data.resultMap_2.chat_list[i].content
									+ "</p>";
							str_we_chats += "<div class='msg-per-detail text-right'>";
							str_we_chats += "<span class='msg-time txt-grey'>"
									+ data.resultMap_2.chat_list[i].creat_time_str
									+ "</span>";
							str_we_chats += "</div>";
							str_we_chats += "</div>";
							str_we_chats += "<div class='clearfix'></div>";
							str_we_chats += "</div>";
							str_we_chats += "</li>";
						} else {
							str_we_chats += "<li class='self mb-10'>";
							str_we_chats += "<div class='self-msg-wrap'>";
							str_we_chats += "<div class='msg block pull-right'>";
							str_we_chats += "<p>"
									+ data.resultMap_2.chat_list[i].content
									+ "</p>";
							str_we_chats += "<div class='msg-per-detail text-right'>";
							str_we_chats += "<span class='msg-time txt-grey'>"
									+ data.resultMap_2.chat_list[i].creat_time_str
									+ "</span>";
							str_we_chats += "</div>";
							str_we_chats += "</div>";
							str_we_chats += "<div class='clearfix'></div>";
							str_we_chats += "</div>";
							str_we_chats += "</li>";
						}
					}
					document.getElementById("chat-content-my").innerHTML = str_we_chats;
					str_we_chats = "";
					str_we_chats += "<div class='input-group'>";
					str_we_chats += "<input type='text' id='input_msg_send_chatapp' name='send-msg' class='input-msg-send form-control' placeholder='输入一些想说的话吧。。。'>";
					str_we_chats += "<div class='input-group-btn emojis'>";
					str_we_chats += "<div class='dropup'>";
					str_we_chats += "<button type='button' class='btn  btn-default  dropdown-toggle' data-toggle='dropdown' ><i class='zmdi zmdi-mood'></i></button>";
					str_we_chats += "<ul class='dropdown-menu dropdown-menu-right'>";
					str_we_chats += "<li><a href='javascript:void(0)'>Action</a></li>";
					str_we_chats += "<li><a href='javascript:void(0)'>Another action</a></li>";
					str_we_chats += "<li class='divider'></li>";
					str_we_chats += "<li><a href='javascript:void(0)'>Separated link</a></li>";
					str_we_chats += "</ul>";
					str_we_chats += "</div>";
					str_we_chats += "</div>";
					str_we_chats += "<div class='input-group-btn attachment'>";
					str_we_chats += "<div class='fileupload btn  btn-default'><i class='zmdi zmdi-attachment-alt'></i>";
					str_we_chats += "<input type='file' class='upload'>";
					str_we_chats += "</div>";
					str_we_chats += "</div>";
					str_we_chats += "</div>";
					var child = document.getElementById("panel-body-chats-c");
					if (child != null) {
						// 移除图片
						document.getElementById("panel-body-chats-f")
								.removeChild(child);
					}
					// 移除提示的小点
					document.getElementById("chat_data_f_" + id).innerHTML = "";
					document.getElementById("we_chats").innerHTML = str_we_chats;
				},
				// 若返回值的类型为json，则需要指定dataType
				dataType : "json" // 告知此次请求的返回值是json串
			});
}

function onSearch() {
	setTimeout(
			function() {// 因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
				var chat_list_ul = document.getElementById('chat_list_ul');// 获取ul的id标识
				var chat_list_li = chat_list_ul.getElementsByTagName('li');// ul总共有多少行
				var searchContent = document
						.getElementById('example-input1-group21').value;
				for (var i = 0; i < chat_list_li.length; i++) {
					var username = document.getElementById('user_last_' + i).innerHTML;
					if (username.match(searchContent)
							|| username.toUpperCase().match(
									searchContent.toUpperCase())
							|| searchContent == "") {// 用match函数进行筛选，如果input的值，即变量
						// key的值为空，返回的是ture，
						document.getElementById('user_first_' + i).style.display = '';// 显示行操作，
					} else {
						document.getElementById('user_first_' + i).style.display = 'none';// 隐藏行操作
					}
				}
			}, 200);// 200为延时时间
}