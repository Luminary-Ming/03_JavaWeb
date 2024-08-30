<%--
  Created by IntelliJ IDEA.
  User: Luminary
  Date: 2024/8/28
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Web03/check">
    <p>
        验证码:<input type="text" name="codeImg"/>
        <img src="/Web03/captcha"/>
        <a href="javascript:void(0)" class="get-code">看不清，换一张</a>
    </p>
    <p>
        <button type="submit">提交</button>
    </p>

    <script>
        // 在点击超链接的时候，重新请求生成验证码的servlet程序，获取新的图片
        let a = document.querySelector(".get-code");
        a.addEventListener("click",function(){
            // 需要给img重新加载新的图片
            // 浏览器默认在加载图片的时候，如果图片的地址相同，浏览器不会去发出新的请求
            document.querySelector('img').src = '/Web03/captcha?'+new Date().getTime();
        });
    </script>
</form>
</body>
</html>
