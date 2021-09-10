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
       /* ���ָ��뼶��
        int TRANSACTION_READ_UNCOMMITTED = 1;
        int TRANSACTION_READ_COMMITTED   = 2;
        int TRANSACTION_REPEATABLE_READ  = 4;
        int TRANSACTION_SERIALIZABLE     = 8;*/
        //��ѯ��ǰ���ӵĸ��뼶�� getTransactionIsolation()
        System.out.println(conn.getTransactionIsolation());
        //�������ݿ�ĸ��뼶�� setTransactionIsolation()
        // Connection.TRANSACTION_READ_COMMITTED;
        // Connection.TRANSACTION_READ_UNCOMMITTED;
        // Connection.TRANSACTION_REPEATABLE_READ
        // Connection.TRANSACTION_SERIALIZABLE
//        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        //ȡ���Զ��ύ
        conn.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        User user = queryForCommon(conn, User.class, sql, "CC");
        System.out.println(user);


    }


    @Test
    public void testTransactionUpdate() throws Exception {
        // READ_COMMITTED ���Ա�����������ǲ��ܱ��ⲻ���ظ���
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn.getTransactionIsolation());
        conn.setAutoCommit(false);
        String sql = "update user_table  set balance  =? where user = ?";
        update(conn, sql, 10000, "CC");
        Thread.sleep(10000);
        System.out.println("�޸ĳɹ�");
        conn.commit();  //�ύ�������ѯ�����ٴ�ִ�У�balance���Ϊ10000�����ɱ��⡱�����ظ�����
    }


    /**
     * ͨ�õĲ�ѯһ��sql����д�����ڲ�ͬ�ı�
     * ͨ�õĲ�ѯ���������ڷ������ݱ��һ����¼
     * ����������
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
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.ִ��,�õ������rs
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
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
     * �������ݿ�����
     * ͨ�õ���ɾ�Ĳ���
     * Version2.0
     *
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement pre = null;
        try {
            //1.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //2.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);  //ע���һ��������i+1
            }
            //3.ִ�в���
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.�ر���Դ
            JDBCUtils.closeResource(null, pre);
        }
        return 0;
    }
}
