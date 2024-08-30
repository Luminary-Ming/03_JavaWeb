import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 删除密码
 */
@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        // 获取属性
        ServletContext context = req.getServletContext();
        String id = context.getAttribute("id").toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo", "root", "leesin");
            String sql = "delete from admin where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.valueOf(id));
            int i = stmt.executeUpdate();
            if (i>0){
                resp.getWriter().write("删除账户成功！");
                resp.getWriter().write("<p><a href='login.html'>返回登录界面</a></p>");
            }else{
                resp.getWriter().write("删除账户失败！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
