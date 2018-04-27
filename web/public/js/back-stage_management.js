$(document).ready(function(){
	//向表格中加入数据
	$.ajax({
				type:"GET",
				url:"users.json",
				dataType:"jsonp",
				success:function(json){
					var tbody = "";
					$.each(json,function(index,person){
						var megs = "<tr>";
						//加入头衔
						switch(person.state){
							case 0:megs += "<td><div class='ui blue ribbon label'>成员</div></td>";break;
							case 1:meg += "<td><div class='ui red ribbon label'>管理员</div></td>";break;
							case 2:megs = "<td><div class='ui orange ribbon label'>超级管理员</div></td>";break;
							default:break;
						}
						megs += "<td>"+ person.username+"</td>" ;
						megs += "<td>"+ person.id+"</td>" ;
						megs += "<td>"+ person.e_mail+"</td>" ;
						megs += "<td>"+ person.sex+"</td>" ;
						megs += "<td>"+ person.phone_number+"</td>" ;
						megs += "<td>"+ person.major+"</td>" ;
						megs += "<td>"+ person.class_number+"</td>" ;
						megs += "<td>"+ person.study_direction+"</td>" ;
						megs += "<td>"+ person.age+"</td>" ;
						megs += "<td>"+ person.birth+"</td>" ;
						megs += "<td>"+ person.habit+"</td>" ;
						megs += "<td><button class='tiny ui button rechangePassword'  data-tooltip='更改为默认密码' data-position='right center' ><img class='ui mini image' src='../public/img/rePassword.png' onclick='rechangePassword()'></button></td>";
						megs += "</tr>";
					tbody += megs;
				});
				$("#inforTable").children("tbody").append(tbody);
			}
		});
	//获取所有的表格页
	var tablePages = $('.tbodys');
	//只显示第一页
	$('.tbodys:gt(0)').hide();
	//获取当前页码的索引值
	//加载窗口实时消失
	if (document.readyState == "complete") {
		$('.loading').fadeOut();
	}
	//实现点击按钮上传
	$("#fileInput").click(function(){
		$("#upload").click();
	});
	var tablePageNum = $("#tablePage").children(".active.item").index();
	//实现点击换页
	$('#tablePage').children('a').click(function(){
		//获取点击的页码
		var curPageNum = $(this).index();
		$("#tablePage").children("a").removeClass('active');
		$('#tablePage').children('a').eq(curPageNum).addClass('active');
		tablePages.eq(tablePageNum).hide();
		tablePageNum = curPageNum;	
		tablePages.eq(tablePageNum).show();	
	});
	//实现向前翻页功能
	$("#prevTablePage").click(function(){
		if (tablePageNum == 0) {
			return false;
		}
		else {
			tablePages.eq(tablePageNum).hide();
			tablePageNum--;
			$("#tablePage").children("a").removeClass('active');
			$('#tablePage').children('a').eq(tablePageNum).addClass('active');
			tablePages.eq(tablePageNum).show();
		}
	});	
	//实现向后翻页
	$("#nextTablePage").click(function(){
		if (tablePageNum == 3) {
			return false;
		}
		else {
			tablePages.eq(tablePageNum).hide();
			tablePageNum++;
			$("#tablePage").children("a").removeClass('active');
			$('#tablePage').children('a').eq(tablePageNum).addClass('active');
			tablePages.eq(tablePageNum).show();
		}
	});		
});
//点击修改密码
    var rechangePassword = function(){
			$.ajax({
				type:"GET",
				url:"",
				dataType:"jsonp",
				success:function(json){
					alert(json.word);
				},
				error:function(jqXHR){
					alert("ERROR!");
				}
			});
}

