$(function(){
	var socket = null;
	var wsurl = "ws://192.168.20.152:8080/suncent-socket/chat";
    sock = new WebSocket(wsurl);
    sock.onopen = function() {
        //成功连接到服务器
        console.log("connected to " + wsurl);
    }
    sock.onclose = function(e) {
        console.log("connection closed (" + e.code + ")");
    }
    sock.onmessage = function(e) {
        //服务器发送通知
        //开始处理
        console.log("message received: " + e.data);
		//获取服务端消息
        var msg = JSON.parse(event.data) || {};
		if(msg.type === 'SPEAK'){
			var html = "";
			if(msg.userName == $("#nick").val()){
				html = "<div class=\"msg-item msg-self\">";
				html += "<span class=\"msg\">"+msg.msg+"</span>";
				html += "<span class=\"nick\">"+msg.userName+"</span>";
			}else{
				html = "<div class=\"msg-item\">";
				html += "<span class=\"nick\">"+msg.userName+"</span>";
				html += "<span class=\"msg\">"+msg.msg+"</span>";
			}
			$(".inbox-body").append(html);
			$(".inbox-body").slimScroll({
				width: '100%', //可滚动区域宽度
		        height: '450px', //可滚动区域高度
		        size: '10px', //滚动条宽度，即组件宽度
		        color: '#000', //滚动条颜色
		        position: 'right', //组件位置：left/right
		        distance: '0px', //组件与侧边之间的距离
		        start: $(".msg-item").last(), //默认滚动位置：top/bottom
		        opacity: .4, //滚动条透明度
		        alwaysVisible: true, //是否 始终显示组件
		        disableFadeOut: false, //是否 鼠标经过可滚动区域时显示组件，离开时隐藏组件
		        railVisible: true, //是否 显示轨道
		        railColor: '#333', //轨道颜色
		        railOpacity: .2, //轨道透明度
		        railDraggable: true, //是否 滚动条可拖动
		        railClass: 'slimScrollRail', //轨道div类名 
		        barClass: 'slimScrollBar', //滚动条div类名
		        wrapperClass: 'slimScrollDiv', //外包div类名
		        allowPageScroll: true, //是否 使用滚轮到达顶端/底端时，滚动窗口
		        wheelStep: 20, //滚轮滚动量
		        touchScrollStep: 200, //滚动量当用户使用手势
		        borderRadius: '7px', //滚动条圆角
		        railBorderRadius: '7px' //轨道圆角
			});
		}
    }

	$("#send-msg").click(function(){
		var msg = $("#msg").val();
		if(msg == ""){
			return;
		}
		sock.send(JSON.stringify({userName:$("#nick").val(),msg:msg}));
		$("#msg").val("")
	});
	
	document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e.keyCode === 13){
			var msg = $("#msg").val();
			if(msg == ""){
				return;
			}
			sock.send(JSON.stringify({userName:$("#nick").val(),msg:msg}));
			$("#msg").val("")
		}
    };
});