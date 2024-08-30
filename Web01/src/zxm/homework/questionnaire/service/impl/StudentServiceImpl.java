package zxm.homework.questionnaire.service.impl;

import zxm.homework.questionnaire.dao.StudentDao;
import zxm.homework.questionnaire.dao.impl.StudentDaoImpl;
import zxm.homework.questionnaire.pojo.Student;
import zxm.homework.questionnaire.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final StudentDao studentDao = new StudentDaoImpl();

    /**
     * 向数据库添加问卷收集到的信息
     */
    @Override
    public Boolean addStudent(Student student) {
        try {
            return studentDao.addStudent(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询数据库中的已填写的问卷
     */
    @Override
    public List<Student> StudentList() {
        try {
            return studentDao.StudentList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}