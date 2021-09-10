package util.jdbcTest;

import java.util.Objects;

public class Examstudent {
    private int id;
    private int type;
    private String idCard;
    private String examCard;
    private String studentName;
    private String location;
    private int grade;

    public Examstudent() {
    }

    public Examstudent(int id, int type, String idCard, String examCard, String studentName, String location, int grade) {
        this.id = id;
        this.type = type;
        this.idCard = idCard;
        this.examCard = examCard;
        this.studentName = studentName;
        this.location = location;
        this.grade = grade;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examstudent that = (Examstudent) o;
        return id == that.id && type == that.type && grade == that.grade && Objects.equals(idCard, that.idCard) && Objects.equals(examCard, that.examCard) && Objects.equals(studentName, that.studentName) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, idCard, examCard, studentName, location, grade);
    }
    @Override
    public String toString() {
        return "流水号:" + id +
                "\n四级/六级:" + type +
                "\n身份证:" + idCard +
                "\n准考证号:" + examCard +
                "\n学生姓名:" + studentName +
                "\n区域:" + location +
                "\n成绩:" + grade;
    }
}
