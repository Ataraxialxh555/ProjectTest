import org.junit.Test;
import util.JDBCUtils;
import util.Order;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OrderForQuery {

    /**
     * 这个针对于Order表的通用查询写法
     * 主要针对于Order表的字段名和Order类的属性名不一致
     * sql中Order表的字段名为order_id order_name order_date
     * Order类中 属性名为orderId  orderName orderDate
     * 在sql语句中必须给查询的字段名起别名，并且别名要和Order类的属性名相同
     * 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName() 获取列的别名
     * 即使sql语句中没有给字段起别名，getColumnLabel()方法仍然可以获取列名
     * @param sql
     * @param args
     * @return
     */
    public static Order queryForOrder(String sql,Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            pre = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //执行获取结果集
            rs = pre.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();

            if (rs.next()){
                Order o = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值：通过ResultSet
                    Object columnValue = rs.getObject(i+1);
                    //获取每个列的列名：通过ResultSetMetaData
//                    String columnName = metaData.getColumnName(i + 1);
                    //获取列的别名 ：getColumnLabel()  通过ResultSetMetaData
                    String columnName = metaData.getColumnLabel(i + 1);
                    Class className = Class.forName("util.Order");
                    //表中的属性字段名为order_id   Order对象的属性名为orderId，不对应
                    Field field = className.getDeclaredField(columnName);
                    field.setAccessible(true);

                    field.set(o,columnValue);
                }
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,pre,rs);
        }
        return null;
    }

    @Test
    public void testForOrder(){
        String sql="select order_id orderId,order_name orderNam e from `order` where order_id = ?";
        Order order = queryForOrder(sql, 1);
        System.out.println(order);
    }
}
