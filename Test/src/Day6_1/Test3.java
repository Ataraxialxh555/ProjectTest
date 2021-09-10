package Day6_1;

public class Test3 {
    public static void main(String[] args) {
//            int[] arr = new int[2];
//            arr[0] = 3;
//            arr[1] = 4;
//            System.out.println(arr);
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
//            System.out.println("===================");
//            int[] arr2 = arr;
//            arr2[0] = 1;
//            arr2[1] = 2;
//            System.out.println(arr);
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
//            System.out.println("===================");
//            System.out.println(arr2);
//            System.out.println(arr2[0]);
//            System.out.println(arr2[1]);
//            System.out.println("===================");
        int[] arr = {12, 6, 2, 8, 3};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        chang(arr);
        System.out.println("==================");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void chang(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                arr[i] = -1;
        }
    }
}
