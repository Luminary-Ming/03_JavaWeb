package login_register.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String free = req.getParameter("free");
        // 判断账号为空
        if (account == null || account.trim().equals("")) {
            resp.getWriter().write("账号不能为空");
            return;
        }
        // 判断密码为空
        if (password == null || password.trim().equals("")) {
            resp.getWriter().write("密码不能为空");
            return;
        }
        // 判断账号密码是否正确
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo", "root", "leesin");
            String sql = "select * from account where account = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, account);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // 如果勾选 10 天免登录就存到 Cookie 里
                if (free != null && "free".equals(free)){
                    Cookie cookie1 = new Cookie("account",account);
                    Cookie cookie2 = new Cookie("password",password);
                    // 设置 10 天过期
                    cookie1.setMaxAge(864000);
                    cookie2.setMaxAge(864000);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
                }
                    resp.getWriter().write("登录成功");
            } else {
                resp.getWriter().write("账号或密码不正确");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
