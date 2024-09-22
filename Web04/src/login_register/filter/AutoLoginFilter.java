package login_register.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;

@WebFilter("/login.html")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将 servletRequest 转成 HttpServletRequest 请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取请求中携带的 Cookie 信息
        Cookie[] cookies = request.getCookies();
        Cookie accountCookie = getCookie(cookies,"account");
        Cookie passwordCookie = getCookie(cookies,"password");

        if(accountCookie != null && passwordCookie!= null){
            String account = accountCookie.getValue();
            String password = passwordCookie.getValue();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn  = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo","root","leesin");
                String sql = "select * from account where account = ? and password = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,account);
                stmt.setString(2,password);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    System.out.println(1);
                    servletResponse.getWriter().write("登录成功呀");
                }else{
                    // 放行
                    filterChain.doFilter(request,servletResponse);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            // 放行
            filterChain.doFilter(request,servletResponse);
        }
    }
    // 获得 Cookie 的方法
    private Cookie getCookie (Cookie[]cookies, String cookieName){
        if(cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName)){
                return cookie;
            }
        }
        return null;
    }
}
