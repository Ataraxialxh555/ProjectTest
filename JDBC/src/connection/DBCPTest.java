package connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    /**
     * ��ʽһ������DBCP�����ݿ����ӳؼ���
     */
    @Test
    public void testGetConnection() throws SQLException {
        //����DBCP�����ݿ����ӳ�
        BasicDataSource  source = new BasicDataSource();
        //���û�����Ϣ
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("3623291997");
        //���������������漰���ݿ����ӳع�����������
        source.setInitialSize(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }


    /**
     * ��ʽ����ʹ�������ļ� properties
     */
    @Test
    public void testGetConnection1() throws Exception {

        Properties pro= new Properties();
        //��ʽһ��
//        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //��ʽ����
        InputStream in = new FileInputStream(new File("src//dbcp.properties"));
        pro.load(in);
        DataSource source = BasicDataSourceFactory.createDataSource(pro);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
