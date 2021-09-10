package Day7_19;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("1","wangwu");
        properties.setProperty("2","zhangsan");
        properties.setProperty("3","lisi");
        properties.setProperty("4","goudan");
        String s1 = properties.getProperty("1");
        String s2 = properties.getProperty("2");
        String s3 = properties.getProperty("3");
        String s4 = properties.getProperty("4");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

    }
}
