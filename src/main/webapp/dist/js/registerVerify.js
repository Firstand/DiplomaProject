$(function() {
	/*仿刷新：检测是否存在cookie*/
	if($.cookie("captcha")) {
		var count = $.cookie("captcha");
		var btn = $('#geting');
		btn.val(count + '秒后可重新获取').attr('disabled', true).css('cursor', 'not-allowed');
		var resend = setInterval(function() {
			count--;
			if(count > 0) {
				btn.val(count + '秒后可重新获取').attr('disabled', true).css('cursor', 'not-allowed');
				$.cookie("captcha", count, {
					path: '/',
					expires: (1 / 86400) * count
				});
			} else {
				clearInterval(resend);
				btn.val("获取验证码").removeClass('disabled').removeAttr('disabled style');
			}
		}, 1000);
	}

	/*点击改变按钮状态，已经简略掉ajax发送短信验证的代码*/
	$('#geting').click(function() {
		var btn = $('#geting');
		var count = 5;
		var resend = setInterval(function() {
			count--;
			if(count > 0) {
				btn.val(count + "秒后可重新获取");
				$.cookie("captcha", count, {
					path: '/',
					expires: (1 / 86400) * count
				});
			} else {
				clearInterval(resend);
				btn.val("获取验证码").removeAttr('disabled style');
			}
		}, 1000);
		btn.attr('disabled', true).css('cursor', 'not-allowed');
	});
});