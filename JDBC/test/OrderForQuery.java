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
     * ��������Order���ͨ�ò�ѯд��
     * ��Ҫ�����Order����ֶ�����Order�����������һ��
     * sql��Order����ֶ���Ϊorder_id order_name order_date
     * Order���� ������ΪorderId  orderName orderDate
     * ��sql����б������ѯ���ֶ�������������ұ���Ҫ��Order�����������ͬ
     * ʹ��ResultSetMetaDataʱ����Ҫʹ��getColumnLabel()���滻getColumnName() ��ȡ�еı���
     * ��ʹsql�����û�и��ֶ��������getColumnLabel()������Ȼ���Ի�ȡ����
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
            //ִ�л�ȡ�����
            rs = pre.executeQuery();
            // ��ȡ�������Ԫ����
            ResultSetMetaData metaData = rs.getMetaData();
            //��ȡ����
            int columnCount = metaData.getColumnCount();

            if (rs.next()){
                Order o = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //��ȡÿ���е���ֵ��ͨ��ResultSet
                    Object columnValue = rs.getObject(i+1);
                    //��ȡÿ���е�������ͨ��ResultSetMetaData
//                    String columnName = metaData.getColumnName(i + 1);
                    //��ȡ�еı��� ��getColumnLabel()  ͨ��ResultSetMetaData
                    String columnName = metaData.getColumnLabel(i + 1);
                    Class className = Class.forName("util.Order");
                    //���е������ֶ���Ϊorder_id   Order�����������ΪorderId������Ӧ
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
