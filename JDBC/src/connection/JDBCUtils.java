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
     * ͨ��C3p0�����ݿ����ӳؼ���
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("C3P0Connection");

    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }


    /**
     * ʹ��DBCP ���ݿ����ӳ��漼��
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
     * ʹ��Druid���ݿ����ӳ�
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
     * ��ȡ����
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

        //2.����Driver����
        Class.forName(driver);

        //3.�������ݿ�
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * �ر���Դ����
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
     * �ر���Դ�ķ���
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
     * ʹ��dbutils.jar ���ṩ��DbUtils�����࣬ʵ����Դ�Ĺر�
     * @param conn
     * @param pre
     * @param rs
     */
    public static void closeResource1(Connection conn, PreparedStatement pre, ResultSet rs) {
        //��ʽһ DbUtils.close()
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
        //��ʽ����DbUtils.closeQuietly() ���Բ���try catch Դ��try catch��
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(pre);
        DbUtils.closeQuietly(rs);
    }
}
