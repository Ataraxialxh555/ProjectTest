package Day5_10;

public class FinalTest4 {
    public static void main(String[] args) {
        Chinese c = new Chinese("li","1321");
        System.out.println(c.getIdCard());
        System.out.println(c.getName());
        System.out.println(c.COUNTRY);
    }
}
class Chinese{
    private String name;
    private String idCard;
//    final static String COUNTRY = "中国";  //可以final static  也可以static final
    public  final String COUNTRY = "中国";  //可以final static  也可以static final

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }



    public Chinese() {
    }

    public Chinese(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }
}