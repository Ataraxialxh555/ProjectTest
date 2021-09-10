package Day6_3;

public class StringTest05 {
    public static void main(String[] args) {
        StringBuffer sbStr = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            sbStr.append(i);
            sbStr.append(",");
            //去除最后一个逗号
            /*if (i != 19){
                sbStr.append(",");
            }*/

        }
        System.out.println(sbStr);
        System.out.println("=====================");
        System.out.println(sbStr.toString());
        System.out.println("======================");
        System.out.println(sbStr.toString().substring(0,sbStr.length()-1));

    }
}
