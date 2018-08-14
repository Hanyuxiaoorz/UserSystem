function sex_write(){
	document.getElementsByClassName("box1")[0].style.display="none";
	document.getElementsByClassName("box2")[0].style.display="block";
	document.getElementsByClassName("field-content")[0].style.height=96+"px";
	document.getElementsByClassName("field")[0].style.height=157+"px";
}
function sex_submit(){
	var bFlag = false;
	var gender = document.getElementsByName("gender");
	for(var i = 0;i<gender.length;i++){
		if(gender[i].checked){
			document.getElementsByClassName("amend-result")[0].innerHTML=gender[i].value;
			document.getElementsByClassName("box3")[0].style.display="block";
			document.getElementsByClassName("field-content")[0].style.height=36+"px";
			document.getElementsByClassName("field")[0].style.height=97+"px";
			document.getElementsByClassName("box2")[0].style.display="none";
			document.getElementsByClassName("box1")[0].style.display="none";
			bFlag = true;
		}
		if (bFlag == false){
			document.getElementsByClassName("box2")[0].style.display="none";
			document.getElementsByClassName("box1")[0].style.display="block";
			document.getElementsByClassName("field-content")[0].style.height=36+"px";
			document.getElementsByClassName("field")[0].style.height=97+"px";
		}
	}
}
function sex_change(){
	document.getElementsByClassName("box2")[0].style.display="block";
	document.getElementsByClassName("box3")[0].style.display="none";
	document.getElementsByClassName("field-content")[0].style.height=96+"px";
	document.getElementsByClassName("field")[0].style.height=157+"px";
}
function sex_cancel(){
	var bFlag = false;
	var gender = document.getElementsByName("gender");
	for(var i = 0;i<gender.length;i++){
		if(gender[i].checked){
			document.getElementsByClassName("amend-result")[0].innerHTML=gender[i].value;
			document.getElementsByClassName("box1")[0].style.display="none";
			document.getElementsByClassName("box2")[0].style.display="none";
			document.getElementsByClassName("box3")[0].style.display="block";
			document.getElementsByClassName("field-content")[0].style.height=36+"px";
			document.getElementsByClassName("field")[0].style.height=97+"px";
			bFlag = true;
		}
		if (bFlag == false){
			document.getElementsByClassName("box2")[0].style.display="none";
			document.getElementsByClassName("box1")[0].style.display="block";
			document.getElementsByClassName("field-content")[0].style.height=36+"px";
			document.getElementsByClassName("field")[0].style.height=97+"px";
		}
	}
}





function direciton_write(){
	document.getElementsByClassName("box1")[1].style.display="none";
	document.getElementsByClassName("box2")[1].style.display="block";
	document.getElementsByClassName("field-content")[1].style.height=96+"px";
	document.getElementsByClassName("field")[1].style.height=157+"px";
}
function direciton_submit(){
	var bFlag = false;
	var direciton = document.getElementsByName("direciton");
	for(var i = 0;i<direciton.length;i++){
		if(direciton[i].checked){
			document.getElementsByClassName("amend-result")[1].innerHTML=direciton[i].value;
			document.getElementsByClassName("box3")[1].style.display="block";
			document.getElementsByClassName("field-content")[1].style.height=36+"px";
			document.getElementsByClassName("field")[1].style.height=97+"px";
			document.getElementsByClassName("box2")[1].style.display="none";
			document.getElementsByClassName("box1")[1].style.display="none";
			bFlag = true;
		}
		if (bFlag == false){
			document.getElementsByClassName("box2")[1].style.display="none";
			document.getElementsByClassName("box1")[1].style.display="block";
			document.getElementsByClassName("field-content")[1].style.height=36+"px";
			document.getElementsByClassName("field")[1].style.height=97+"px";
		}
	}
}
function direciton_change(){
	document.getElementsByClassName("box2")[1].style.display="block";
	document.getElementsByClassName("box3")[1].style.display="none";
	document.getElementsByClassName("field-content")[1].style.height=96+"px";
	document.getElementsByClassName("field")[1].style.height=157+"px";
}
function direciton_cancel(){
	var bFlag = false;
	var direciton = document.getElementsByName("direciton");
	for(var i = 0;i<direciton.length;i++){
		if(direciton[i].checked){
			document.getElementsByClassName("amend-result")[1].innerHTML=direciton[i].value;
			document.getElementsByClassName("box1")[1].style.display="none";
			document.getElementsByClassName("box2")[1].style.display="none";
			document.getElementsByClassName("box3")[1].style.display="block";
			document.getElementsByClassName("field-content")[1].style.height=36+"px";
			document.getElementsByClassName("field")[1].style.height=97+"px";
			bFlag = true;
		}
		if (bFlag == false){
			document.getElementsByClassName("box2")[1].style.display="none";
			document.getElementsByClassName("box1")[1].style.display="block";
			document.getElementsByClassName("field-content")[1].style.height=36+"px";
			document.getElementsByClassName("field")[1].style.height=97+"px";
		}
	}
}





function name_write(){
	document.getElementsByClassName("box1")[2].style.display="none";
	document.getElementsByClassName("box2")[2].style.display="block";
	document.getElementsByClassName("field-content")[2].style.height=96+"px";
	document.getElementsByClassName("field")[2].style.height=157+"px";
}
function name_submit(){
	document.getElementsByClassName("box3")[2].style.display="block";
	document.getElementsByClassName("field-content")[2].style.height=36+"px";
	document.getElementsByClassName("field")[2].style.height=97+"px";
	document.getElementsByClassName("box2")[2].style.display="none";
	var input = document.getElementsByClassName("Input3")[0].value;
	document.getElementsByClassName("amend-result")[2].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[2].style.display="none";
		document.getElementsByClassName("box1")[2].style.display="block";
	}
}
function name_change(){
	document.getElementsByClassName("box2")[2].style.display="block";
	document.getElementsByClassName("box3")[2].style.display="none";
	document.getElementsByClassName("field-content")[2].style.height=96+"px";
	document.getElementsByClassName("field")[2].style.height=157+"px";
}
function name_cancel(){
	document.getElementsByClassName("box2")[2].style.display="none";
	document.getElementsByClassName("box3")[2].style.display="block";
	document.getElementsByClassName("field-content")[2].style.height=36+"px";
	document.getElementsByClassName("field")[2].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[0].value;
	document.getElementsByClassName("amend-result")[2].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[2].style.display="none";
		document.getElementsByClassName("box1")[2].style.display="block";
	}
}



function label_write(){
	document.getElementsByClassName("box1")[3].style.display="none";
	document.getElementsByClassName("box2")[3].style.display="block";
	document.getElementsByClassName("field-content")[3].style.height=96+"px";
	document.getElementsByClassName("field")[3].style.height=157+"px";
}
function label_submit(){
	document.getElementsByClassName("box3")[3].style.display="block";
	document.getElementsByClassName("field-content")[3].style.height=36+"px";
	document.getElementsByClassName("field")[3].style.height=97+"px";
	document.getElementsByClassName("box2")[3].style.display="none";
	var input = document.getElementsByClassName("Input")[0].value;
	document.getElementsByClassName("amend-result")[3].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[3].style.display="none";
		document.getElementsByClassName("box1")[3].style.display="block";
	}
}
function label_change(){
	document.getElementsByClassName("box2")[3].style.display="block";
	document.getElementsByClassName("box3")[3].style.display="none";
	document.getElementsByClassName("field-content")[3].style.height=96+"px";
	document.getElementsByClassName("field")[3].style.height=157+"px";
}
function label_cancel(){
	document.getElementsByClassName("box2")[3].style.display="none";
	document.getElementsByClassName("box3")[3].style.display="block";
	document.getElementsByClassName("field-content")[3].style.height=36+"px";
	document.getElementsByClassName("field")[3].style.height=97+"px";
	var input = document.getElementsByClassName("Input")[0].value;
	document.getElementsByClassName("amend-result")[3].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[3].style.display="none";
		document.getElementsByClassName("box1")[3].style.display="block";
	}
}



function age_write(){
	document.getElementsByClassName("box1")[4].style.display="none";
	document.getElementsByClassName("box2")[4].style.display="block";
	document.getElementsByClassName("field-content")[4].style.height=96+"px";
	document.getElementsByClassName("field")[4].style.height=157+"px";
}
function age_submit(){
	document.getElementsByClassName("box3")[4].style.display="block";
	document.getElementsByClassName("box2")[4].style.display="none";
	document.getElementsByClassName("field-content")[4].style.height=36+"px";
	document.getElementsByClassName("field")[4].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[0].value;
	document.getElementsByClassName("amend-result")[4].innerHTML = input2;
	if (input2 == ""){
		document.getElementsByClassName("box3")[4].style.display="none";
		document.getElementsByClassName("box1")[4].style.display="block";
	}
}
function age_change(){
	document.getElementsByClassName("box2")[4].style.display="block";
	document.getElementsByClassName("box3")[4].style.display="none";
	document.getElementsByClassName("field-content")[4].style.height=96+"px";
	document.getElementsByClassName("field")[4].style.height=157+"px";
}
function age_cancel(){
	document.getElementsByClassName("box2")[4].style.display="none";
	document.getElementsByClassName("box3")[4].style.display="block";
	document.getElementsByClassName("field-content")[4].style.height=36+"px";
	document.getElementsByClassName("field")[4].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[0].value;
	document.getElementsByClassName("amend-result")[4].innerHTML = input2;
	if (input2 == ""){
		document.getElementsByClassName("box3")[4].style.display="none";
		document.getElementsByClassName("box1")[4].style.display="block";
	}
}





function birth_write(){
	document.getElementsByClassName("box1")[5].style.display="none";
	document.getElementsByClassName("box2")[5].style.display="block";
	document.getElementsByClassName("field-content")[5].style.height=96+"px";
	document.getElementsByClassName("field")[5].style.height=157+"px";
}
function birth_submit(){
	document.getElementsByClassName("box3")[5].style.display="block";
	document.getElementsByClassName("box2")[5].style.display="none";
	document.getElementsByClassName("field-content")[5].style.height=36+"px";
	document.getElementsByClassName("field")[5].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[1].value;
	var input3 = document.getElementsByClassName("Input2")[2].value;
	var input4 = document.getElementsByClassName("Input2")[3].value;
	document.getElementsByClassName("amend-result")[5].innerHTML = input2;
	document.getElementsByClassName("amend-result2")[0].innerHTML = input3;
	document.getElementsByClassName("amend-result3")[0].innerHTML = input4;
	if (input2 == "" && input3 == "" && input4 == ""){
		document.getElementsByClassName("box3")[5].style.display="none";
		document.getElementsByClassName("box1")[5].style.display="block";
	}
}
function birth_change(){
	document.getElementsByClassName("box2")[5].style.display="block";
	document.getElementsByClassName("box3")[5].style.display="none";
	document.getElementsByClassName("field-content")[5].style.height=96+"px";
	document.getElementsByClassName("field")[5].style.height=157+"px";
}
function birth_cancel(){
	document.getElementsByClassName("box2")[5].style.display="none";
	document.getElementsByClassName("box3")[5].style.display="block";
	document.getElementsByClassName("field-content")[5].style.height=36+"px";
	document.getElementsByClassName("field")[5].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[1].value;
	var input3 = document.getElementsByClassName("Input2")[2].value;
	var input4 = document.getElementsByClassName("Input2")[3].value;
	document.getElementsByClassName("amend-result")[5].innerHTML = input2;
	document.getElementsByClassName("amend-result2")[0].innerHTML = input3;
	document.getElementsByClassName("amend-result3")[0].innerHTML = input4;
	if (input2 == "" && input3 == "" && input4 == ""){
		document.getElementsByClassName("box3")[5].style.display="none";
		document.getElementsByClassName("box1")[5].style.display="block";
	}
}



function phone_write(){
	document.getElementsByClassName("box1")[6].style.display="none";
	document.getElementsByClassName("box2")[6].style.display="block";
	document.getElementsByClassName("field-content")[6].style.height=96+"px";
	document.getElementsByClassName("field")[6].style.height=157+"px";
}
function phone_submit(){
	document.getElementsByClassName("box3")[6].style.display="block";
	document.getElementsByClassName("box2")[6].style.display="none";
	document.getElementsByClassName("field-content")[6].style.height=36+"px";
	document.getElementsByClassName("field")[6].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[1].value;
	document.getElementsByClassName("amend-result")[6].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[6].style.display="none";
		document.getElementsByClassName("box1")[6].style.display="block";
	}
}
function phone_change(){
	document.getElementsByClassName("box2")[6].style.display="block";
	document.getElementsByClassName("box3")[6].style.display="none";
	document.getElementsByClassName("field-content")[6].style.height=96+"px";
	document.getElementsByClassName("field")[6].style.height=157+"px";
}
function phone_cancel(){
	document.getElementsByClassName("box2")[6].style.display="none";
	document.getElementsByClassName("box3")[6].style.display="block";
	document.getElementsByClassName("field-content")[6].style.height=36+"px";
	document.getElementsByClassName("field")[6].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[1].value;
	document.getElementsByClassName("amend-result")[6].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[6].style.display="none";
		document.getElementsByClassName("box1")[6].style.display="block";
	}
}



function email_write(){
	document.getElementsByClassName("box1")[7].style.display="none";
	document.getElementsByClassName("box2")[7].style.display="block";
	document.getElementsByClassName("field-content")[7].style.height=96+"px";
	document.getElementsByClassName("field")[7].style.height=157+"px";
}
function email_submit(){
	document.getElementsByClassName("box3")[7].style.display="block";
	document.getElementsByClassName("box2")[7].style.display="none";
	document.getElementsByClassName("field-content")[7].style.height=36+"px";
	document.getElementsByClassName("field")[7].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[2].value;
	document.getElementsByClassName("amend-result")[7].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[7].style.display="none";
		document.getElementsByClassName("box1")[7].style.display="block";
	}
}
function email_change(){
	document.getElementsByClassName("box2")[7].style.display="block";
	document.getElementsByClassName("box3")[7].style.display="none";
	document.getElementsByClassName("field-content")[7].style.height=96+"px";
	document.getElementsByClassName("field")[7].style.height=157+"px";
}
function email_cancel(){
	document.getElementsByClassName("box2")[7].style.display="none";
	document.getElementsByClassName("box3")[7].style.display="block";
	document.getElementsByClassName("field-content")[7].style.height=36+"px";
	document.getElementsByClassName("field")[7].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[2].value;
	document.getElementsByClassName("amend-result")[7].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[7].style.display="none";
		document.getElementsByClassName("box1")[7].style.display="block";
	}
}



function grade_write(){
	document.getElementsByClassName("box1")[8].style.display="none";
	document.getElementsByClassName("box2")[8].style.display="block";
	document.getElementsByClassName("field-content")[8].style.height=96+"px";
	document.getElementsByClassName("field")[8].style.height=157+"px";
}
function grade_submit(){
	document.getElementsByClassName("box3")[8].style.display="block";
	document.getElementsByClassName("box2")[8].style.display="none";
	document.getElementsByClassName("field-content")[8].style.height=36+"px";
	document.getElementsByClassName("field")[8].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[4].value;
	document.getElementsByClassName("amend-result")[8].innerHTML = input2;
	if (input2 == ""){
		document.getElementsByClassName("box3")[8].style.display="none";
		document.getElementsByClassName("box1")[8].style.display="block";
	}
}
function grade_change(){
	document.getElementsByClassName("box2")[8].style.display="block";
	document.getElementsByClassName("box3")[8].style.display="none";
	document.getElementsByClassName("field-content")[8].style.height=96+"px";
	document.getElementsByClassName("field")[8].style.height=157+"px";
}
function grade_cancel(){
	document.getElementsByClassName("box2")[8].style.display="none";
	document.getElementsByClassName("box3")[8].style.display="block";
	document.getElementsByClassName("field-content")[8].style.height=36+"px";
	document.getElementsByClassName("field")[8].style.height=97+"px";
	var input2 = document.getElementsByClassName("Input2")[4].value;
	document.getElementsByClassName("amend-result")[8].innerHTML = input2;
	if (input2 == ""){
		document.getElementsByClassName("box3")[8].style.display="none";
		document.getElementsByClassName("box1")[8].style.display="block";
	}
}




function class_write(){
	document.getElementsByClassName("box1")[9].style.display="none";
	document.getElementsByClassName("box2")[9].style.display="block";
	document.getElementsByClassName("field-content")[9].style.height=96+"px";
	document.getElementsByClassName("field")[9].style.height=157+"px";
}
function class_submit(){
	document.getElementsByClassName("box3")[9].style.display="block";
	document.getElementsByClassName("box2")[9].style.display="none";
	document.getElementsByClassName("field-content")[9].style.height=36+"px";
	document.getElementsByClassName("field")[9].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[3].value;
	document.getElementsByClassName("amend-result")[9].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[9].style.display="none";
		document.getElementsByClassName("box1")[9].style.display="block";
	}
}
function class_change(){
	document.getElementsByClassName("box2")[9].style.display="block";
	document.getElementsByClassName("box3")[9].style.display="none";
	document.getElementsByClassName("field-content")[9].style.height=96+"px";
	document.getElementsByClassName("field")[9].style.height=157+"px";

}
function class_cancel(){
	document.getElementsByClassName("box2")[9].style.display="none";
	document.getElementsByClassName("box3")[9].style.display="block";
	document.getElementsByClassName("field-content")[9].style.height=36+"px";
	document.getElementsByClassName("field")[9].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[3].value;
	document.getElementsByClassName("amend-result")[9].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[9].style.display="none";
		document.getElementsByClassName("box1")[9].style.display="block";
	}
}



function major_write(){
	document.getElementsByClassName("box1")[10].style.display="none";
	document.getElementsByClassName("box2")[10].style.display="block";
	document.getElementsByClassName("field-content")[10].style.height=96+"px";
	document.getElementsByClassName("field")[10].style.height=157+"px";
}
function major_submit(){
	document.getElementsByClassName("box3")[10].style.display="block";
	document.getElementsByClassName("box2")[10].style.display="none";
	document.getElementsByClassName("field-content")[10].style.height=36+"px";
	document.getElementsByClassName("field")[10].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[4].value;
	document.getElementsByClassName("amend-result")[10].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[10].style.display="none";
		document.getElementsByClassName("box1")[10].style.display="block";
	}
}
function major_change(){
	document.getElementsByClassName("box2")[10].style.display="block";
	document.getElementsByClassName("box3")[10].style.display="none";
	document.getElementsByClassName("field-content")[10].style.height=96+"px";
	document.getElementsByClassName("field")[10].style.height=157+"px";
}
function major_cancel(){
	document.getElementsByClassName("box2")[10].style.display="none";
	document.getElementsByClassName("box3")[10].style.display="block";
	document.getElementsByClassName("field-content")[10].style.height=36+"px";
	document.getElementsByClassName("field")[10].style.height=97+"px";
	var input = document.getElementsByClassName("Input3")[4].value;
	document.getElementsByClassName("amend-result")[10].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[10].style.display="none";
		document.getElementsByClassName("box1")[10].style.display="block";
	}
}



function hobby_write(){
	document.getElementsByClassName("box1")[11].style.display="none";
	document.getElementsByClassName("box2")[11].style.display="block";
	document.getElementsByClassName("field-content")[11].style.height=96+"px";
	document.getElementsByClassName("field")[11].style.height=157+"px";
}
function hobby_submit(){
	document.getElementsByClassName("box3")[11].style.display="block";
	document.getElementsByClassName("field-content")[11].style.height=36+"px";
	document.getElementsByClassName("field")[11].style.height=97+"px";
	document.getElementsByClassName("box2")[11].style.display="none";
	var input = document.getElementsByClassName("Input")[1].value;
	document.getElementsByClassName("amend-result")[11].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[11].style.display="none";
		document.getElementsByClassName("box1")[11].style.display="block";
	}
}
function hobby_change(){
	document.getElementsByClassName("box2")[11].style.display="block";
	document.getElementsByClassName("box3")[11].style.display="none";
	document.getElementsByClassName("field-content")[11].style.height=96+"px";
	document.getElementsByClassName("field")[11].style.height=157+"px";
}
function hobby_cancel(){
	document.getElementsByClassName("box2")[11].style.display="none";
	document.getElementsByClassName("box3")[11].style.display="block";
	document.getElementsByClassName("field-content")[11].style.height=36+"px";
	document.getElementsByClassName("field")[11].style.height=97+"px";
	var input = document.getElementsByClassName("Input")[1].value;
	document.getElementsByClassName("amend-result")[11].innerHTML = input;
	if (input == ""){
		document.getElementsByClassName("box3")[11].style.display="none";
		document.getElementsByClassName("box1")[11].style.display="block";
	}
}


function submit(){
	var sex = $("input[name='gender']:checked").val();
	var direction = $("input[name='direction']:checked").val();
	var name = $("#name").val();
	var label = $("#label").val();
	var age = $("#age").val();
	var year = $("#year").val();
	var month = $("#month").val();
	var day = $("#day").val();
	var phone = $("#phone").val();
	var email = $("#email").val();
	var grade = $("#grade").val();
	var classmate = $("#classmate").val();
	var major = $("major").val();
	var hobby = $("#hobby").val();
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/personage",
		async:false,
		dataType:"json",
		contentType:"application/x-www-form-urlencoded",
		xhrFields: {
			withCredentials: true
	   },
	   crossDomain: true,
		data:{
			"sex":sex,
			"direction":direction,
			"name": name,
			"label":label,
			"age":age,
			"year":year,
			"month":month,
			"day":day,
			"phone":phone,
			"email":email,
			"grade":grade,
			"classmate":classmate,
			"major":major,
			"hobby":hobby,

		},
		success:function(stateNum){
			var number = parseInt(stateNum.personage);
			switch(number){
				case 0:alert("提交失败"); break;
				case 1:alert("提交成功");break;
				default:alert("未知错误！");
			}
		},
		error:function(){
			alert(stateNum.personage);
		}
	});
}
window.onload=username;
function username(){
	var username = $(".username").text();
	$.ajax({ 
		type:"Get", 
		url:"http://localhost:8080/clintUserName", 
		data:{"username":username},  
		async : false,  
		dataType : "json",  
		success : function(data) {  
		for(var i = 0; i < data.length; i++) {  
			 var datas = data[i];  
			 $(".username").append("<p>"+datas.email+"</p>")
		}  
		}  
	});
}