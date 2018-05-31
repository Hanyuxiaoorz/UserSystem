$(document).ready(function(){
    //显示用户名
    //$("#userName").text(CookieUtil.get("user"));
    //向表格中加入数据
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/backstageManagement/userInfo",
        async:false,
        dataType:"json",
        // xhr: function () {
        //  			var xhr = new window.XMLHttpRequest();
        //  			//Download progress
        //  			xhr.addEventListener("progress", function (evt) {
        //      			if (evt.lengthComputable) {
        //      			    var percentComplete = evt.loaded / evt.total;
        //      			    progressElem.html(Math.round(percentComplete * 100) + "%");
        //      			}
        //  			}, false);
        //  			return xhr;
        // },

        success:function(json){
            var tbody = "";
            //遍历对象
            $.each(json.userInfo,function(index,person){
                var userName = person.userName;
                var megs = "<tr class = 'userTr' onclick=herfView("+ person.id +")>";
                //加入头衔
                switch(person.state){
                    case 0:megs += "<td><div class='ui blue ribbon label'>成员</div></td>";break;
                    case 1:megs += "<td><div class='ui red ribbon label'>管理员</div></td>";break;
                    case 2:megs += "<td><div class='ui orange ribbon label'>超级管理员</div></td>";break;
                    default:break;
                }
                megs += "<td>"+ person.userName+"</td>" ;
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
                megs += "</tr>";
                tbody += megs;
            });
            $("#inforTable").children("tbody").append(tbody);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.responseText);
            console.log(thrownError);
        }
    });
    //获取所有的表格页
    var tablePages = $('.tbodys');
    //只显示第一页
    $('.tbodys:gt(0)').hide();
    //获取当前页码的索引值
    //加载窗口实时消失
    $('.loading').fadeOut();
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
//跳转至单个用户信息界面
function herfView(id){
    window.location.href="viewUsers.html?id=" + id;
}
//检查传入数据是否为空
function checkIsNull(content){
    if(content){
        return content;
    }
    else{
        return "无";
    }
}
