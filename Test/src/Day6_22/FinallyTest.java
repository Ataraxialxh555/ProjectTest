package Day6_22;

public class FinallyTest {
    public static void main(String[] args) {
        int res = m1();
        System.out.println(res);
    }
    public static int m1(){
        int i =100;
        try{
            return i; //return 在这里返回100
        }finally {
            i++;
            System.out.println("！！！");
        }
//        return i; //return 在这里返回101
    }
}
