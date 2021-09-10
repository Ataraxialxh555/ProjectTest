package Day6_1;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");

        String input = in.next().toUpperCase(); //转为大写

        Size size = Enum.valueOf(Size.class, input);

        System.out.println("size=" + size);

        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job you paid attention to the_.");
    }
}
