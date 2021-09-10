package Day6_2;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] array = {2 ,5,26,36,38,666,99,1} ;
        //冒泡的次数
        int temp ;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                  temp = array[j+1];
                  array[j+1] = array[j];
                  array[j] = temp;
                }
            }
        }
        printArray(array);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第"+(i+1)+"元素:"+arr[i]);
        }
    }
}
