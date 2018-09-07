function code(){
	document.getElementById("img").src="http://localhost:8080/valicode?"+Math.random();
}
function login(){
	var userName = $("#user").val();
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
            "input": userName,
            "password":npassword,
			"vCode":codetext
		},
        success:function(stateNum){
            var number = parseInt(stateNum.login);
            switch(number){
                case 0:alert("该功能出现异常!请联系管理员！！"); break;
                case 1:window.location.reload();break;
                case 2:alert("登录信息未填写完整！");break;
                case 3:alert("无权登陆该系统！");break;
                case 4:alert("验证码输入不正确！");break;
                case 5:alert("用户名或密码填写错误！");break;
                default:alert(stateNum.login);
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