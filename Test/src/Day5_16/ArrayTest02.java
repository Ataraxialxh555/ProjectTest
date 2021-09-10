package Day5_16;

public class ArrayTest02 {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("第"+(i+1 )+"个元素："+array1[i]);
        }

        System.out.println("======================");

        Object[]  obj = new Object[4];
        for (int i = 0; i < obj.length; i++) {
            System.out.println("第"+(i+1 )+"个元素："+obj[i]);
        }
        System.out.println("=======================");

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();

//        Object[] objects = {o1,o2,o3,o4};
        Object[] objects = {new Object(),new Object(),new Object(),new Object()};

        for (int i = 0; i < objects.length; i++) {
            System.out.println("第"+(i+1 )+"个元素："+objects[i]);
        }

    }
}

