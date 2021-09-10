import java.util.ArrayList;

/**
 * @author lxhstart
 * @create 2021 09 10 10:48
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("arrayList = " + arrayList.get(i));
        }
    }
}
