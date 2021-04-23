// 登陆验证
$(function (){
    $.get("/consumer/checkLogin",function (e){
        if (!e){
            // 未登陆
            alert("未登录，将跳转到登录页面！")
            window.location.href = "/page/task03";
        }
    },"json");
});