function checkusername(){
	var  = /^[0-9a-zA-Z]+$/;
	var str = document.getElementById("username");
	if(!reg.test(str.value)){
		document.getElementById("checkanwserusername").innerHTML="您输入的字符不是数字或者字母";
	}
	if(str.value==""){
		document.getElementById("checkanwserusername").innerHTML="用户名不能为空";
	}
	if(reg.test(str.value)){
		document.getElementById("checkanwserusername").innerHTML="";
	}


	var xmlhttp;
	if (window.XMLHttpRequest){//IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp=new XMLHttpRequest();
	}
	else{// IE6, IE5
	       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var username = document.getElementById("username").value;
	xmlhttp.onreadystatechange=function(){
	//当接受到响应时回调该方法
	        if (xmlhttp.readyState==4 && (xmlhttp.status==200||xmlhttp.status==0))
	        {
	            var tip = document.getElementById("checkanwserusername");
	            var text = xmlhttp.responseText;
	            var resultJson = eval("("+text+")");
	            var regNameFail	= resultJson.REGIST_NAME_FAIL;
	            var reVerify = resultJson.REGIST_VERIFY_SUCCESS;
	            if (reVerify==1){
	            	tip.innerHTML = "此用户名可用";
	            }
	            else{
	            	tip.innerHTML = "此用户名已经注册";
	            }
	        } 
	}
	xmlhttp.open("GET","http://localhost:8080/regist/userNameVerify?userName="+username,true);
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