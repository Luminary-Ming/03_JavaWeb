package zxm.homework.questionnaire.pojo;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private Integer id;
    private String major;
    private String sex;
    private String eat;
    private String onlineShopping;
    private String study;
    private String[] pay;
    private String otherPay;

    @Override
    public String toString() {
        return "大学生消费调查问卷收集表：{" +
                "编号：" + id +
                ", 1. 您的专业：'" + major + '\'' +
                ", 2. 您的性别：'" + sex + '\'' +
                ", 3. 每月用于零食及校外饮食的费用：'" + eat + '\'' +
                ", 4. 今年双11您打算花费多少钱在网购上：'" + onlineShopping + '\'' +
                ", 5. 每学期用于购买学习资料、课外读物的费用：'" + study + '\'' +
                ", 6. 消费来源：" + Arrays.toString(pay) +
                ", 7. 其他开支：'" + otherPay + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(major, student.major) && Objects.equals(sex, student.sex) && Objects.equals(eat, student.eat) && Objects.equals(onlineShopping, student.onlineShopping) && Objects.equals(study, student.study) && Arrays.equals(pay, student.pay) && Objects.equals(otherPay, student.otherPay);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, major, sex, eat, onlineShopping, study, otherPay);
        result = 31 * result + Arrays.hashCode(pay);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getOnlineShopping() {
        return onlineShopping;
    }

    public void setOnlineShopping(String onlineShopping) {
        this.onlineShopping = onlineShopping;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String[] getPay() {
        return pay;
    }

    public void setPay(String[] pay) {
        this.pay = pay;
    }

    public String getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(String otherPay) {
        this.otherPay = otherPay;
    }
}
