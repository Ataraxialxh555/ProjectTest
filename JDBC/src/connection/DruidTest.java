package connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {

    @Test
    public void testGetConnection() throws Exception {
        Properties pro = new Properties();
        InputStream in = new FileInputStream(new File("src//druid.properties"));
        pro.load(in);
        DataSource source = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
