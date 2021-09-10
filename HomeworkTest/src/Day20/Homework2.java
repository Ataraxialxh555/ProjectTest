package Day20;

import jdk.swing.interop.SwingInterOpUtils;

public class Homework2 {
    public static void main(String[] args) {
        Image image1 = new Circle(3);
        image1.setPenColor("green");
        image1.setIsFill(true);
        double resValue = image1.imageArea();
        System.out.println("面积：" + resValue);

        double resValue1 = image1.imagePerimeter();
        System.out.println("周长：" + resValue1);

        String resValue2 = image1.toString();
        System.out.println(resValue2);

        System.out.println("-----------------------------------");

        Image image2 = new Rectangle(5,10);
        image2.setIsFill(false);
        image2.setPenColor("red");

        double res = image2.imageArea();
        System.out.println("面积："+ res );

        double res1 = image2.imagePerimeter();
        System.out.println("周长：" + res1);

        String res3 = image2.toString();
        System.out.println(res3);

        System.out.println("-----------------------------------");

        Image image3 = new Square(4);
        image3.setPenColor("yellow");
        image3.setIsFill(false);

        double result =  image3.imageArea();
        double result1= image3.imagePerimeter();
        String result2 = image3.toString();
        System.out.println("面积："+ result );
        System.out.println("周长：" + result1);
        System.out.println(result2);
        System.out.println("-----------------------------------");
    }
}
abstract class Image{
    public static double PI = 3.14;
    private String penColor;
    private boolean isFill; //true 填充 false 不填充
    public abstract double  imageArea();
    public abstract double  imagePerimeter();
    public Image(String penColor, boolean isFill) {
        this.penColor = penColor;
        this.isFill = isFill;
    }

    public Image() {
    }

    public String getPenColor() {
        return penColor;
    }

    public void setPenColor(String penColor) {
        this.penColor = penColor;
    }

    public boolean getIsFill() {
        return isFill;
    }

    public void setIsFill(boolean isFill) {
        this.isFill = isFill;
    }
}
class Circle extends Image {
    private double r;
    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public double imageArea() {
        return PI * r * r;
    }
    public double imagePerimeter(){
        return PI*r*2;
    }

    @Override
    public String toString() {
        return "半径："+r +"画笔颜色："+getPenColor()+"是否填充："+getIsFill();
    }
}
class Square extends Image{
    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
    }

    public double imageArea(){
        return a*a;
    }
    public double imagePerimeter(){
        return a*4;
    }

    @Override
    public String toString() {
        return "边长："+a +"画笔颜色："+getPenColor()+"是否填充："+getIsFill();
    }
}
class Rectangle extends Image{
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle() {
    }

    public double imagePerimeter(){
        return 2*(a+b);
    }
    public double imageArea(){
        return a*b;
    }

    @Override
    public String toString() {
        return "长："+ (Math.max(a, b)) +"宽："+(Math.min(a, b))+"画笔颜色："+getPenColor()+"是否填充："+getIsFill();
    }
}