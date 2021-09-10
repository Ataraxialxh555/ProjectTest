package dbutils;

import connection.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.jupiter.api.Test;
import util.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class QueryRunnerTest {
    //���Բ���
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "������", "caixukun@qq.com", "2000-01-01");
            System.out.println("������"+insertCount+"�����ݣ�");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }


    //���Բ�ѯ
    //ʹ��BeanHandler
    //BeanHandler����ResultSetHandler �ӿڵ�ʵ���࣬���ڷ�װ���е�һ����¼
    @Test
    public void testQuery1() {
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();
            //  Դ�룺public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh,
            //            Object... params)
            String sql = "select id,name,email,birth from customers where id =?";
            BeanHandler<Customer> beanHandler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(connection3, sql, beanHandler, 22);
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection3,null);
        }
    }

    //ʹ��BeanListHandler
    //BeanListHandler����ResultSetHandler �ӿڵ�ʵ���࣬���ڷ�װ���еĶ�����¼
    @Test
    public void testQuery2(){
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();

            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> customerBeanListHandler = new BeanListHandler<Customer>(Customer.class);
            List<Customer> list = runner.query(connection3, sql, customerBeanListHandler, 22);
            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection3,null);
        }
    }


    //ʹ��ArrayHandler
    //ArrayHandler����ResultSetHandler �ӿڵ�ʵ���࣬��ResultSet ת��Ϊ Object[] ��ʵ�֡�ֻ�ܴ洢һ����¼
    //�ѽ�����еĵ�һ������ת�ɶ������顣
    @Test
    public void testQuery3()  {
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();

            String sql = "select id,name,email,birth from customers where id = ?";

            ArrayHandler arrayHandler = new ArrayHandler();
            Object[] query = runner.query(connection3, sql, arrayHandler, 22);
            for (int i = 0; i < query.length; i++) {
                System.out.println(query[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{

            JDBCUtils.closeResource(connection3,null);
        }

    }


    //ʹ��ArrayListHandler
    //ArrayListHandler����ResultSetHandler �ӿڵ�ʵ���࣬��ResultSet ת��Ϊ Object[] ��ʵ�֡��ܴ洢������¼
    //�ѽ�����е�ÿһ�����ݶ�ת��һ�����飬�ٴ�ŵ�List�С�
    @Test
    public void testQuery4() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection3 = JDBCUtils.getConnection3();

        String sql = "select id,name,email,birth from customers where id < ?";

        ArrayListHandler arrayListHandler = new ArrayListHandler();
        List<Object[]> query = runner.query(connection3, sql, arrayListHandler, 22);
        for (int i = 0; i < query.size(); i++) {
            System.out.println(query.get(i));
        }
        JDBCUtils.closeResource(connection3,null);
    }

    //ʹ��MapHandler
    //MapHandler����ResultSetHandler �ӿڵ�ʵ���࣬��Ӧ���е�һ����¼
    //���ֶμ���Ӧ�ֶε�ֵ��Ϊmap�е�key��value   �� nameΪ�� ����Ϊvalue
    //�Լ�ֵ�Եķ�ʽ�洢
    @Test
    public void testQuery5() {
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();

            String sql = "select id,name,email,birth from customers where id < ?";
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> query = runner.query(connection3, sql, mapHandler, 22);
            System.out.println(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection3);
        }
    }


    //ʹ��MapListHandler
    //MapListHandler����ResultSetHandler �ӿڵ�ʵ���࣬��Ӧ�ڱ��еĶ�����¼
    //���ֶ��Լ���Ӧ�ֶε�ֵ��Ϊmap�е�key��value ������Щmap��ӵ�List������
    @Test
    public void testQuery6(){
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();

            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> mapList = runner.query(connection3, sql, mapListHandler, 22);
            mapList.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection3);
        }
    }

    /**
     * ��Ҫ��ѯһЩ������Ϣ
     * ������ж���������
     * count(*)
     * max(birth) ������������
     * @throws Exception
     *
     * ʹ��ScalarHandler
     */
    @Test
    public void testQuery7() {
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();
            ScalarHandler scalarHandler = new ScalarHandler();
            String sql = "select count(*) from customers";
            Long  count = (Long) runner.query(connection3, sql, scalarHandler);
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection3);
        }

    }

    /**
     * ���ڲ�ѯ����ֵ
     * ScalarHandler
     * @throws Exception
     */
    @Test
    public void testQuery8(){
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();
            ScalarHandler scalarHandler = new ScalarHandler();
            String sql = "select max(birth) from customers";
            Date date = (Date) runner.query(connection3, sql, scalarHandler);
            System.out.println(date);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection3);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }




}
