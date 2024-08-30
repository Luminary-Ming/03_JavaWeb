<%--
  Created by IntelliJ IDEA.
  User: Luminary
  Date: 2024/8/24
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>大学生消费情况调查问卷</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        input {
            outline: 0;
        }

        p {
            font-size: 32px;
            font-weight: 900;
            color: #1ea0fa;
            margin-bottom: 15px;
        }

        form {
            margin-top: 30px;
        }

        .box {
            width: 600px;
            margin: 0 auto;
            margin-top: 30px;
        }

        .nameInput input {
            width: 200px;
            height: 30px;
            font-size: 16px;
        }

        .testarea_box textarea {
            vertical-align: bottom;
            width: 200px;
            height: 40px;
        }

        .interval {
            margin-bottom: 20px;
        }

        button {
            font-size: 16px;
            width: 150px;
            height: 30px;
            color: #fff;
            background-color: #1ea0fa;
            border-radius: 10px;
            border: 0;
            cursor: pointer;
        }
    </style>

</head>

<body>
<div class="box">
    <p>大学生消费情况调查问卷</p>
    <hr class="hr1">
    <%--
            action的路径是发出请求后，收到请求并处理请求的Servlet的路径
            两种书写方式：
                1. 基于协议的全路径（绝对路径）：http://localhost:8080/JavaWeb/questionnaire
                2. 基于项目的根路径（相对路径）：/JavaWeb/questionnaire
      --%>
    <form action="/JavaWeb/questionnaire" method="get">
        <div class="interval nameInput">1. 您的专业：<input type="text" name="major"></div>
        <div class="interval setRadio">2. 您的性别：<br>
            &emsp;<input type="radio" name="sex" value="男">&nbsp;男<br>
            &emsp;<input type="radio" name="sex" value="女">&nbsp;女<br>
        </div>
        <div class="interval setRadio">3. 每月用于零食及校外饮食的费用：<br>
            &emsp;<input type="radio" name="eat" value="无">&nbsp;无<br>
            &emsp;<input type="radio" name="eat" value="1-200">&nbsp;1-200<br>
            &emsp;<input type="radio" name="eat" value="200-500">&nbsp;200-500<br>
            &emsp;<input type="radio" name="eat" value="500以上">&nbsp;500以上<br>
        </div>
        <div class="interval setRadio">4. 今年双11您打算花费多少钱在网购上：<br>
            &emsp;<input type="radio" name="onlineShopping" value="不网购">&nbsp;不网购<br>
            &emsp;<input type="radio" name="onlineShopping" value="300-800">&nbsp;300-800<br>
            &emsp;<input type="radio" name="onlineShopping" value="800-1500">&nbsp;800-1500<br>
            &emsp;<input type="radio" name="onlineShopping" value="1500以上">&nbsp;1500以上<br>
        </div>
        <div class="interval setRadio">5. 每学期用于购买学习资料、课外读物的费用：<br>
            &emsp;<input type="radio" name="study" value="无">&nbsp;无<br>
            &emsp;<input type="radio" name="study" value="1-50">&nbsp;1-50<br>
            &emsp;<input type="radio" name="study" value="50-200">&nbsp;50-200<br>
            &emsp;<input type="radio" name="study" value="200以上">&nbsp;200以上<br>
        </div>
        <div class="interval checkbox">6. 消费来源：<br>
            &emsp;<input type="checkbox" name="pay" value="交通通讯">&nbsp;&nbsp;交通通讯<br>
            &emsp;<input type="checkbox" name="pay" value="生活用品">&nbsp;&nbsp;生活用品<br>
            &emsp;<input type="checkbox" name="pay" value="学习用品">&nbsp;&nbsp;学习用品<br>
            &emsp;<input type="checkbox" name="pay" value="娱乐旅游">&nbsp;&nbsp;娱乐旅游<br>
            &emsp;<input type="checkbox" name="pay" value="吃吃喝喝">&nbsp;&nbsp;吃吃喝喝<br>
        </div>
        <div class="testarea_box">
            7. 其他开支：<textarea name="otherPay"></textarea>
        </div>
        <br>
        <button type="submit">提交问卷</button>
    </form>
</div>

</body>

</html>
