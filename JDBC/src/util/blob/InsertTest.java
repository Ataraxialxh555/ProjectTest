package util.blob;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
    /**
     * 使用prepareStatement实现批量的操作
     * 耗时 ：8286ms
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
            System.out.println("花费时间:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * 使用
     * 1.addBatch();
     * //2.执行batch
     *  pre.executeBatch();
     * //3.清空Batch
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
                // 1.“攒”sql语句
                pre.addBatch();
                if(i % 500 == 0){
                    //2.执行batch
                    pre.executeBatch();
                    //3.清空Batch
                    pre.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("花费时间:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * 批量操作最高效的方式
     *
     * 设置连接不允许自动提交
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
            //设置不允许自动提交数据
            conn.setAutoCommit(false);
            String sql= "insert into goods(name) value(?)";
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < 10000 ; i++) {
                pre.setObject(1,"name_"+i);
                // 1.“攒”sql语句
                pre.addBatch();
                if(i % 500 == 0){
                    //2.执行batch
                    pre.executeBatch();
                    //3.清空Batch
                    pre.clearBatch();
                }
            }
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费时间:"+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }
}
