package zxm.homework.questionnaire.dao.impl;

import cn.hutool.db.Db;
import zxm.homework.questionnaire.dao.StudentDao;
import zxm.homework.questionnaire.pojo.Student;
import zxm.homework.questionnaire.utill.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    /**
     * 向数据库添加问卷收集到的信息
     */
    @Override
    public Boolean addStudent(Student student) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into survey values(null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,student.getMajor());
        stmt.setString(2,student.getSex());
        stmt.setString(3,student.getEat());
        stmt.setString(4,student.getOnlineShopping());
        stmt.setString(5,student.getStudy());
        stmt.setString(6, Arrays.toString(student.getPay()));
        stmt.setString(7,student.getOtherPay());
        int i = stmt.executeUpdate();
        return i > 0;
    }

    /**
     * 查询数据库中的已填写的问卷
     */
    @Override
    public List<Student> StudentList() throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        List<Student> query = Db.use(ds).query("select * from survey", Student.class, null);
        return query;
    }


}
