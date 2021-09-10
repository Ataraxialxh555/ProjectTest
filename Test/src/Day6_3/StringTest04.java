package Day6_3;

import jdk.swing.interop.SwingInterOpUtils;

public class StringTest04 {
    public static void main(String[] args) {
        //正则表达式a{2} 表示aa;  \d表示所有的数字， \D 表示所
        // 有的非数字
        // \w 代表所有的英文字母 \W表示所有的非英文字母。
        String s1 = "adacad3a1321cawdasaaaaada321";
        //将小写字母a替换为大写字母A
        String s2 = s1.replaceAll("a","A");
        System.out.println(s1);
        System.out.println(s2);
        //将所有的数字替换为"中"
        String s3 = s1.replaceAll("\\d","中");
        System.out.println(s3);
        //将 aa 替换为 AA
        String s4 = s1.replaceAll("a{2}","AA");
        System.out.println(s4);
        //将所有的非数字替换为"一"
        String s5 = s1.replaceAll("\\D","一");
        System.out.println(s5);
        //将小写字母aa  替换为大写字母 AA
        String s6 = s1.replaceAll("aa","AA");
        System.out.println(s6);
    }
}
