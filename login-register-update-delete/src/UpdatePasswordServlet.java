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

/**
 * 修改密码
 */
@WebServlet(urlPatterns = "/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String rePassword = req.getParameter("rePassword");
        // 获得属性
        ServletContext context = req.getServletContext();
        String id = context.getAttribute("id").toString();
        String password = context.getAttribute("password").toString();

        if(!password.equals(oldPassword)){
            resp.getWriter().write("输入的旧密码不正确！");
        }
        if(newPassword == null || "".equals(newPassword)){
            resp.getWriter().write("新密码不能为空！");
        }
        if(!newPassword.equals(rePassword)){
            resp.getWriter().write("两次密码不一致！");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo","root","leesin");
            String sql = "update admin set password = ? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,newPassword);
            stmt.setInt(2,Integer.valueOf(id));
            int i = stmt.executeUpdate();
            if(i>0){
                resp.getWriter().write("修改成功！");
            }else {
                resp.getWriter().write("修改失败！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
