package Day8_15;

public class DoubleArrayTest {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{2,3,4},{5,56,6}};
        /*for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i;
            }
        }*/

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
    public static int getSum(int a ,int b){
        return a+b;
    }
    public static double getSum(int a ,double b,int c){
        return a+b+c;
    }
    public static double getSum(int a ,int b,double c){
        return a+b+c;
    }
}
