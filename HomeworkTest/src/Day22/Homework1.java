package Day22;
/*
        第一题：
        （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
        （2）定义接口B，里面包含抽象方法void setColor(String c)。
        （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
        （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
                圆柱体的高height、颜色color。
        （5）创建主类来测试类Cylinder。
 */

import java.util.Objects;

public class Homework1 {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        c1.setColor("red");
        c1.setHeight(5.1);
        c1.setRadius(5);
        double areaResult  =  c1.area();
        System.out.println("面积：" + areaResult);
        c1.volume();
        System.out.println(c1.toString());
    }
}
interface A {
    public static final double PI = 3.14;
    public abstract double  area();
}
interface B {
    public abstract void setColor(String c);
}
interface C  extends A,B{
    public abstract void volume();
}



class Cylinder  implements  C{
    private double radius;
    private double height;
    private String color;
    public Cylinder(){}
    public Cylinder(double radius,double height,String color ){
        this.color = color;
        this.height = height;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    @Override
    public double area() {
        return 2*PI*radius*height+2*PI*radius*radius;
    }

    @Override
    public void setColor(String c) {
        this.color = c;
        System.out.println("颜色："+this.color);
    }

    @Override
    public void volume() {
        System.out.println("体积："+PI*radius*radius*height);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.radius, radius) == 0 && Double.compare(cylinder.height, height) == 0 && color.equals(cylinder.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, height, color);
    }
}
