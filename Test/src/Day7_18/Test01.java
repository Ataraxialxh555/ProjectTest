package Day7_18;

public class Test01 {
    public static void main(String[] args) {
        Student s1 = new Student("2112004135","lxh",88,66,99);
        System.out.println("学号："+s1.getStuno());
        System.out.println("姓名："+s1.getName());
        System.out.println("数学成绩："+s1.getMath());
        System.out.println("英语成绩："+s1.getEnglish());
        System.out.println("计算机成绩："+s1.getComputer());
        System.out.println("最大值："+s1.max());
        System.out.println("最小值："+s1.min());
        System.out.println("总分："+s1.sum());
        System.out.println("平均值："+s1.avg());
    }
}

class Student{
    private String  stuno;
    private String name ;
    private float math;
    private float english;
    private float computer;
    public Student(){

    }
    public Student(String stuno,String name,float math,float english,float computer){
        this.stuno = stuno;
        this.name = name;
        this.english = english;
        this.math = math;
        this.computer = computer;
    }
    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMath() {
        return math;
    }
    public void setMath(float math){
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getComputer() {
        return computer;
    }

    public void setComputer(float computer) {
        this.computer = computer;
    }
    public float avg(){
        return (getMath()+getComputer()+getEnglish())/3;
    }

    public float sum(){
        return getMath()+getComputer()+getEnglish();

    }

    public float max(){
        float max = getMath();
        if (max < getEnglish()){
            max = getEnglish();
        }
        if (max < getComputer()){
            max  = getComputer();
        }
        return max;
    }
    public float min(){
        float min = getMath();
        if (min > getEnglish()){
            min = getEnglish();
        }
        if (min > getComputer()){
            min  = getComputer();
        }
        return min;
    }

}