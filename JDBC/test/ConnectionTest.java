import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

/**
 * 获取数据库连接
 */
public class ConnectionTest{
    /**
     * 方式一
     * @throws SQLException
     */
    @Test
    public void testConnection1() throws SQLException {
        //第三方的API com.mysql.jdbc.Driver
        Driver driver = new com.mysql.jdbc.Driver();
        // jdbc:mysql: 协议
        // localhost:ip地址
        // 3306:端口号
        // test：test数据库
        String url="jdbc:mysql://localhost:3306/test";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","3623291997");
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    /**
     * 方式二
     * 使用反射机制
     * 可以不使用第三方的API
     * @throws Exception
     */

    @Test
    public void testConnection2() throws Exception {
        //使用反射机制
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //提供连接需要的用户名和密码
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","3623291997");
        //获取连接
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    /**
     * 方式三
     *使用DriverManager
     * @throws Exception
     */
    @Test
    public void testConnection3() throws Exception {
        //使用DriverManager类
        //获取Driver实现类的对象
        Class  clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

    /**
     * 方式四
     * 可以省略注册驱动
     * mysql中的Driver实现类 在静态代码块中注册驱动
     * @throws Exception
     */

    @Test
    public void testConnection4() throws Exception {
        //使用DriverManager类

        //1.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        //2.加载Driver
        // 获取Driver实现类的对象
        Class.forName("com.mysql.jdbc.Driver");

        //可以省略注册驱动，mysql的Driver实现类可以在静态代码块中注册驱动
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        //获取连接
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

    //方式五：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方法，获取连接


    @Test
    public void testConnection5() throws Exception {
        //读取配置文件中的4个基本信息
        InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");

        //加载Driver
        Class.forName(driver);

        //连接数据库
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);


    }
}