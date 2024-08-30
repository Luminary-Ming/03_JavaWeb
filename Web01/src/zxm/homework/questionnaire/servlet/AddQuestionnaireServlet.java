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
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 收集问卷信息到数据库中
 */
@WebServlet(urlPatterns = "/questionnaire")
public class AddQuestionnaireServlet extends HttpServlet {
    private static final StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String major = req.getParameter("major");
        System.out.println(major);
        String sex = req.getParameter("sex");
        System.out.println(sex);
        String eat = req.getParameter("eat");
        System.out.println(eat);
        String onlineShopping = req.getParameter("onlineShopping");
        System.out.println(onlineShopping);
        String study = req.getParameter("study");
        System.out.println(study);
        // 获取客户端提交的一个key对应多个value的情况
        String[] payArr = req.getParameterValues("pay");
        System.out.println(Arrays.toString(payArr));
        String otherPay = req.getParameter("otherPay");
        System.out.println(otherPay);

        Student student = new Student();
        student.setMajor(major);
        student.setSex(sex);
        student.setEat(eat);
        student.setOnlineShopping(onlineShopping);
        student.setStudy(study);
        student.setPay(payArr);
        student.setOtherPay(otherPay);
        Boolean b = studentService.addStudent(student);
        resp.setContentType("text/html;charset=utf-8");
        if (b) {
            resp.getWriter().write("<h1>感谢你的配合！</h1>");
        }else {
            resp.getWriter().write("<h1>提交失败，请重试！</h1>");
        }


        // 获取请求中提交的数据的所有key
        Enumeration<String> en = req.getParameterNames();
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
        System.out.println("----------------------------");
        // 获取客户端提交的数据，将key=value的数据存储在map集合中
        Map<String, String[]> map = req.getParameterMap();

        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        for (Map.Entry<String ,String[]> entry : entrySet){
            System.out.println(entry.getKey() +" = "+Arrays.toString( entry.getValue()));
        }

    }
}
