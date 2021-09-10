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
     * 方式一：测试DBCP的数据库连接池技术
     */
    @Test
    public void testGetConnection() throws SQLException {
        //创建DBCP的数据库连接池
        BasicDataSource  source = new BasicDataSource();
        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("3623291997");
        //还可以设置其他涉及数据库连接池管理的相关属性
        source.setInitialSize(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }


    /**
     * 方式二：使用配置文件 properties
     */
    @Test
    public void testGetConnection1() throws Exception {

        Properties pro= new Properties();
        //方式一：
//        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式二：
        InputStream in = new FileInputStream(new File("src//dbcp.properties"));
        pro.load(in);
        DataSource source = BasicDataSourceFactory.createDataSource(pro);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
