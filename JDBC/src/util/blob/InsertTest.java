package util.blob;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
    /**
     * ʹ��prepareStatementʵ�������Ĳ���
     * ��ʱ ��8286ms
     *
     */
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql= "insert into goods(name) value(?)";
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < 10000 ; i++) {
                    pre.setObject(1,"name_"+i);
                    pre.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("����ʱ��:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * ʹ��
     * 1.addBatch();
     * //2.ִ��batch
     *  pre.executeBatch();
     * //3.���Batch
     *  pre.clearBatch();
     *  7091ms
     *
     */
    @Test
    public void test2(){
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql= "insert into goods(name) value(?)";
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < 10000 ; i++) {
                pre.setObject(1,"name_"+i);
                // 1.���ܡ�sql���
                pre.addBatch();
                if(i % 500 == 0){
                    //2.ִ��batch
                    pre.executeBatch();
                    //3.���Batch
                    pre.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("����ʱ��:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * �����������Ч�ķ�ʽ
     *
     * �������Ӳ������Զ��ύ
     * 1152ms
     *
     */
    @Test
    public void test3(){
        Connection conn = null;
        PreparedStatement pre = null;
        try {

            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            //���ò������Զ��ύ����
            conn.setAutoCommit(false);
            String sql= "insert into goods(name) value(?)";
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < 10000 ; i++) {
                pre.setObject(1,"name_"+i);
                // 1.���ܡ�sql���
                pre.addBatch();
                if(i % 500 == 0){
                    //2.ִ��batch
                    pre.executeBatch();
                    //3.���Batch
                    pre.clearBatch();
                }
            }
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("����ʱ��:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }
}
