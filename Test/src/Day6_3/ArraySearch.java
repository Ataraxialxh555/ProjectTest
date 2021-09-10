package Day6_3;

public class ArraySearch {
    public static void main(String[] args) {
        int[] arr = {5,66,88,23,66,44,87,20,1};
        //找到44的下标，如果没有就返回-1
        int i = arraySearch(arr,66);
        System.out.println(i);
    }
    public static int arraySearch(int[] arr, int searchNum ){
        for (int i = 0; i < arr.length; i++) {
            if (searchNum == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
