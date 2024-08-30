import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.multi.MultiSliderUI;
import java.io.IOException;
import java.sql.*;

/**
 * 登录
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        // 从客户端接收数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 判断账号是否为空
        if (username == null || "".equals(username.trim())) {
            resp.getWriter().write("账号不能为空！");
        }
        // 判断密码是否为空
        if (password == null || "".equals(password.trim())) {
            resp.getWriter().write("密码不能为空！");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo", "root", "leesin");
            String sql = "select * from admin where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                resp.getWriter().write("登录成功！");
                // 修改密码
                resp.getWriter().write("<p><a href='updatePassword.html'>点击修改密码</a></p>");
                // 注销账号
                resp.getWriter().write("<p><a href='deleteUser.html'>删除账户</a></p>");

                // 获得id
                int id = rs.getInt("id");

                // ServletContext对象：每一个项目都是一个ServletContext对象，全局最大的共享容器，一般不用。
                ServletContext context = req.getServletContext();
                // 设置属性
                context.setAttribute("password", password);
                context.setAttribute("id",id);
            } else {
                resp.getWriter().write("登录失败！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
