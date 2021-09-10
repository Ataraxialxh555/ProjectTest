package Day7_27_IO;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesTest01 {
    public static void main(String[] args) throws Exception{
        // io和Properties的联合使用  Properties的key和value都是String
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("Test\\src\\Day7_27_IO\\Test");
        properties.load(fileReader);

        String name = properties.getProperty("name");
        System.out.println(name);

        String age = properties.getProperty("age");
        System.out.println(age);

        String birthday = properties.getProperty("birthday");
        System.out.println(birthday);
        fileReader.close();
    }
}
