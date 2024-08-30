package zxm.homework.questionnaire.service;

import zxm.homework.questionnaire.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    /**
     * 向数据库添加问卷收集到的信息
     */
    public Boolean addStudent(Student student);

    /**
     * 查询数据库中的已填写的问卷
     */
    public List<Student> StudentList();
}
