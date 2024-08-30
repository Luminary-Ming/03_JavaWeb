package zxm.homework.questionnaire.servlet;

import zxm.homework.questionnaire.pojo.Student;
import zxm.homework.questionnaire.service.StudentService;
import zxm.homework.questionnaire.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 查看数据库中已填写的问卷
 */
@WebServlet(urlPatterns = "/list")
public class ListQuestionnaireServlet extends HttpServlet {
    private static final StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String major = req.getParameter("major");
//        String sex = req.getParameter("sex");
//        String eat = req.getParameter("eat");
//        String onlineShopping = req.getParameter("onlineShopping");
//        String study = req.getParameter("study");
//        String[] payArr = req.getParameterValues("pay");
//        String otherPay = req.getParameter("otherPay");
        resp.setContentType("text/html;charset=utf-8");
        List<Student> students = studentService.StudentList();
        resp.getWriter().write( students.toString());
    }
}
