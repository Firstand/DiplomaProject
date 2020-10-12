/**
 * 检测页面加载状态
 * @returns
 */
run_waitMe('roundBounce');
console.log("开始加载！");

document.onreadystatechange = subSomething;// 当页面加载状态改变的时候执行这个方法.
function subSomething() {
	if (document.readyState == "complete") { // 当页面加载状态
		$('.content-wrapper > .content').waitMe("hide");
		console.log("加载成功！");
	}
}

function run_waitMe(effect){
    $('.content-wrapper > .content').waitMe({
        effect: effect,//要显示的动画效果（String）。可用值有：'bounce'(默认值), none, rotateplane, stretch, orbit, roundBounce, win8, win8_linear, ios, facebook, rotation, timer, pulse, progressBar, bouncePulse, img
        text: '数据加载中，请稍等...',//loading效果下面的显示文本（String）
        bg: 'rgba(255,255,255,0.7)',//容器的背景颜色（String）。如：'rgba(255,255,255,0.7)'。可以使用颜色和图片
        color:'#000',//loading和文本的颜色（String）
        sizeW:'',//改变loading动画元素的宽度（String）。例如：40px，默认为空字符串
        sizeH:'',//改变loading动画元素的高度（String）。例如：40px，默认为空字符串
        source: 'dist/img/my_img/img.svg'//图片的URL（String）。默认为空字符串。该属性和effect: 'img'一起使用。
	});
}