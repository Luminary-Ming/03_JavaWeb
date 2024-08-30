package com.check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取客户端用户输入的验证码数据
        String codeImg = req.getParameter("codeImg");
        // 获取 session 中存储的数据
        String randomImg = (String) req.getSession().getAttribute("randomImg");

        /**
         *  表单重复提交：页面的表单提交之后，用户再次点击刷新按钮或者F5等操作，浏览器默认会将上一次表单提交的数据再提交一次。
         */
        // 立刻从 session 中删除存储的验证码（保证验证码的二次利用）
        req.getSession().removeAttribute("randomImg");

        // 判断提交的验证码是否为空
        if (codeImg == null || codeImg.trim().equals("")) {
            resp.getWriter().write("验证码不能为空");
            return;
        }
        // 判断提交的验证码和session中的随机验证码是否相同
        if (!codeImg.equalsIgnoreCase(randomImg)) {
            resp.getWriter().write("验证码输入错误");
            return;
        }
        resp.getWriter().write("验证码通过");
    }
}
