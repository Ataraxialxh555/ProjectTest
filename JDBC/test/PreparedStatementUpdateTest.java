import org.junit.Test;
import util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementUpdateTest {


    @Test
    public void  testInset()  {
        //1.��ȡ�����ļ��е�4��������Ϣ
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(in);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driver = pro.getProperty("driver");

            //2.����Driver����
            Class.forName(driver);

            //3.�������ݿ�
            conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
            //4.Ԥ����sql��䣬����PreparedStatement��ʵ��
            String sql="insert into customers(name,email,birth) values(?,?,?)";// ?Ϊռλ��

            preparedStatement = conn.prepareStatement(sql);

            //5.���ռλ��
            preparedStatement.setString(1,"�����");
            preparedStatement.setString(2,"12123qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1997-05-05");
            preparedStatement.setDate(3,new Date(date.getTime()));

            //6.ִ��sql

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //7.�ر���
            try {
                if(conn != null)
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * �޸�sql���е�����
     */
    @Test
    public void testUpdate()  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.��ȡ���ݿ������
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql��䣬����PreparedStatement��ʵ��
            String sql = "update customers set name = ? where id = ?";
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            pre.setString(1, "�����");
            //pre.setObject(1,"Ī����");
            pre.setInt(2, 18);
            //pre.setObject(2,18);
            //4.ִ�в���
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.�ر���
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * ɾ��sql���е�����
     */
    @Test
    public void testDelete(){
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            String sql="delete from customers where id = ?";
            pre = conn.prepareStatement(sql);
            //3.���sql���
            pre.setObject(1,21);
            //4.ִ�в���
            pre.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,pre);
        }
    }

    /**
     * ͨ�õ���ɾ�Ĳ���
     * @param sql
     * @param args
     * @throws Exception
     */
    public void update(String sql,Object ...args)  {
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
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.�ر���Դ
            JDBCUtils.closeResource(conn,pre);
        }

    }

    /**
     * ɾ��id=6��customers���е�����
     * @throws Exception
     */

    @Test
    public void testCommonUpdate() throws Exception {
//        String sql="delete from customers where id = ?";
//        update(sql,6);
        String sql="delete from `order`";
        update(sql);

    }
}
