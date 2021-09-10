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
 * ��ȡ���ݿ�����
 */
public class ConnectionTest{
    /**
     * ��ʽһ
     * @throws SQLException
     */
    @Test
    public void testConnection1() throws SQLException {
        //��������API com.mysql.jdbc.Driver
        Driver driver = new com.mysql.jdbc.Driver();
        // jdbc:mysql: Э��
        // localhost:ip��ַ
        // 3306:�˿ں�
        // test��test���ݿ�
        String url="jdbc:mysql://localhost:3306/test";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","3623291997");
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    /**
     * ��ʽ��
     * ʹ�÷������
     * ���Բ�ʹ�õ�������API
     * @throws Exception
     */

    @Test
    public void testConnection2() throws Exception {
        //ʹ�÷������
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //�ṩҪ���ӵ����ݿ�
        String url = "jdbc:mysql://localhost:3306/test";
        //�ṩ������Ҫ���û���������
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","3623291997");
        //��ȡ����
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    /**
     * ��ʽ��
     *ʹ��DriverManager
     * @throws Exception
     */
    @Test
    public void testConnection3() throws Exception {
        //ʹ��DriverManager��
        //��ȡDriverʵ����Ķ���
        Class  clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //�ṩ�����������ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        //ע������
        DriverManager.registerDriver(driver);

        //��ȡ����
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

    /**
     * ��ʽ��
     * ����ʡ��ע������
     * mysql�е�Driverʵ���� �ھ�̬�������ע������
     * @throws Exception
     */

    @Test
    public void testConnection4() throws Exception {
        //ʹ��DriverManager��

        //1.�ṩ�����������ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "3623291997";
        //2.����Driver
        // ��ȡDriverʵ����Ķ���
        Class.forName("com.mysql.jdbc.Driver");

        //����ʡ��ע��������mysql��Driverʵ��������ھ�̬�������ע������
//        Driver driver = (Driver) clazz.newInstance();
//        //ע������
//        DriverManager.registerDriver(driver);
        //��ȡ����
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

    //��ʽ�壺�����ݿ�������Ҫ��4��������Ϣ�����������ļ��У�ͨ����ȡ�����ļ��ķ�������ȡ����


    @Test
    public void testConnection5() throws Exception {
        //��ȡ�����ļ��е�4��������Ϣ
        InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");

        //����Driver
        Class.forName(driver);

        //�������ݿ�
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);


    }
}