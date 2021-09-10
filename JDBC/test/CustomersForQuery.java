import org.junit.Test;
import util.Customer;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * ���Customers��Ĳ�ѯ����
 */
public class CustomersForQuery {

    /**
     * ͨ�õĶ�Customers��Ĳ�ѯ����
     * @param sql
     * @param args
     * @return
     */
    public static Customer queryForCustomers(String sql,Object ...args) {
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

            if(rs.next()){
                Customer c = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    //��ȡ��ǰ�������ݵĸ����ֶ�ֵ
                    // �� Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��Java ��������� Object ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��
                    Object columnValue = rs.getObject(i + 1);
                    //��ȡÿһ�е�����
                    //getColumnName:��ȡָ���е����ơ�
                    String columnName = rsmd.getColumnName(i + 1);
                    //��cust����ָ����ĳ�����ԣ���ֵΪcolumnValue

                    Class className = Class.forName("util.Customer");
                    Field field = className.getDeclaredField(columnName);
                    field.setAccessible(true);//���Ʒ�װ
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
        Customer customer1 = queryForCustomers(sql1, "�ܽ���");
        System.out.println(customer1);
    }


    @Test
    public void testQuery1()  {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet resultSet=null;
        try {
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            String sql="select id,name,email,birth from customers where id = ?";
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            pre.setObject(1,1);
            //4.ִ�в��ҷ��ؽ����
            resultSet = pre.executeQuery();
            //5.��������
            if(resultSet.next()){ //next()���жϽ��������һ���Ƿ������ݣ���������ݷ���true������ָ�����ƣ���֮����false������ָ�벻������
                //��ȡ��ǰ�������ݵĸ����ֶ�ֵ
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
//                ��ʽһ��
//                System.out.println("id = "+id+",name = "+name+",email="+email+",birth="+birth);
//                ��ʽ����
//                Object[] data = new Object[]{id,name,email,birth};
//                System.out.println(data);
                //��ʽ����
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
