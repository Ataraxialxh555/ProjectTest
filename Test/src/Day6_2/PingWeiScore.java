package Day6_2;

import java.util.Scanner;

public class PingWeiScore {
    public static void main(String[] args) {
        int[] array = new int[6];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.print("请输入" + (i + 1) + "个评委的分数:");
            int score = s.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("输入的分数有误！");
                break;
            } else {
                System.out.println("第" + (i + 1) + "个评委的分数是:" + score);
                array[i] = score;
            }
        }

        PingWeiScore p = new PingWeiScore();
        int max = p.getMax(array);
        int min = p.getMin(array);
        int sum = p.getSum(array);
        int avg = (sum - max - min )/(array.length - 2);

        System.out.println("该选手得分为："+ avg);
    }
    public int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public  int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public   int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}