package Day7_20;

import java.util.TreeSet;

public class TreeSetTest02 {
    public static void main(String[] args) {
        TreeSet<Child> treeSet1 = new TreeSet<>();
        treeSet1.add(new Child(20,"lxh"));
        treeSet1.add(new Child(10,"lxh"));
        treeSet1.add(new Child(20,"lxz"));
        treeSet1.add(new Child(25,"zhaoliu"));
        for (Child data:treeSet1){
            System.out.println(data);
        }
    }
}

class Child implements Comparable<Child>{
    int age ;
    String name;
    public Child(){}
    public Child(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Child o) {
        if (this.age == o.age){
            return this.name.compareTo(o.name);
        }else{
            return this.age-o.age;
        }
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}