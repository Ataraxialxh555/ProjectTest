package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class PreparedStatementTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.print("密   码：");
        String password = scan.nextLine();
        //预编译sql语句
        String sql = "SELECT user,password FROM user_table WHERE user = ? AND password = ? ";
        User user = queryForCommon(User.class,sql,userName,password);
        if (user != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 以下是使用PrepareStatement可以防止sql注入问题
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static  <T> T queryForCommon(Class<T> clazz,String sql,Object...args){
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句
            pre = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.执行
            rs = pre.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            //getColumnCount 返回此 ResultSet 对象中的列数。
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
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
                    field.set(t,columnValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            JDBCUtils.closeResource(conn,pre,rs);
        }
        return null;
    }
}
