package Day7_18;

public class Test02 {
    public static void main(String[] args) {

    }
}

class Person{
    private String name;
    private static String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Person.country = country;
    }
    public static void  doSome(String c ){
//        System.out.println(getName());   //静态方法无法调用非静态方法和属性
        System.out.println(getCountry());
    }
}