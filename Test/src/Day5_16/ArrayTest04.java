package Day5_16;

public class ArrayTest04 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        printArray(array);
        System.out.println("===============");
        //静态初始化这样直接调用printArray方法不行
//        printArray({1,2,3,4,5,6});
        //需要这样！
        printArray(new int[] {1 ,2,3,4,5,6});
        System.out.println("===============");
        printArray(new int[5]);
        System.out.println("===============");
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+(i+1)+"元素：" + array[i]);
        }
    }
}
