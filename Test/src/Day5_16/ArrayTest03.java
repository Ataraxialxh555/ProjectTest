package Day5_16;

public class ArrayTest03 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        printArray(array1);
        System.out.println("=======================");
        String[] str = {"111","222","333","444"};
        printArray(str);
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+(i+1 )+"个元素："+array[i]);
        }
    }

    public static void printArray(String[] args){
        for (int i = 0; i < args.length; i++) {
            System.out.println("第"+(i+1 )+"个元素："+args[i]);
        }
    }
}
