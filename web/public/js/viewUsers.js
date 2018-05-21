$(document).ready(function(){
	//在这里展示写入立即加载内容
	$(".loading").fadeOut();
	//在这里写入非立即加载内容
	//无用户信息时显示遮盖层
	$("#searchInputs").focus();
	$('#userInforShowArea').dimmer('show');
	//判断是否为外界跳转
	var url = location.search;
	if(url.indexOf("?") !=-1) {
		var url_param = url.split("?")[1];
		var url_param_arr = url_param.split("=");
		showUser(url_param_arr[1]);
	}
});


//定义当前用户名，用于修改密码使用
var ByUser = {
	"userName":"",
	"state":0
};

//查询用户
function searchUsers(){
	//获取输入框中的值
	var inputValue = $("#searchInputs").val();
	//检测输入框是否为空
	if(inputValue == ""){alert("输入框为空");return}
	//清空原有数据
	$(".list").children('.item').children('.content').empty();
	$("#userInforShowArea").children(".teal").fadeOut();
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/backstageManagement/selectUserInfo",
		contentType:"application/json",
		data:{
			"searchValue": inputValue
		},
		dataType:"json",
		beforeSend:function(XMLHttpRequest){
			alert(inputValue);
		},
		success:function(person){
			if (person == 0) {alert("没有此用户！");return}
			//除去遮盖层
			$('#userInforShowArea').dimmer('hide');
			ByUser.userName = person.userName;
			ByUser.state = person.state;
			//添加标签
			var tag = "<div class='ui teal huge top right attached label'>";
			switch(person.state){
				case 0:tag += "普通用户</div>";break;
				case 1:tag += "管理员</div>";break;
				case 2:tag += "超级管理员</div>";break;
				default:break;
			}
			$("#userInforShowArea").append(tag);
			//添加用户信息
			$("#userNameShow").append("用户名：" + person.userName);
			$("#userIdShow").append("学号：" + person.id);
			$("#userE-mailShow").append("E-mail：" + person.e_mail);
			$("#userGenderShow").append("性别：" + person.sex);
			$("#userPhoneShow").append("电话：" + person.phone_number);
			$("#userMajorShow").append("专业：" + person.major);
			$("#userClassShow").append("班级：" + person.class_number);
			$("#userDirShow").append("方向：" + person.study_direction);
			$("#userBirthShow").append("年龄：" + person.birth);
			$("#userHabitShow").append("生日：" + person.habit);
			$("#userAgeShow").append("爱好：" + person.age);
		},
		complete:function(XMLHttpRequest,textStatus){  
            if(textStatus=='timeout'){  
                var xmlhttp = window.XMLHttpRequest ? new window.XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHttp");  
                xmlhttp.abort();
            }
    　　},
		error:function(XMLHttpRequest,textStatus){
			console.log(XMLHttpRequest.responseText);
			console.log(textStatus);
		}
	});
}

//点击修改密码
function reSetPassword(){
	//判断二者的权限值
	//if (cookie.state <= ByUser.state) { alert("你没有此权限！");return;}
		if (ByUser.userName.length == 0) {alert("当前无用户！");return;}
			$.ajax({
				type:"POST",
				url:"http://localhost:8080/backstageManagement/updatePassword",
				contentType:"application/json",
				data:{
					//hostUserName:cookie.userName,
					"byUserName":ByUser.userName
				},
				dataType:"json",
				success:function(json){
					alert("已成功初始化" + ByUser.userName + "的密码!");
				},
				error:function(jqXHR){
					alert("ERROR!");
				}
			});
}
//删除用户
function deleteUser(){
	if (ByUser.userName.length == 0) {alert("当前无用户！");return;}
		$.ajax({
				type:"POST",
				url:"http://localhost:8080/backstageManagement/deleteUser",
				contentType:"application/json",
				data:{
					//hostUserName:cookie.userName,
					"byUserName":ByUser.userName
				},
				dataType:"json",
				success:function(json){
					alert("已成功删除" + ByUser.userName);
					//清空原有数据
					$(".list").children('.item').children('.content').empty();
					$("#userInforShowArea").children(".teal").fadeOut();
					ByUser = {
						"userName":"",
						"state":0
						};
					//删除用户后显示遮盖层
					$('#userInforShowArea').dimmer('show');
					},
				error:function(jqXHR){
					alert("ERROR!");
				}
			});
}
function showUpLevelModal(){
		if (ByUser.userName.length == 0) {alert("当前无用户！");return;}
		$("#changeStateModal").modal("show");
}
function upLevelUser(Chosenstate){
	$("#changeStateModal").modal("hide");
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/backstageManagement/userState",
		contentType:"application/json",
		data:{
			//hostUserName:cookie.userName,
			"byUserName":ByUser.userName,
			"state":Chosenstate
		},
		dataType:"json",
		success:function(json){
			alert(json.userState);
		},
		error:function(jqXHR){
			alert("修改失败!");
		}
	});
}
//外界跳转时执行的ajax
function showUser(searchId){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/backstageManagement/selectUserInfo",
		contentType:"application/json",
		data:{
			"searchValue":searchId
		},
		dataType:"jsonp",
		beforeSend:function(XMLHttpRequest){
		},
		success:function(person){
			if (person == 0) {alert("没有此用户！");return}
			//除去遮盖层
			$('#userInforShowArea').dimmer('hide');
			ByUser.userName = person.userName;
			ByUser.state = person.state;
			//添加标签
			var tag = "<div class='ui teal huge top right attached label'>";
			switch(person.state){
				case 0:tag += "普通用户</div>";break;
				case 1:tag += "管理员</div>";break;
				case 2:tag += "超级管理员</div>";break;
				default:break;
			}
			$("#userInforShowArea").append(tag);
			//添加用户信息
			$("#userNameShow").append("用户名：" + person.userName);
			$("#userIdShow").append("学号：" + person.id);
			$("#userE-mailShow").append("E-mail：" + person.e_mail);
			$("#userGenderShow").append("性别：" + person.sex);
			$("#userPhoneShow").append("电话：" + person.phone_number);
			$("#userMajorShow").append("专业：" + person.major);
			$("#userClassShow").append("班级：" + person.class_number);
			$("#userDirShow").append("方向：" + person.study_direction);
			$("#userBirthShow").append("年龄：" + person.birth);
			$("#userHabitShow").append("生日：" + person.habit);
			$("#userAgeShow").append("爱好：" + person.age);
		},
		complete:function(XMLHttpRequest,textStatus){  
            if(textStatus=='timeout'){  
                var xmlhttp = window.XMLHttpRequest ? new window.XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHttp");  
                xmlhttp.abort();
            }
    　　},
		error:function(XMLHttpRequest,textStatus){
			console.log(XMLHttpRequest.responseText);
			console.log(textStatus);
		}
	});
}