function checkName()
{
	if(document.getElementById("u_name").value.length<2||document.getElementById("u_name").value.length>20)
		{
		document.getElementById("tip_name").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*用户名由2—20位字符组成</span>";
		document.getElementById("u_name").focus;
		return false;
		}
	else
		{document.getElementById("tip_name").innerHTML="";}
} 
function checkTel(){
//	var reg =/^1[3456789]\d{9}$/;
//	if(reg.test(document.getElementById("u_tel").value)==false){
//		document.getElementById("tip_tel").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*您输入的电话号码有误</span>";
//		document.getElementById("u_tel").focus;
//		return false;
//		}
//	else
//		{document.getElementById("tip_tel").innerHTML="";}
}

function registerCheck()
{
	if(document.getElementById("u_verify").value=="")
	{
		document.getElementById("tip_verify").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*验证码不能为空</span>";
		//document.getElementById("verify_txt").focus();
		return false;
	}
	else
	{
	document.getElementById("tip_verify").innerHTML="";
	}
	
}

function checkSfz(){
	var reg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if( reg.test(document.getElementById("u_id").value)==false)
	{
		document.getElementById("tip_sfz").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*您输入的身份证号码不是有效格式</span>";
		document.getElementById("u_id").focus;
		return false;
	}
	else
	{
	document.getElementById("tip_sfz").innerHTML="";
	}
}
function checkPwd()
{
	if(document.getElementById("pwd").value.length<6||document.getElementById("pwd").value.length>20)
	{
		document.getElementById("tip_pwd").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*密码由6—20位字符组成</span>";
		document.getElementById("pwd").focus;
		return false;
	}
	else
	{
	document.getElementById("tip_pwd").innerHTML="";
	}
}

//function oldcheckPwd()
//{
//	if(document.getElementById("oldpwd").value.length<6||document.getElementById("oldpwd").value.length>20)
//	{
//		document.getElementById("tip_oldpwd").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*密码由6—20位字符组成</span>";
//		document.getElementById("oldpwd").focus;
//		return false;
//	}
//	else
//	{
//	document.getElementById("tip_oldpwd").innerHTML="";
//	}
//}

function recheckPwd()
{
	if(document.getElementById("repwd").value.length<6||document.getElementById("repwd").value.length>20)
	{
		document.getElementById("tip_repwd").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*密码由6—20位字符组成</span>";
		document.getElementById("repwd").focus;
		return false;
	}
	if(document.getElementById("pwd").value!=document.getElementById("repwd").value)
	{
		document.getElementById("tip_repwd").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*两次密码不一致</span>";
		document.getElementById("repwd").focus;
		return false;
	}
	
	else
	{
	document.getElementById("tip_repwd").innerHTML="";
	}
}
function checkEmail()
{
	var email=document.getElementById("u_email").value;
	var pattern=/^[a-zA-Z0-9#_\^\$\.\*\+\-\?\=\!\:\|\\\/\(\)\[\]\{\}]+@[a-zA-Z0-9]+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(email.length==0)
	{
		document.getElementById("tip_email").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*邮箱不能为空</span>";
		document.getElementById("u_email").focus;
		return false;
	}
	else if(!pattern.test(email))
	{
		document.getElementById("tip_email").innerHTML="<span style='color:#FF0000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*Email不合法</span>";
		document.getElementById("u_email").focus;
		return false;
	}
	else
	{
		document.getElementById("tip_email").innerHTML="";
	}

}

function check_forgot(){
	if(recheckPwd()==false||checkPwd()==false){
		return false;
	}
}

function check(){
	//当有一个方法为false，结果就为false
	if(checkEmail()==false||recheckPwd()==false||checkPwd()==false||checkSfz()==false||checkTel()==false||checkName()==false||registerCheck()==false)
	{
		return false;
	}
}