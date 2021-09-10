package Day7_20;

import java.util.TreeSet;
// 自定义类型如果使用TreeSet集合想要自动按照某个规则排序，需要实现Comparable接口，并且实现
// 接口中的方法compareTo 自己定义好比较的规则
// toString()方法也需要重写
public class TreeSetTest01 {
    public static void main(String[] args) {
        TreeSet<Customer> treeSet = new TreeSet<>();
        Customer c1  = new Customer(20);
        Customer c2  = new Customer(23);
        Customer c3  = new Customer(18);
        Customer c4  = new Customer(44);
        treeSet.add(c1);
        treeSet.add(c2);
        treeSet.add(c3);
        treeSet.add(c4);

        for (Customer data:treeSet) {
            System.out.println(data);
        }
    }
}
class Customer implements  Comparable<Customer>{
    int age;
    public Customer(){

    }
    public Customer(int age){
        this.age  = age;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.age - o.age;
    }
}
