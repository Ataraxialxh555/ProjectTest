import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    public void test1() throws SQLException {

        //�ṩmysql��Driver�ӿڵ�ʵ����
        Driver driver = new com.mysql.jdbc.Driver();
        //ע������
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test2() throws Exception {
        String className = "com.mysql.jdbc.Driver";
        Class  clazz = Class.forName(className);
        Driver driver = (Driver) clazz.newInstance();
        //ע������
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test3() throws Exception {
        //��������
        String className = "com.mysql.jdbc.Driver";
        Class.forName(className);
//        Driver driver = (Driver) clazz.newInstance();
//        //ע������
//        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
