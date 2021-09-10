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
 * ʹ��PrepareStatementʵ������ڲ�ͬ���ͨ�õĲ�ѯ����
 * 1.ͨ�õĲ�ѯһ��sql����д�����ڲ�ͬ�ı�
 * 2.��ѯsql���еĶ�������
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
     * ͨ�õĲ�ѯһ��sql����д�����ڲ�ͬ�ı�
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
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.ִ��,�õ������rs
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                //������ƴ�������
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //��ȡ��ǰ�������ݵĸ����ֶ�ֵ
                    // �� Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��
                    Object columnValue = rs.getObject(i + 1);
                    //��ȡÿһ�е�����
                    //getColumnLabel:��ȡָ���еı�����
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //��t����ָ����ĳ�����ԣ���ֵΪcolumnValue

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);//���Ʒ�װ
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
     * ��ѯsql���еĶ�������
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
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.ִ��
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();
            //����List����
            ArrayList<T> list = new ArrayList<>();

            while(rs.next()){
                //ͨ��������ƴ�������
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //��ȡ��ǰ�������ݵĸ����ֶ�ֵ
                    // �� Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��
                    Object columnValue = rs.getObject(i + 1);
                    //��ȡÿһ�е�����
                    //getColumnLabel:��ȡָ���еı�����
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //��t����ָ����ĳ�����ԣ���ֵΪcolumnValue

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);//���Ʒ�װ
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
