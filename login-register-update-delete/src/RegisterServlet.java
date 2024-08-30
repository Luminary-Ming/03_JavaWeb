import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

/**
 * 注册
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        // 从客户端接收数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        String sex = req.getParameter("sex");
        String[] hobbyArr = req.getParameterValues("hobby");

        // 判断账号是否为空
        if (username == null || "".equals(username.trim())) {
            resp.getWriter().write("账号不能为空！");

        }
        // 判断密码是否为空
        if (password == null || "".equals(password.trim())) {
            resp.getWriter().write("密码不能为空！");
        }

        if (!password.equals(rePassword)) {
            resp.getWriter().write("两次密码不一致！");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo", "root", "leesin");
            String sql = "insert into admin values(null, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, sex);
            stmt.setString(4, Arrays.toString(hobbyArr));
            int i = stmt.executeUpdate();
            if (i>0){
                resp.getWriter().write("注册成功！");
                resp.getWriter().write("<p><a href='login.html'>转到登录</a></p>");
            }else{
                resp.getWriter().write("注册失败！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
