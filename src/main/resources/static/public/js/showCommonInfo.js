$(document).ready(function(){
    getImg();
    $('#userImg').click(function () {
        toPersonPage($('#userName').text());
    });
    $('#userName').click(function () {
        toPersonPage($('#userName').text());
    })
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
    window.location.href="personage.html?username" + username;
}