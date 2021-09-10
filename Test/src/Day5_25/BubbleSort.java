package Day5_25;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 1, 8, 3, 25, 6, 44, 9};
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i-1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1]= array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+(i+1)+"元素:"+array[i]);
        }
    }
}

