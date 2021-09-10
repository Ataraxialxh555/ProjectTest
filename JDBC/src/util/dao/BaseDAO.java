package util.dao;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {


    /**
     *      通用的查询一条sql语句的写法对于不同的表
     *      通用的查询操作，用于返回数据表的一条记录
     *     考 虑了事务
     *      Version2.0
     *
     * @param conn
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
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.执行,得到结果集rs
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                //反射机制创建对象
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取当前这条数据的各个字段值
                    // 以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。
                    Object columnValue = rs.getObject(i + 1);
                    //获取每一列的列名
                    //getColumnLabel:获取指定列的别名。
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //给t对象指定的某个属性，赋值为columnValue

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);//打破封装
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
     *      考虑数据库事务
     *      通用的增删改操作
     *      Version2.0
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement pre = null;
        try {
            //1.预编译sql语句
            pre = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);  //注意第一个参数是i+1
            }
            //3.执行操作
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            JDBCUtils.closeResource(null, pre);
        }
        return 0;
    }

    /**
     * 查询sql表中的多条数据  考虑了事务
     *     Version2.0
     * @param conn
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.执行
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();
            //创建List数组
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()) {
                //通过反射机制创建对象
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取当前这条数据的各个字段值
                    // 以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值。
                    Object columnValue = rs.getObject(i + 1);
                    //获取每一列的列名
                    //getColumnLabel:获取指定列的别名。
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //给t对象指定的某个属性，赋值为columnValue

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);//打破封装
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(null, pre, rs);
        }
        return null;
    }

    //用于查询特殊值的通用的方法
    public <E> E getValue(Connection conn,String sql,Object ... args)  {
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }

            rs = pre.executeQuery();

            if (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeResource(null,pre,rs);

        }
        return null;
    }
}
