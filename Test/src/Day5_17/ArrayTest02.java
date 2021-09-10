package Day5_17;
    //二维数组的遍历
public class ArrayTest02 {
    public static void main(String[] args) {
        int[][] array = {
                {1,1,2,3,6},
                {55,2,66,1},
                {1,2}
        };
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++){
                System.out.println("第"+(i+1)+"个一维数组的，第"+(j+1)+"个元素："+array[i][j]);
            }
        }
        System.out.println("===============================");
        String[][] array1 = {
                {"java","c","c++","python"},
                {"lisi","zhangsan"},
                {"beijing","shanghai","nanchang"}
        };
        for (int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array1[i].length; j++){
                System.out.println("第"+(i+1)+"个一维数组的，第"+(j+1)+"个元素："+array1[i][j]);
            }
        }

    }
}
