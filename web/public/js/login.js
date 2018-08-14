function code(){
	document.getElementById("img").src="http://localhost:8080/valicode?"+Math.random();
}
function login(){
	var username = $("#user").val();
	var npassword = $("#code").val();
	var codetext = $("#codetext").val();
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/login",
		async:false,
		dataType:"json",
		contentType:"application/x-www-form-urlencoded",
		xhrFields: {
			withCredentials: true
	   },
	   crossDomain: true,
		data:{
			"username": username,
			"password":npassword,
			"codetext":codetext
		},
		success:function(stateNum){
			var number = parseInt(stateNum.login);
			switch(number){
				case 0:alert("登录失败!"); break;
				case 1:window.location.reload();break;
				case 2:alert("登录信息未填写完整！");break;
				case 3:alert("无权登陆该系统！");break;
				case 4:alert("验证码输入不正确！");break;
				default:alert("未知错误！");
			}
		},
		error:function(){
			alert(stateNum.login);
		}
	});
}
//查看权限
function checkRight(){
	var UrlLink = window.location.pathname;
	$.ajax({
		type:"GET",
		url:"http://localhost:8080"+UrlLink,
		xhrFields: {
			withCredentials: true
	   },
	   data:"json",
	   success:function(){
			window.location.reload();
	   },
	   error:function(XMLHttpRequest,textStatus,errorThrown){
		   console.log(textStatus);
		   console.log(errorThrown);
	   }
	});
}