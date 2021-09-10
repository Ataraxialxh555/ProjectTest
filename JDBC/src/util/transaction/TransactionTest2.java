package util.transaction;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TransactionTest2 {


    @Test
    public void testTransactionSelect() throws Exception {

        Connection conn = JDBCUtils.getConnection();
       /* 四种隔离级别：
        int TRANSACTION_READ_UNCOMMITTED = 1;
        int TRANSACTION_READ_COMMITTED   = 2;
        int TRANSACTION_REPEATABLE_READ  = 4;
        int TRANSACTION_SERIALIZABLE     = 8;*/
        //查询当前连接的隔离级别 getTransactionIsolation()
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别 setTransactionIsolation()
        // Connection.TRANSACTION_READ_COMMITTED;
        // Connection.TRANSACTION_READ_UNCOMMITTED;
        // Connection.TRANSACTION_REPEATABLE_READ
        // Connection.TRANSACTION_SERIALIZABLE
//        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        //取消自动提交
        conn.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        User user = queryForCommon(conn, User.class, sql, "CC");
        System.out.println(user);


    }


    @Test
    public void testTransactionUpdate() throws Exception {
        // READ_COMMITTED 可以避免脏读，但是不能避免不可重复读
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn.getTransactionIsolation());
        conn.setAutoCommit(false);
        String sql = "update user_table  set balance  =? where user = ?";
        update(conn, sql, 10000, "CC");
        Thread.sleep(10000);
        System.out.println("修改成功");
        conn.commit();  //提交后，如果查询操作再次执行，balance结果为10000，不可避免”不可重复读“
    }


    /**
     * 通用的查询一条sql语句的写法对于不同的表
     * 通用的查询操作，用于返回数据表的一条记录
     * 考虑了事务
     * Version2.0
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForCommon(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.执行,得到结果集rs
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                //反射机制创建对象
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取当前这条数据的各个字段值
                    // 以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。
                    Object columnValue = rs.getObject(i + 1);
                    //获取每一列的列名
                    //getColumnLabel:获取指定列的别名。
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //给t对象指定的某个属性，赋值为columnValue

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);//打破封装
                    field.set(t, columnValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(null, pre, rs);
        }
        return null;
    }


    /**
     * 考虑数据库事务
     * 通用的增删改操作
     * Version2.0
     *
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement pre = null;
        try {
            //1.预编译sql语句
            pre = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);  //注意第一个参数是i+1
            }
            //3.执行操作
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            JDBCUtils.closeResource(null, pre);
        }
        return 0;
    }
}
