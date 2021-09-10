package Day6_22;

public class ExceptionTest02 {
    public static void main(String[] args) {
        try{
            int res =  method(1000,20);
            System.out.println(res);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static int method(int value1,int value2){
        if(value2 == 0){
            throw new IllegalArgumentException("除数为0");

        }
        if(!(value1 > 0 && value1 <= 100)){
            throw new IllegalArgumentException("被除数必须为1~100之间的数字");
        }
        int value3 = value1/value2;
        return value3;
    }
}
