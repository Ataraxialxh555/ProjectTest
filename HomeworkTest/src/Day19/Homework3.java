package Day19;

public class Homework3 {
    public static void main(String[] args) {
        Virus v = new Virus("感冒病毒",0.222,"柱状");
        People p = new People("张三",29,"男");
        v.attack(p);
    }
}
class People{
    private String name;
    private int age ;
    private String sex;

    public People(String name, int age, String  sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String  isSex() {
        return sex;
    }

    public void setSex(String  sex) {
        this.sex = sex;
    }

    public void ill(){
        System.out.println(name+","+sex+","+age+"生病了");
    }
}

class Virus{
    private String name;
    private double size;
    private String type;

    public Virus(String name, double size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public Virus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void attack(People people){
        people.ill();
    }
}