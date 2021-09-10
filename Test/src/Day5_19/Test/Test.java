package Day5_19.Test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String all = String.join("/","s","m","z","q");
        System.out.println(all); //如果需要把多个字符串放在一起，用一个定界符分隔，可以使用静态join方法
        String greeting = "Hello";
        int cpCount = greeting.codePointCount(5,greeting.length());
        System.out.println(cpCount);
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name?");
        String res = s.nextLine(); //nextLine()方法的结束符只是Enter键，
        // 即nextLine()方法返回的是Enter键之前的所有字符.例如：在控制台输入“    abc    abc”这是可以得到：“    abc    abc”
        String res1 = s.next();
        // next()方法，对输入有效字符之前遇到的空格键，Tab键、或者Enter键等结束符号，
        // next()方法都会舍去，只有在输入有效字符之后，next()方法才将气候输入的空格键Tab键或Enter键等视为分隔符或结束符。
        System.out.println(res);
        System.out.println(res1);
    }
//    What is your name?               aabc    acb
//      acb   acb
//               aabc    acb
//acb
}
