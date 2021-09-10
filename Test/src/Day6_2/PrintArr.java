package Day6_2;

import java.util.Arrays;

public class PrintArr {
    public static void main(String[] args) {
        //创建数组
        int[] arr = {1,2,3,4,5};
        //调用方法
        printArr(arr);
    }
    public static void printArr(int[] arr){
        //借助了一个java中提供的对象
        System.out.println(Arrays.toString(arr));
    }
}
