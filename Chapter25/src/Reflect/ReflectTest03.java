package Reflect;

import java.io.FileReader;
import java.util.Properties;

public class ReflectTest03 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("Chapter25\\src\\Reflect\\classInformation.properties");
        Properties properties = new Properties();
        properties.load(fr);
        fr.close();

        String className = properties.getProperty("classname");
        Class<User>  c = (Class<User>) Class.forName(className);

        User user = c.newInstance();
        User user1 = c.newInstance();
        System.out.println(user);
        System.out.println(user1);
    }
}
