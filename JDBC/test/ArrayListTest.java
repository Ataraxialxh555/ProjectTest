
import com.mysql.jdbc.log.Log;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

import java.util.*;

public class ArrayListTest {
    /**
     * 添加元素add
     */
    @Test
    public void testAdd() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);
    }

    /**
     * 访问元素get
     */
    @Test
    public void testGet() {
        //数组索引从1开始
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list.get(1));
    }

    /**
     * 修改元素set
     */
    @Test
    public void testSet() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);

        list.set(1, "Baidu");
        System.out.println(list);
    }

    /**
     * 删除元素remove
     */

    @Test
    public void testRemove() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
    }

    /**
     * 计算数组大小size()
     */

    @Test
    public void testSize() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);

        int size = list.size();
        System.out.println(size);
    }

    /**
     * 迭代数组
     * for
     */
    @Test
    public void testFor1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);
        //方式一
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    //方式二 foreach
    @Test
    public void testFor2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);
        //方式二  foreach
        for (String l : list) {
            System.out.println(l);
        }
    }

    //Iterator
    @Test
    public void testFor3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);
        //方式三 Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
    }

    @Test
    public void testSort() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Alibaba");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("利用Collections.sort方法对数组进行排序"+list);

    }

    @Test
    public void testA(){
        ArrayList list1 = new ArrayList();
        list1.add(new Object());
        list1.add(1);
        list1.add("assda");
        list1.add('c');
        System.out.println(list1);
    }


    @Test
    public void testB(){
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class classStringList = stringList.getClass();
        Class classIntegerList = integerList.getClass();
        System.out.println(classIntegerList);
        System.out.println(classStringList);
        if(classStringList.equals(classIntegerList)){
            System.out.println("类型相同");
        }
    }
}

