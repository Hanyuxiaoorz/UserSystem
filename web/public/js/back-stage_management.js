$(document).ready(function(){
	//实现点击按钮上传
	$("#fileInput").click(function(){
		$("#upload").click();
	});
	//获取所有的表格页
	var tablePages = $('.tbodys');
	//只显示第一页
	$('.tbodys:gt(0)').hide();
	//获取当前页码的索引值
	var tablePageNum = $("#tablePage").children(".active.item").index();
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
	//左侧侧边栏的点击动画
});
