package Day6_22;

public class EnumTest {
    public static void main(String[] args) {
        Season[] seasons = new Season[]{
                Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER
        };
        for (int i = 0; i < seasons.length; i++) {
            System.out.println("Season["+i+"].ordinal():"+seasons[i].ordinal());
        }
        System.out.println("============");
        System.out.println(seasons[0].compareTo(seasons[0]));
        System.out.println(seasons[1].compareTo(seasons[2]));
        Class<?> classes = seasons[1].getDeclaringClass();
        System.out.println("classes:"+classes);
        System.out.println("=====================");
    }
}
