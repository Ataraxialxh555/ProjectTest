package Day6_20;



public class EnumTest {
    public static void main(String[] args) {
        //switch 也支持枚举类型 enum
        switch(Season.SUMMER){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
            }
    }
}
