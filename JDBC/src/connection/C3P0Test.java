package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {

    /**
     * ��ʽһ����ȡC3P0���ݿ����ӳ�
     * @throws Exception
     */
    @Test
    public void testGetConnection() throws Exception {

        //��ȡc3p0���ݿ����ӳ�
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("3623291997");
        //ͨ��������صĲ����������ݿ����ӳؽ��й���
        //���ó�ʼ���ݿ����ӳ��е�������
        cpds.setInitialPoolSize(10);
        //��ȡ���ݿ�����
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }

    /**
     * ��ʽ����ʹ�������ļ�
     */
    @Test
    public void testGetConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("C3P0Connection");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

}
