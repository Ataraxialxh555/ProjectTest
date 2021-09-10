package Day5_17;

public class ArrayTest01 {
    public static void main(String[] args) {
        int[][] array={
                {1,2,3,5,6,2},
                {4,5,6},
                {4},
                {7,8,9,5,6,6,6,3,2,1}};
        int[] res = array[0];
        System.out.println(res);
        System.out.println("===============================");
        System.out.println(array[0][0]);//取出第一个一维数组中的第一个元素
        System.out.println("===============================");
        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println(array[1].length);
        System.out.println(array[2].length);
        System.out.println(array[3].length);

        int[][][] array2 = {
                {{1,2,3},{2,3,5},{2,5,6}},
                {{1,2,3},{2,3,5},{2,5,6}},
                {{1,2,3},{2,3,5},{2,5,6}}};
    }
}
