package Day8_15;

import java.util.ArrayList;

public class ArrayListTest01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        boolean flag = arrayList.add("��ǧ��");
//        arrayList.add("��ǧ��");
        System.out.println(flag);
        System.out.println(arrayList);
    }
}
