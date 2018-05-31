
function login(){
	var username = $("#user").val();
	var npassword = $("#code").val();
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/login",
		dataType:"json",
        contentType:"application/x-www-form-urlencoded",
		data:{
			"input": username,
			"password":npassword
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
			alert("ERROR!");
		}

	});
}