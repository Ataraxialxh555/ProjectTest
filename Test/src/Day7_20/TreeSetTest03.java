package Day7_20;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest03 {
    public static void main(String[] args) {
        //匿名内部类 写比较器
        TreeSet<Dog> dogs = new TreeSet<>(new Comparator<Dog>(){
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Dog dog1 = new Dog("xiaohua");
        Dog dog2 = new Dog("xiaomei");
        Dog dog3 = new Dog("lihua!");
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        for (Dog dog:dogs){
            System.out.println(dog);
        }


    }
}
class Dog{
    String name;
    public Dog(){}
    public Dog(String name){
        this.name = name;
    }
    public String toString(){
        return "Dog'name["+this.name+"]";
    }
}
// 写一个比较器
/*
class DogComparator implements Comparator<Dog>{

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.name.compareTo(o2.name);
    }
}*/
