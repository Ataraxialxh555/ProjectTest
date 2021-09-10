package Day5_9;

public class Test1 {
    public static void main(String[] args) {
        Student s1= new Student(20,"张三",20001);
        System.out.println("年龄："+s1.getAge()+"姓名："+s1.getName()+"学号："+s1.getNo());
    }
}
class People{
    private int age;
    private String name;
    public People(){}
    public People(int age,String name ){
        this.age = age;
        this.name =name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setName(String name ){
        this.name = name ;
    }
    public String getName(){
        return name;
    }
    public void speak(){
        System.out.println(this.name+"说话！！！");
    }
}
class Student extends People{
    private int no;
    public Student(){

    }
    public Student(int age,String name,int no){
        super(age,name);
        this.no = no;
    }

    public void setNo(int no){
        this.no = no;
    }
    public int getNo(){
        return no;
    }

    public void speak(){
        System.out.println(this.getName()+"上课发言");
    }
}