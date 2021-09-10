package Day6_2;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {59, 6, 5, 2, 88, 99, 1, 64, 32};
        for (int i = 0; i < arr.length - 1 ; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
//              if (arr[j] < arr[i]) {  //i 是错的
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
//        System.out.println(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第"+(i+1)+"元素:"+arr[i]);
        }

    }

//    public static int[] selectSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    min = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }
//        return arr;
//    }
}
