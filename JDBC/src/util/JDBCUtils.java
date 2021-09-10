package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
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
     * @param conn
     * @param pre
     */
    public static void closeResource(Connection conn, PreparedStatement pre){
        try {
            if(conn != null)
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(pre != null)
            pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 关闭资源的方法
     * @param conn
     * @param pre
     * @param rs
     */
    public static void closeResource(Connection conn, PreparedStatement pre, ResultSet rs){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(pre != null)
                pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
