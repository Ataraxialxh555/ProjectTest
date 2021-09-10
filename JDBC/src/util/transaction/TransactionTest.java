package util.transaction;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ���ݿ�����
 *
 * ����һ���ύ���Ͳ��ɻع�
 */
public class TransactionTest {
    //δ�������ݿ����������ת�˲���
    @Test
    public void testUpdate(){
        String sql="update user_table set balance =  balance-100 where user = ?";
        int aa = update(sql, "AA");
        String sql1="update user_table set balance =  balance+100 where user = ?";
        int bb = update(sql1, "BB");
        if (aa != -1 && bb != -1 ){
           System.out.println("ת�˳ɹ���");
        }
    }

    //�������ݿ������ת�˲���
    @Test
    public void testWithTransaction(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //1.ȡ�����ݵ��Զ��ύ����    setAutoCommit()
            conn.setAutoCommit(false);
            String sql="update user_table set balance =  balance-100 where user = ?";
            update(conn,sql,"AA");

            //ģ�������쳣
            System.out.println(10/0);
            String sql1="update user_table set balance =  balance+100 where user = ?";
            update(conn,sql1, "BB");

            //2.�ύ����
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //�����쳣������ع�����һ���ύ���ݵ�״̬
            //3.�ع�����
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally{
            //�޸���Ϊ�Զ��ύ����
            //��Ҫ������ݿ����ӳص�ʹ��
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
    }

    /**
     * δ�������ݿ�����
     * ͨ�õ���ɾ�Ĳ���
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(String sql, Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //ע���һ��������i+1
            }
            //4.ִ�в���
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.�ر���Դ
            JDBCUtils.closeResource(conn,pre);
        }
        return 0;
    }




    /**
     * �������ݿ�����
     * ͨ�õ���ɾ�Ĳ���
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(Connection conn,String sql, Object ...args)  {
        PreparedStatement pre = null;
        try {
            //1.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //2.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //ע���һ��������i+1
            }
            //3.ִ�в���
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //4.�ر���Դ
            JDBCUtils.closeResource(null,pre);
        }
        return 0;
    }
}
