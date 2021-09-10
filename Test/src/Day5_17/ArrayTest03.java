package Day5_17;

public class ArrayTest03 {
    public static void main(String[] args) {
        int[][] array={
                {1,2,3,4},
                {1,5,6,5,4},
                {5,6,6,3,1,2,8}
        };
        printArray(array);
        System.out.println("==================");
        int[][] array1 = new int[3][4];
        printArray(array1);

    }
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
