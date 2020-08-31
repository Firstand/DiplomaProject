//时间设置的显示或消失开始
$("#select_time").change(function() {
	var opt = $("#select_time").find("option:selected").val();
	if(opt=='1'){
		document.getElementById("setTime").style.display = "block";
		document.getElementById("begin_timestamp").required="required";
		document.getElementById("end_timestamp").required="required";
	}
	else if(opt=='2'){
		document.getElementById("setTime").style.display = "block";
		document.getElementById("begin_timestamp").required="required";
		document.getElementById("end_timestamp").required="required";
	}
	else{
		document.getElementById("setTime").style.display = "none";
		document.getElementById("begin_timestamp").required="";
		document.getElementById("end_timestamp").required="";
	}
});
//时间设置的显示或消失结束
//行业，收入，兴趣爱好出现消失开始
$("#required_form_industry_select").change(function() {
	var opt = $("#required_form_industry_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("required_form_industry_div").style.visibility="hidden";
	}
	else{
		document.getElementById("required_form_industry_div").style.visibility="";
	}
});
$("#required_form_income_select").change(function() {
	var opt = $("#required_form_income_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("required_form_income_div").style.visibility="hidden";
	}
	else{
		document.getElementById("required_form_income_div").style.visibility="";
	}
});
$("#required_form_habit_select").change(function() {
	var opt = $("#required_form_habit_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("required_form_habit_div").style.visibility="hidden";
	}
	else{
		document.getElementById("required_form_habit_div").style.visibility="";
	}
});

$("#optional_form_industry_select").change(function() {
	var opt = $("#optional_form_industry_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("optional_form_industry_div").style.visibility="hidden";
	}
	else{
		document.getElementById("optional_form_industry_div").style.visibility="";
	}
});
$("#optional_form_income_select").change(function() {
	var opt = $("#optional_form_income_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("optional_form_income_div").style.visibility="hidden";
	}
	else{
		document.getElementById("optional_form_income_div").style.visibility="";
	}
});
$("#optional_form_habit_select").change(function() {
	var opt = $("#optional_form_habit_select").find("option:selected").val();
	if(opt==''){
		document.getElementById("optional_form_habit_div").style.visibility="hidden";
	}
	else{
		document.getElementById("optional_form_habit_div").style.visibility="";
	}
});
//行业，收入，兴趣爱好出现消失结束
//激活和一键开卡互斥
$("#radio1_auto_activate").change(function() {
	document.getElementById("radio2_wx_activate").checked = "true";
	/* document.getElementById("div_activate_url").style.display = "block";
	document.getElementById("activate_url").required="required"; */
	document.getElementById("setWxActivate").style.display = "none";
});
$("#radio2_auto_activate").change(function() {
	document.getElementById("radio1_wx_activate").checked = "true";
	/* document.getElementById("div_activate_url").style.display = "none";
	document.getElementById("activate_url").required=""; */
	document.getElementById("setWxActivate").style.display = "block";
});
//激活会员卡的url的显示或消失
$("#radio1_wx_activate").change(function() {
	document.getElementById("radio2_auto_activate").checked = "true";
	/* document.getElementById("div_activate_url").style.display = "none";
	document.getElementById("activate_url").required=""; */
	document.getElementById("setWxActivate").style.display = "block";
});
$("#radio2_wx_activate").change(function() {
	document.getElementById("radio1_auto_activate").checked = "true";
	/* document.getElementById("div_activate_url").style.display = "block";
	document.getElementById("activate_url").required="required"; */
	document.getElementById("setWxActivate").style.display = "none";
});
/* 确定弹框 */
function myTest() {
	swal({   
		title: "good job!",   
         type: "success", 
		text: "Lorem ipsum dolor sit amet",
		confirmButtonColor: "#4aa23c",   
    });
	return false;
}
/* 上传会员logo */
$("#input_logo").change(function(){
	var reads = new FileReader();
	var f = document.getElementById("input_logo").files[0];
	reads.readAsDataURL(f);
	reads.onload = function(){
	document.getElementById("img_logo").src = this.result;
	}
});
/* 上传会员卡背景图片 */
$("#input_background").change(function(){
	var reads = new FileReader();
	var f = document.getElementById("input_background").files[0];
	reads.readAsDataURL(f);
	reads.onload = function(){
	document.getElementById("img_background").src = this.result;
	}
});
//复选框选择超过5个就提醒
var c=0,limit=5; 
function doCheck(obj) {
	obj.checked?c++:c--; 
	if(c>limit){
		obj.checked=false; 
		swal({
            title: "至多选5个字段!",
            timer: 1600,   
            showConfirmButton: false 
        });
		c--; 
	} 
};
var c_=0,limit_=5; 
function doCheck_(obj) {
	obj.checked?c_++:c_--; 
	if(c_>limit_){
		obj.checked=false; 
		swal({
            title: "至多选5个字段!",
            timer: 1600,   
            showConfirmButton: false 
        });
		c_--; 
	} 
};
$("#required_form_mobile").change(function(){
	if(document.getElementById("optional_form_mobile").checked){
		document.getElementById("optional_form_mobile").checked = "";
	}
});
$("#required_form_sex").change(function(){
	if(document.getElementById("optional_form_sex").checked){
		document.getElementById("optional_form_sex").checked = "";
	}
});
$("#required_form_name").change(function(){
	if(document.getElementById("optional_form_name").checked){
		document.getElementById("optional_form_name").checked = "";
	}
});
$("#required_form_birthday").change(function(){
	if(document.getElementById("optional_form_birthday").checked){
		document.getElementById("optional_form_birthday").checked = "";
	}
});
$("#required_form_idcard").change(function(){
	if(document.getElementById("optional_form_idcard").checked){
		document.getElementById("optional_form_idcard").checked = "";
	}
});
$("#required_form_email").change(function(){
	if(document.getElementById("optional_form_email").checked){
		document.getElementById("optional_form_email").checked = "";
	}
});
$("#required_form_location").change(function(){
	if(document.getElementById("optional_form_location").checked){
		document.getElementById("optional_form_location").checked = "";
	}
});
$("#required_form_industry").change(function(){
	if(document.getElementById("optional_form_industry").checked){
		document.getElementById("optional_form_industry").checked = "";
	}
});
$("#required_form_income").change(function(){
	if(document.getElementById("optional_form_income").checked){
		document.getElementById("optional_form_income").checked = "";
	}
});
$("#required_form_habit").change(function(){
	if(document.getElementById("optional_form_habit").checked){
		document.getElementById("optional_form_habit").checked = "";
	}
});

$("#optional_form_mobile").change(function(){
	if(document.getElementById("required_form_mobile").checked){
		document.getElementById("required_form_mobile").checked = "";
	}
});
$("#optional_form_sex").change(function(){
	if(document.getElementById("required_form_sex").checked){
		document.getElementById("required_form_sex").checked = "";
	}
});
$("#optional_form_name").change(function(){
	if(document.getElementById("required_form_name").checked){
		document.getElementById("required_form_name").checked = "";
	}
});
$("#optional_form_birthday").change(function(){
	if(document.getElementById("required_form_birthday").checked){
		document.getElementById("required_form_birthday").checked = "";
	}
});
$("#optional_form_idcard").change(function(){
	if(document.getElementById("required_form_idcard").checked){
		document.getElementById("required_form_idcard").checked = "";
	}
});
$("#optional_form_email").change(function(){
	if(document.getElementById("required_form_email").checked){
		document.getElementById("required_form_email").checked = "";
	}
});
$("#optional_form_location").change(function(){
	if(document.getElementById("required_form_location").checked){
		document.getElementById("required_form_location").checked = "";
	}
});
$("#optional_form_industry").change(function(){
	if(document.getElementById("required_form_industry").checked){
		document.getElementById("required_form_industry").checked = "";
	}
});
$("#optional_form_income").change(function(){
	if(document.getElementById("required_form_income").checked){
		document.getElementById("required_form_income").checked = "";
	}
});
$("#optional_form_habit").change(function(){
	if(document.getElementById("required_form_habit").checked){
		document.getElementById("required_form_habit").checked = "";
	}
});
$("#myFrom").on('submit', function() {
	var flag = false;
	if(document.getElementById("setWxActivate").style.display != "none"){
		if(document.getElementById("required_form_industry_input").value==''&&$("#required_form_industry_select").find("option:selected").val()!=""&&document.getElementById("required_form_industry").checked){
			swal({
	            title: "一键开卡，用户必填字段",
	            text:"行业那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else if(document.getElementById("required_form_habit_input").value==''&&$("#required_form_habit_select").find("option:selected").val()!=""&&document.getElementById("required_form_habit").checked){
			swal({
	            title: "一键开卡，用户必填字段",
	            text:"兴趣爱好那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else if(document.getElementById("required_form_income_input").value==''&&$("#required_form_income_select").find("option:selected").val()!=""&&document.getElementById("required_form_income").checked){
			swal({
	            title: "一键开卡，用户必填字段",
	            text:"收入那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });		
		}
		else if(document.getElementById("optional_form_industry_input").value==''&&$("#optional_form_industry_select").find("option:selected").val()!=""&&document.getElementById("optional_form_industry").checked){
			swal({
	            title: "一键开卡，用户选填字段",
	            text:"行业那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else if(document.getElementById("optional_form_habit_input").value==''&&$("#optional_form_habit_select").find("option:selected").val()!=""&&document.getElementById("optional_form_habit").checked){
			swal({
	            title: "一键开卡，用户选填字段",
	            text:"兴趣爱好那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else if(document.getElementById("optional_form_income_input").value==''&&$("#optional_form_income_select").find("option:selected").val()!=""&&document.getElementById("optional_form_income").checked){
			swal({
	            title: "一键开卡，用户选填字段",
	            text:"收入那一栏，你还没有定义你想要的字段哦！当然你也可以选择默认样式!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else if((c+c_)<=0){
			swal({
	            title: "一键开卡",
	            text:"选择了支持一键开卡，那就得至少设置一个字段!",
	            timer: 2500,   
	            showConfirmButton: false 
	        });
		}
		else{
			flag=true;
		}
	}
	else{
		flag=true;
	}
	if(flag){
		var formData = new FormData(document.getElementById("myFrom"));
		$.ajax({
			url:"create_card.do",
			type:"post",
			data:formData,      //要传给服务器的参数
	        async: false,
	        cache: false,
	        contentType: false,//不设置内容类型
	        processData: false,//因为data值是FormData对象，不需要对数据做处理。
			success:function(data){
				if(data.msg==1){
					 swal("提交成功!", "会员卡创建成功。", "success");
				}
				else if(data.msg==2){
					swal("提交失败！", "未选择上传logo，会员卡创建失败。", "error");
				}
				else if(data.msg==3){
					swal("提交失败！", "logo上传失败，会员卡创建失败。", "error");
				}
				else if(data.msg==4){
					swal("提交失败！", "会员卡创建失败。", "error");
				}
				else if(data.msg==-1){
					swal({
			            title: "警告",   
			            text: "请先登录！",   
			            type: "warning",   
			            confirmButtonColor: "#f8b32d",   
			            confirmButtonText: "知道了",   
			            closeOnConfirm: false 
			     	});
					window.location.href="http://localhost:9090/DiplomaProject/login.do";
				}
				else{
					swal("提交失败！", "响应失败，会员卡创建失败。", "error");
				}
			},
			dataType:"json"
		});
	}
	return false;
});
$(document).ready(function () {
    var time = new Date();
    var day = ("0" + time.getDate()).slice(-2);
    var month = ("0" + (time.getMonth() + 1)).slice(-2);
    var today = time.getFullYear() + "-" + (month) + "-" + (day);
    $('#begin_timestamp').val(today);
    $('#end_timestamp').val(today);
})