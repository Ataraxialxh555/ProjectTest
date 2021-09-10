package Day6_20;


import java.util.Arrays;
import java.util.Random;

public class RandomTest01 {
    public static void main(String[] args) {
        int[] arrays = new int[5];
        int flag = 0;
        for (int i = 0; i < arrays.length; i++) {
            arrays[i]=-1;
        }
        for (int i = 0; flag <arrays.length; i++) {
            Random random = new Random();
            int num = random.nextInt(5);
//            System.out.println(num);
//            System.out.println("==============");
            if(!arraysContain(arrays,num)){
                arrays[flag]=num;
                flag++;
            }
        }
        System.out.println("------------------");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
    //判断数组中是否存在某个元素 存在返回true 不存在false
    public static boolean arraysContain(int[] arrays,int num){
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == num){
                return true;
            }
        }
        return false;
    }

}
