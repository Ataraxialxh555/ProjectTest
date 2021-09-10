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
    //测试插入
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "蔡徐坤", "caixukun@qq.com", "2000-01-01");
            System.out.println("插入了"+insertCount+"条数据！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }


    //测试查询
    //使用BeanHandler
    //BeanHandler：是ResultSetHandler 接口的实现类，用于封装表中的一条记录
    @Test
    public void testQuery1() {
        Connection connection3 = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection3 = JDBCUtils.getConnection3();
            //  源码：public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh,
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

    //使用BeanListHandler
    //BeanListHandler：是ResultSetHandler 接口的实现类，用于封装表中的多条记录
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


    //使用ArrayHandler
    //ArrayHandler：是ResultSetHandler 接口的实现类，将ResultSet 转换为 Object[] 的实现。只能存储一条记录
    //把结果集中的第一行数据转成对象数组。
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


    //使用ArrayListHandler
    //ArrayListHandler：是ResultSetHandler 接口的实现类，将ResultSet 转换为 Object[] 的实现。能存储多条记录
    //把结果集中的每一行数据都转成一个数组，再存放到List中。
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

    //使用MapHandler
    //MapHandler：是ResultSetHandler 接口的实现类，对应表中的一条记录
    //将字段及相应字段的值作为map中的key和value   如 name为键 名字为value
    //以键值对的方式存储
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


    //使用MapListHandler
    //MapListHandler：是ResultSetHandler 接口的实现类，对应于表中的多条记录
    //将字段以及相应字段的值作为map中的key和value ，将这些map添加到List集合中
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
     * 需要查询一些特殊信息
     * 如表中有多少条数据
     * count(*)
     * max(birth) 最大的生日日期
     * @throws Exception
     *
     * 使用ScalarHandler
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
     * 用于查询特殊值
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
