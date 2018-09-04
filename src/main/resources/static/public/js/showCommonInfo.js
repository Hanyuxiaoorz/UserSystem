$(document).ready(function(){
    getImg();
    $('#userImg').click(function () {
        toPersonPage($('#userName').text());
    });
    $('#userName').click(function () {
        toPersonPage($('#userName').text());
    })
    //联系我们
    $('#contactUs').click(function(){
        contactUs();
    });
});

//获取用户头像
function getImg(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/userPhoto",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        contentType: "application/json",
        dataType:"json",
        success:function(json){
            console.log(json);
            if(json.userPhoto == 0){
                console.log("头像获取失败");
            }
            else if(json.userPhoto == 4){
                console.log("头像不存在");
            }
            else{
            $('#userImg').attr('src',json.userPhoto);
            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.responseText);
            console.log(thrownError);
        }
    });
}
function getUserName(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/clientUserName",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        contentType: "application/json",
        dataType:"json",
        success:function(json){
            $("#userName").text(json.clientUserName);
        },
        error: function (xhr, ajaxOptions, thrownError) {
/*            console.log(xhr.responseText);
            console.log(thrownError);*/
        }
    })
}

//注销登录
function logOut(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/loginOut",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        contentType: "application/json",
        success:function(){
            alert("已成功注销！");
            window.location.href="http://localhost:8080/login.html"
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.responseText);
            console.log(thrownError);
        }
    });
}

//点击用户名和头像跳转
function  toPersonPage(username){
    window.location.href="personAge.html";
}
//联系我们
function contactUs(){
    $('#contactUsModal')
    .modal({
        onApprove : function() {
            uploadContactContent();
          }
    })
    .modal('show');
}
//上传联系内容
function uploadContactContent(){
    $('#contactUsModal')
    .modal('hide');
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/contactUs",
        data:{
            "contactTitle": $('#contactTitle').val(),
            "contactContent": $('#contactContent').val()
        },
        dataType:"json",
        contentType:"application/json",
        success:function(){
            $('#contactTitle').val('');
            $('#contactContent').val('');
            setTimeout(function(){
                $('#successModal')
                .modal('show')
            },2000)
            setTimeout(function(){
                $('#successModal')
                .modal('hide'); 
            },3000);
        },
        error:function(err){
            console.error(err);
        }
    })
}