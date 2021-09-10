import org.junit.Test;
import util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementUpdateTest {


    @Test
    public void  testInset()  {
        //1.读取配置文件中的4个基本信息
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(in);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driver = pro.getProperty("driver");

            //2.加载Driver驱动
            Class.forName(driver);

            //3.连接数据库
            conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
            //4.预编译sql语句，返回PreparedStatement的实例
            String sql="insert into customers(name,email,birth) values(?,?,?)";// ?为占位符

            preparedStatement = conn.prepareStatement(sql);

            //5.填充占位符
            preparedStatement.setString(1,"宋祖儿");
            preparedStatement.setString(2,"12123qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1997-05-05");
            preparedStatement.setDate(3,new Date(date.getTime()));

            //6.执行sql

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //7.关闭流
            try {
                if(conn != null)
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 修改sql表中的数据
     */
    @Test
    public void testUpdate()  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            pre.setString(1, "贝多芬");
            //pre.setObject(1,"莫扎特");
            pre.setInt(2, 18);
            //pre.setObject(2,18);
            //4.执行操作
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭流
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * 删除sql表中的数据
     */
    @Test
    public void testDelete(){
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            String sql="delete from customers where id = ?";
            pre = conn.prepareStatement(sql);
            //3.填充sql语句
            pre.setObject(1,21);
            //4.执行操作
            pre.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * 通用的增删改操作
     * @param sql
     * @param args
     * @throws Exception
     */
    public void update(String sql,Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //注意第一个参数是i+1
            }
            //4.执行操作
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭资源
            JDBCUtils.closeResource(conn,pre);
        }

    }

    /**
     * 删除id=6的customers表中的数据
     * @throws Exception
     */

    @Test
    public void testCommonUpdate() throws Exception {
//        String sql="delete from customers where id = ?";
//        update(sql,6);
        String sql="delete from `order`";
        update(sql);

    }
}
