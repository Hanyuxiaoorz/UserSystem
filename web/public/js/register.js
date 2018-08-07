function checkyonghu(){
	var reg = /^[0-9a-zA-Z]+$/;
	var str = document.getElementById("yonghu");
	if(!reg.test(str.value)){
		document.getElementById("checkanwseryh").innerHTML="您输入的字符不是数字或者字母";
	}
	if(str.value==""){
		document.getElementById("checkanwseryh").innerHTML="用户名不能为空";
	}
	if(reg.test(str.value)){
		document.getElementById("checkanwseryh").innerHTML="";
	}


	var xmlhttp;
	if (window.XMLHttpRequest){//IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp=new XMLHttpRequest();
	}
	else{// IE6, IE5
	       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	//上面的http请求对象的生成做了一个浏览器兼容性处理
	var username = document.getElementById("yonghu").value;
	xmlhttp.onreadystatechange=function(){
	//当接受到响应时回调该方法
	        if (xmlhttp.readyState==4 && (xmlhttp.status==200||xmlhttp.status==0))
	        {
	        		// var content = JOSN.parse(xmlhttp);
	                    var tip = document.getElementById("checkanwseryh");
	                    var text = xmlhttp.responseText;
	                    var resultJson = eval("("+text+")");
	                    var regNameFail	= resultJson.REGNAMEFAIL;
	                    var reVerify = resultJson.REVERIFY;
	                    if (username!="") {
	                        if(regNameFail=="此用户名已经注册"){
	                            tip.innerHTML = "此用户名已经注册"
	                        }else if(reVerify==1){
	                            tip.innerHTML = "此用户名可用"
	                        }
	                    }else 
	                        tip.innerHTML = "用户名不能为空"
	                    }
	          }
	 xmlhttp.open("GET","172.33.3.11:8080/userSystem/regist/userNameVerify",true);
	 xmlhttp.send();
	 
}


function checkyouxiang(){
	var reg=  /^[a-zA-Z0-9_-\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	var str = document.getElementById("youxiang");
	if(!reg.test(str.value)){
		document.getElementById("checkanwseryx").innerHTML="您输入的邮箱格式有误，请检查";
	}
	if(str.value==""){
		document.getElementById("checkanwseryx").innerHTML="邮箱不能为空";
	}
	if(reg.test(str.value)){
		document.getElementById("checkanwseryx").innerHTML="";
	}


	var xmlhttp;
	if (window.XMLHttpRequest){//IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp=new XMLHttpRequest();
	}
	else{// IE6, IE5
	       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	//上面的http请求对象的生成做了一个浏览器兼容性处理
	var e_mail = document.getElementById("youxiang").value;

	
	xmlhttp.onreadystatechange=function(){
	//当接受到响应时回调该方法
	        if (xmlhttp.readyState==4 && (xmlhttp.status==200||xmlhttp.status==0))
	        {
	                    var tip = document.getElementById("checkanwseryx");
	                    var text = xmlhttp.responseText;
	                    var resultJson = eval("("+text+")");
	                    var regEmailFail	= resultJson.REGEMAILFAIL;
	                    var reVerify = resultJson.REVERIFY;
	                    if (e_mail!="") {
	                        if(regEmailFail=="此邮箱已经注册"){
	                            tip.innerHTML = "此邮箱已经注册"
	                        }else if(reVerify==1){
	                            tip.innerHTML = "此邮箱可用"
	                        }
	                    }else 
	                        tip.innerHTML = "邮箱不能为空"
	                    }
	          }
	 xmlhttp.open("GET","/userEmailVerify/{e_mail}",true);
	 xmlhttp.send();
	 
}


function checkID(){
	var str = document.getElementById("ID");
	if(str.value.length != 10){
		document.getElementById("checkanwserID").innerHTML="学号输入有误";
	}
	if(str.value==""){
		document.getElementById("checkanwserID").innerHTML="学号不能为空";
	}
	if(str.value.length == 10){
		document.getElementById("checkanwserID").innerHTML="";
	}


	var xmlhttp;
	if (window.XMLHttpRequest){//IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp=new XMLHttpRequest();
	}
	else{// IE6, IE5
	       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	//上面的http请求对象的生成做了一个浏览器兼容性处理         
	var id = document.getElementById("ID").value;
	
	xmlhttp.onreadystatechange=function(){
	//当接受到响应时回调该方法
	        if (xmlhttp.readyState==4 && (xmlhttp.status==200||xmlhttp.status==0))
	        {
	                    var tip = document.getElementById("checkanwseryh");
	                    var text = xmlhttp.responseText;
	                    var resultJson = eval("("+text+")");
	                    var regIdFail	= resultJson.REGIFFAIL;
	                    var reVerify = resultJson.REVERIFY;
	                    if (id!="") {
	                        if(regIdFail=="此学号已经注册"){
	                            tip.innerHTML = "此学号已经注册"
	                        }else if(reVerify==1){
	                            tip.innerHTML = "此学号可用"
	                        }
	                    }else 
	                        tip.innerHTML = "学号不能为空"
	                    }
	          }
	 xmlhttp.open("GET","/userEmailVerify/{e_mail}",true);
	 xmlhttp.send();
	
	}


function checkcode(){
	var str = document.getElementById("code");
	if(str.value.length != 6){
		document.getElementById("checkanwsercode").innerHTML="请确认密码为6位数";
	}
	if(str.value==""){
		document.getElementById("checkanwsercode").innerHTML="密码不能为空";
	}
	if(str.value.length == 6){
		document.getElementById("checkanwsercode").innerHTML="";
	}
}


function checkrecode(){
	var str1 = document.getElementById("code");
	var str2 = document.getElementById("recode");
	if(str1.value != str2.value){
		document.getElementById("checkanwserrecode").innerHTML="确认密码与密码不匹配，请重新输入";
	}
	if(str2.value==""){
		document.getElementById("checkanwserrecode").innerHTML="确认密码不能为空";
	}
	if(str1.value == str2.value){
		document.getElementById("checkanwserrecode").innerHTML="";
	}
}

function zhuce(){
	var regyh = /^[0-9a-zA-Z]+$/;
	var yh = document.getElementById("yonghu");
	var regyx=  /^[a-zA-Z0-9_-\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	var yx = document.getElementById("youxiang");
	var id = document.getElementById("ID");
	var code = document.getElementById("code");
	var recode = document.getElementById("recode");
	var fx = document.getElementById("fangxiang");
	if(regyh.test(yh.value)){
		if(regyx.test(yx.value)){
			if(id.value.length == 10){
				if(code.value.length == 6){
					if(code.value == recode.value){
						if(fx.value!= "方向"){
							// document.getElementById("checkanwserzc").innerHTML="注册成功";
							$('.ui.basic.modal').modal('show');
						}
						else document.getElementById("checkanwserzc").innerHTML="注册失败,两个密码输出不一致";
	            	}	
	            	else document.getElementById("checkanwserzc").innerHTML="注册失败，密码长度不为6";
	        	}
	        	else document.getElementById("checkanwserzc").innerHTML="注册失败，学号长度不为10";
			}
			else document.getElementById("checkanwserzc").innerHTML="注册失败，邮箱格式不规范";
		}
		else document.getElementById("checkanwserzc").innerHTML="注册失败，用户名只能为字母或数字";
	}
}



function qianduan(){
	var str = document.getElementsByClassName("item")[0];
	document.getElementById("fangxiang").innerHTML="前端";
	document.getElementById("fangxiang").style.color="black";
}
function houtai(){
	var str = document.getElementsByClassName("item")[1];
	document.getElementById("fangxiang").innerHTML="后台";
	document.getElementById("fangxiang").style.color="black";
}
function ceshi(){
	var str = document.getElementsByClassName("item")[2];
	document.getElementById("fangxiang").innerHTML="测试";
	document.getElementById("fangxiang").style.color="black";
}


// function zhuce(){
// $('.ui.basic.modal')
//   .modal('show')
// ;
// }

// function fail(){
// $('#fail')
//   .modal('show')
// ;
// }

// function judge(){
// 	if(answer=="注册成功"){
// 		zhuce();
// 	}
// 	if(answer=="注册失败"){
// 		zhuce();
// 	}

// }

// function hasUserName(){
//     var xmlhttp;
//     var username = document.getElementById("yonghu");
//     var name = document.getElementById("yonghu").value;

//     if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
//         xmlhttp = new XMLHttpRequest();
//     } else {// code for IE6, IE5
//         xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//     }
//     xmlhttp.open("GET", "userNameVerify/{username}"+name, true);

//     xmlhttp.onreadystatechange = function () {
//         if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//             if (xmlhttp.responseText == "1") {
//                 tips.style.visibility = "";
//                 tips.style.color = "green";
//                 tips.innerHTML = "* 恭喜你,帐号可以使用!";
//             }else {
//                 tips.style.visibility = "";
//                 tips.style.color = "red";
//                 tips.innerHTML = "* 账号已被占用!"
//             }
//         }
//     };
//     xmlhttp.send();
// }

























