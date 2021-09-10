import org.junit.Test;
import util.Customer;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customers表的查询操作
 */
public class CustomersForQuery {

    /**
     * 通用的对Customers表的查询操作
     * @param sql
     * @param args
     * @return
     */
    public static Customer queryForCustomers(String sql,Object ...args) {
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

            if(rs.next()){
                Customer c = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    //获取当前这条数据的各个字段值
                    // 以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。
                    Object columnValue = rs.getObject(i + 1);
                    //获取每一列的列名
                    //getColumnName:获取指定列的名称。
                    String columnName = rsmd.getColumnName(i + 1);
                    //给cust对象指定的某个属性，赋值为columnValue

                    Class className = Class.forName("util.Customer");
                    Field field = className.getDeclaredField(columnName);
                    field.setAccessible(true);//打破封装
                    field.set(c,columnValue);
                }
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre,rs);
        }
        return null;
    }

    @Test
    public void testQueryForCustomers(){
        String sql="select id,name from customers where id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);
        String sql1= "select id,name,email from customers where name =?";
        Customer customer1 = queryForCustomers(sql1, "周杰伦");
        System.out.println(customer1);
    }


    @Test
    public void testQuery1()  {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet resultSet=null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            String sql="select id,name,email,birth from customers where id = ?";
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            pre.setObject(1,1);
            //4.执行并且返回结果集
            resultSet = pre.executeQuery();
            //5.处理结果集
            if(resultSet.next()){ //next()：判断结果集的下一条是否有数据，如果有数据返回true，并且指针下移，反之返回false，并且指针不会下移
                //获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
//                方式一：
//                System.out.println("id = "+id+",name = "+name+",email="+email+",birth="+birth);
//                方式二：
//                Object[] data = new Object[]{id,name,email,birth};
//                System.out.println(data);
                //方式三：
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,pre,resultSet);
        }
    }
}
