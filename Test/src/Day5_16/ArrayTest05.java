package Day5_16;

public class ArrayTest05 {
    public static void main(String[] args) {
        String[] args1={};
        printLength(args1);
        System.out.println("=============");
        String[]  args2 ={null,null,"2"};
        printLength(args2);
    }
    public static void printLength(String[] args){
        System.out.println("数组的长度："+args.length);
    }
}
