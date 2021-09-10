package util.blob;

import org.junit.jupiter.api.Test;
import util.Customer;
import util.JDBCUtils;

import java.io.*;
import java.sql.*;

/**
 * Blob测试
 *
 */
public class BlobTest {
    /**
     * 插入操作Bolb
     */
    @Test
    public void testInsertBlob() {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql= "insert into customers(name,email,birth,photo) values(?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setObject(1,"李向欢");
            pre.setObject(2,"1243195389@qq.con");
            pre.setObject(3,"1997-02-02");
            FileInputStream is = new FileInputStream(new File("B612Kaji_20180427_220845_319.jpg"));
            pre.setBlob(4,is);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre);
        }
    }

    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        FileOutputStream fos=null;
        InputStream is = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="select id,name,email,birth,photo from customers where id = ?";
            pre = conn.prepareStatement(sql);
            pre.setObject(1,23);
            rs = pre.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birth = rs.getDate("birth");
                String email = rs.getString("email");

                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

                Blob photo = rs.getBlob(4);
                is = photo.getBinaryStream();

                fos = new FileOutputStream("lixianghuan.jpg");

                byte[] bytes = new byte[1024];
                int len;
                while((len = is.read(bytes)) != -1 ){
                    fos.write(bytes,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,pre,rs);
        }
    }
}
