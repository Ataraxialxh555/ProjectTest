package Day5_16;

public class ArrayTest01 {
    public static void main(String[] args) {
        //静态初始化数组
        int[] array = {1 ,2,3,4,5,6,7};
        //length属性
        System.out.println("数组的长度：" + array.length);
        System.out.println("数组的第一个元素："+array[0]);
        System.out.println("数组的最后一个元素："+array[array.length -1]);

        //查询
        array[0] = 250;
        System.out.println("数组的第一个元素:"+array[0]);
        //改
        array[array.length-1] = 888;
        System.out.println("数组的最后一个元素："+array[array.length -1]);

        //数组的遍历
        for(int i = 0; i < array.length ;i++){
            System.out.println("第"+(i+1)+"元素："+array[i]);
        }
        System.out.println("---------------------");
        //逆向遍历
        for(int j = array.length-1; j >= 0;j--){
            System.out.println("第"+(j+1)+"元素："+array[j]);
        }
    }
}
