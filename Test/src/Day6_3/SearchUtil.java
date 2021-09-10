package Day6_3;

public class SearchUtil {
    public static void main(String[] args) {
        int[] array = {5,68,66,2,3,99,4,6,7,1};
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+(i+1)+"元素:"+array[i]);
        }
        int resValue = erFenFa(array,1999);
        System.out.println(resValue);
        System.out.println(5>>2);
    }
    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1;j < arr.length;j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    public static int erFenFa(int[] arr,int selectNum){
        int low = 0;
        int high = arr.length -1;
        while (low <= high){
            int mid = (low +high)/2;
            if (selectNum == arr[mid]){
                return mid;
            }else if (selectNum < arr[mid]){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return 404;
    }
}

