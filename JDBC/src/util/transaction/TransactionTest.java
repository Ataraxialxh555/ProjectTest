package util.transaction;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据库事务
 *
 * 数据一旦提交，就不可回滚
 */
public class TransactionTest {
    //未考虑数据库事务操作的转账操作
    @Test
    public void testUpdate(){
        String sql="update user_table set balance =  balance-100 where user = ?";
        int aa = update(sql, "AA");
        String sql1="update user_table set balance =  balance+100 where user = ?";
        int bb = update(sql1, "BB");
        if (aa != -1 && bb != -1 ){
           System.out.println("转账成功！");
        }
    }

    //考虑数据库事务的转账操作
    @Test
    public void testWithTransaction(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //1.取消数据的自动提交功能    setAutoCommit()
            conn.setAutoCommit(false);
            String sql="update user_table set balance =  balance-100 where user = ?";
            update(conn,sql,"AA");

            //模糊网络异常
            System.out.println(10/0);
            String sql1="update user_table set balance =  balance+100 where user = ?";
            update(conn,sql1, "BB");

            //2.提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常操作则回滚到上一次提交数据的状态
            //3.回滚数据
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally{
            //修改其为自动提交数据
            //主要针对数据库连接池的使用
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
    }

    /**
     * 未考虑数据库事务
     * 通用的增删改操作
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(String sql, Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //注意第一个参数是i+1
            }
            //4.执行操作
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭资源
            JDBCUtils.closeResource(conn,pre);
        }
        return 0;
    }




    /**
     * 考虑数据库事务
     * 通用的增删改操作
     * @param sql
     * @param args
     * @throws Exception
     */
    public int update(Connection conn,String sql, Object ...args)  {
        PreparedStatement pre = null;
        try {
            //1.预编译sql语句
            pre = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //注意第一个参数是i+1
            }
            //3.执行操作
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //4.关闭资源
            JDBCUtils.closeResource(null,pre);
        }
        return 0;
    }
}
