<%--
  Created by IntelliJ IDEA.
  User: Luminary
  Date: 2024/8/22
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        table {
            /* 表格边框合并 */
            border-collapse: collapse;
            margin: 0 auto;
            width: 500px;
            height: 300px;
            margin-top: 80px;
        }

        td {
            padding: 10px 30px;
            border: 1px solid rgb(12, 214, 39);
        }

        /* 表格偶数行变色 */
        table tr:nth-child(2n) {
            background-color: rgb(172, 131, 182);
        }

        /* 表格奇数行变色 */
        table tr:nth-child(2n-1) {
            background-color: rgb(213, 233, 98);
        }

        table tr:hover {
            /* 鼠标悬停在表格上时变背景颜色 */
            background-color: antiquewhite;
        }
        .questionnaire{
            font-size: 32px;
            position: relative;
            color: #1ea0fa;
            top: 80px;
            left: 120px;

        }
    </style>
</head>

<body>
<a href="/JavaWeb/questionnaire.jsp" class="questionnaire">点击跳转大学生调查问卷</a>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>电话</td>
    </tr>
    <tr>
        <td>亚索</td>
        <td>20</td>
        <td>艾欧尼亚</td>
        <td>111</td>
    </tr>
    <tr>
        <td>沃利贝尔</td>
        <td>20</td>
        <td>弗雷尔卓德</td>
        <td>222</td>
    </tr>
    <tr>
        <td>沃里克</td>
        <td>20</td>
        <td>祖安</td>
        <td>333</td>
    </tr>
    <tr>
        <td>盖伦</td>
        <td>20</td>
        <td>德玛西亚</td>
        <td>444</td>
    </tr>

</table>
</body>

</html>
