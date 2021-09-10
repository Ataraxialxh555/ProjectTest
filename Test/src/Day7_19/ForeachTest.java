package Day7_19;
/*
foreach 循环
语法：
    for(数据类型 变量名：数组或者集合){
    System.out.println(变量名);
    }
    foreach缺点：没有下标，在需要使用下表的循环中，不建议使用
*/
public class ForeachTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i =0;i < arr.length;i++){
            System.out.println("第"+(i+1)+"个元素:"+arr[i]);
        }
        System.out.println("======================");
        // foreach循环
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
