import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    public void test1() throws SQLException {

        //提供mysql中Driver接口的实现类
        Driver driver = new com.mysql.jdbc.Driver();
        //注册驱动
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
        //注册驱动
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test3() throws Exception {
        //加载驱动
        String className = "com.mysql.jdbc.Driver";
        Class.forName(className);
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
