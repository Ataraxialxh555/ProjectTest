package Day7_19;

import java.util.HashSet;
import java.util.Set;

public class HashMapTest01 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan");
        Student s2 = new Student("zhangsan");
        System.out.println(s1.equals(s2)); //重写equals后true
        System.out.println("s1的hashCode值为:"+s1.hashCode());
        System.out.println("s2的hashCode值为:"+s2.hashCode());
        Set<Student> set = new HashSet<>();

        set.add(s1);
        set.add(s2);
        System.out.println(set.size()); // 重写hashCode()方法之前为2
        //重写之前为1
    }
}
