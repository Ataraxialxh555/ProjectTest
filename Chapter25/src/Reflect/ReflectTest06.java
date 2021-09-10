package Reflect;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class ReflectTest06 {
    public static void main(String[] args) throws Exception {
        /*String path = Thread.currentThread().
                getContextClassLoader().getResource("Reflect//classInformation.properties").getPath();
        //这里path会因为绝对路径中包含中文而错误
        FileReader fr = new FileReader(path);*/

        InputStream fr = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("Reflect//classInformation.properties");
        Properties properties = new Properties();
        properties.load(fr);
        String s = properties.getProperty("classname");
        System.out.println(s);
        fr.close();
    }
}
