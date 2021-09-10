package Day5_16;

public class ArrayTest09 {
    public static void main(String[] args) {
        int[] src = {1,2,3,4,5,6};
        int[] obj = new int[20];
        //数组的拷贝
        System.arraycopy(src,0,obj,0,src.length);
        for (int i = 0; i < obj.length; i++) {
            System.out.println("第"+(i+1)+"元素："+obj[i]);
        }
        System.out.println("==========================");
        String[] str  = {"hello","world","java","word","222"};
        String[] strs = new String[20];
        System.arraycopy(str,0,strs,0,str.length);
        for (int i = 0; i < strs.length; i++) {
            System.out.println("第"+(i+1)+"元素："+strs[i]);
        }

        System.out.println("=======================");
        Object[]  objs = {new Object(),new Object(),new Object(),new Object(),new Object()};
        Object[] objs1 = new Object[20];
        System.arraycopy(objs,0,objs1,0,objs.length);
        for (int i = 0; i < objs1.length; i++) {
            System.out.println("第"+(i+1)+"元素："+objs1[i]);
        }
    }
}
