$(document).ready(function(){
	//在这里展示写入立即加载内容
	$(".loading").fadeOut();
	//在这里写入非立即加载内容
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
	//清空原有数据
	$(".list").children('.item').children('.content').empty();
    $("#userInforShowArea").children(".teal").hide();
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/backstageManagement/selectUserInfo",
        contentType:"application/x-www-form-urlencoded",
		data:{
			"searchValue": inputValue
		},
		dataType:"json",
		beforeSend:function(XMLHttpRequest){
		},
		success:function(person){
			if(person.selectUserInfo == 0)
			{
				alert("该用户不存在！");
			}
			else{
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
		    }
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
					byUserName:ByUser.userName
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
					byUserName:ByUser.userName
				},
				dataType:"jsonp",
				success:function(json){
					alert("已成功删除" + ByUser.userName);
					//清空原有数据
					$(".list").children('.item').children('.content').empty();
					$("#userInforShowArea").children(".teal").fadeOut();
					ByUser = {
						"userName":"",
						"state":0
						};
					},
				error:function(jqXHR){
					alert("ERROR!");
				}
			});
}