package Reflect;

import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        //快速绑定属性资源文件  .properties
        ResourceBundle rb = ResourceBundle.getBundle("Reflect//classInformation");
        String s = rb.getString("classname");
        System.out.println(s);
    }
}
