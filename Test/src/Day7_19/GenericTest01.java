package Day7_19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest01 {
    public static void main(String[] args) {
        /*List list = new ArrayList();
        Cat cat = new Cat();
        Bird bird = new Bird();
        list.add(cat);
        list.add(bird);

        Iterator it = list.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            if(obj instanceof Cat){
                Cat c = (Cat)obj;
                c.catchMouse();
            }else if(obj instanceof Bird) {
                Bird b = (Bird) obj;
                b.canFly();
            }
        }*/
        // 使用泛型
        // 使用泛型List<Animal>之后，表示List集合中只允许存储Animal类型的数据
        // 使用泛型可以来指定集合中存储的数据类型，可以统一集合中存储的数据类型。
        List<Animal> list  = new ArrayList<Animal>();
        Cat cat = new Cat();
        Bird bird = new Bird();
        list.add(cat);
        list.add(bird);
//        list.add("avc");  // 存储字符串类型的数据会报错！
            //  表示迭代器迭代出来的集合类型是Animal类型
        Iterator<Animal> it = list.iterator();
        while(it.hasNext()){
            Animal animal = it.next();
            animal.move();
        }
    }
}
class Animal{
    public void move(){
        System.out.println("动物在移动！！！");
    }
}
class Cat extends  Animal{
    public void catchMouse() {
        System.out.println("猫抓老鼠！！");
    }
}
class Bird extends Animal{
    public void canFly(){
        System.out.println("鸟儿在飞翔！！！");
    }
}