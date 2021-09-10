import org.junit.Test;
import util.Customer;
import util.JDBCUtils;
import util.Order;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PrepareStatement实现针对于不同表的通用的查询操作
 * 1.通用的查询一条sql语句的写法对于不同的表
 * 2.查询sql表中的多条数据
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetForList(){
        String sql="select id,name,email from customers where id < ? ";
        List<Customer> forList = getForList(Customer.class, sql, 12);
        /*for(Customer c :forList){
            System.out.println(c);
        }*/
        forList.forEach(System.out :: println);

        String sql1="select order_id orderId,order_name orderName from `order`";
        List<Order> forList1 = getForList(Order.class, sql1);
        for (Order l:forList1) {
            System.out.println(l);
        }
    }

    @Test
    public void testQuery(){
        String sql="select order_id orderId,order_name orderName from `order` where order_id = ?";
        Order order = queryForCommon(Order.class, sql, 1);
        System.out.println(order);

        String sql1 = "select id,name,email from customers where id = ?";
        Customer customer = queryForCommon(Customer.class, sql1, 2);
        System.out.println(customer);


    }

    /**
     * 通用的查询一条sql语句的写法对于不同的表
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForCommon(Class<T> clazz,String sql,Object...args){
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.执行,得到结果集rs
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
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
                    field.set(t,columnValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre,rs);
        }
        return null;
    }

    /**
     * 查询sql表中的多条数据
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */

    public <T> List<T> getForList(Class<T> clazz, String sql, Object...args){
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.执行
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();
            //创建List数组
            ArrayList<T> list = new ArrayList<>();

            while(rs.next()){
                //通过反射机制创建对象
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
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre,rs);
        }
        return null;

    }
}
