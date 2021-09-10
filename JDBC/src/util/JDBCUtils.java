package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * ��ȡ����
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

        //2.����Driver����
        Class.forName(driver);

        //3.�������ݿ�
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * �ر���Դ����
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
     * �ر���Դ�ķ���
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
