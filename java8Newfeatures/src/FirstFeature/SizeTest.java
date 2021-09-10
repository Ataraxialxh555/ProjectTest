package FirstFeature;

import jdk.swing.interop.SwingInterOpUtils;

public class SizeTest {
    public static void main(String[] args) {
        Size[] values = Size.values();
        for(Size s :values){
            System.out.println(s);
        }

        Size size = Enum.valueOf(Size.class, "EXTRA_LARGE");
        System.out.println(size);
        System.out.println(Size.SMALL.toString());
        System.out.println(Size.SMALL);
    }
}
