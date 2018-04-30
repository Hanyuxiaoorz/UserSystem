$(document).ready(function(){
	//在这里展示写入立即加载内容
	$(".loading").fadeOut();
	//在这里写入非立即加载内容
});


//查询用户
function searchUsers(){
	//获取输入框中的值
	var inputValue = $("#searchInputs").val();
	//清空原有数据
	$(".list").children('.item').children('.content').empty();
	$.ajax({
		type:"POST",
		url:"http://rap2api.taobao.org/app/mock/6975//example/1525008436528",
		contentType: "application/json",
		data:{
			"searchValue": inputValue
		},
		dataType:"jsonp",
		beforeSend:function(XMLHttpRequest){

		},
		success:function(person){
			
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
/*
//点击修改密码

	function rechangePassword(byname){
			console.log(byname.userName);
			$.ajax({
				type:"GET",
				url:"http://rap2api.taobao.org/app/mock/6975//example/1520500796072",
				dataType:"jsonp",
				success:function(json){
					alert(hostUserName);
					alert(json.word);
				},
				error:function(jqXHR){
					alert("ERROR!");
				}
			});
	}
*/