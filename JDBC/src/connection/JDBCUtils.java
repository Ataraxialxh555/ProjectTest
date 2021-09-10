package connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    /**
     * 通过C3p0的数据库连接池技术
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("C3P0Connection");

    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }


    /**
     * 使用DBCP 数据库连接池随技术
     */
    private static DataSource source;
    static {
        try {
            Properties pro = new Properties();
            InputStream in = new FileInputStream(new File("src//dbcp.properties"));
            pro.load(in);
            source = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection2() throws SQLException {
        Connection conn = source.getConnection();
        return conn;
    }

    /**
     * 使用Druid数据库连接池
     */

    private static DataSource source1;
    static {
        try {
            Properties pro = new Properties();
            InputStream in = new FileInputStream(new File("src//druid.properties"));
            pro.load(in);
            source1 = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection3() throws SQLException {
        Connection conn = source.getConnection();
        return conn;
    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");

        //2.加载Driver驱动
        Class.forName(driver);

        //3.连接数据库
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭资源操作
     *
     * @param conn
     * @param pre
     */
    public static void closeResource(Connection conn, PreparedStatement pre) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (pre != null)
                pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 关闭资源的方法
     *
     * @param conn
     * @param pre
     * @param rs
     */
    public static void closeResource(Connection conn, PreparedStatement pre, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (pre != null)
                pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 使用dbutils.jar 中提供的DbUtils工具类，实现资源的关闭
     * @param conn
     * @param pre
     * @param rs
     */
    public static void closeResource1(Connection conn, PreparedStatement pre, ResultSet rs) {
        //方式一 DbUtils.close()
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            DbUtils.close(pre);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            DbUtils.close(rs);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        //方式二：DbUtils.closeQuietly() 可以不用try catch 源码try catch了
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(pre);
        DbUtils.closeQuietly(rs);
    }
}
