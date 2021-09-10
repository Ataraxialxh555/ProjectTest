package Day5_24;

import java.util.Arrays;

public class Arrays_sort {
    public static void main(String[] args) {
        int[] array = {5,52,6,2,44,666,21,0,3,999};
        Arrays.sort(array); //自动从小到大排序。
        for (int i = 0; i <array.length ; i++) {
            System.out.println("第"+(i+1)+"元素是："+array[i]);
        }
    }
}
