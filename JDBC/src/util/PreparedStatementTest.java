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

        System.out.print("�û�����");
        String userName = scan.nextLine();
        System.out.print("��   �룺");
        String password = scan.nextLine();
        //Ԥ����sql���
        String sql = "SELECT user,password FROM user_table WHERE user = ? AND password = ? ";
        User user = queryForCommon(User.class,sql,userName,password);
        if (user != null) {
            System.out.println("��½�ɹ�!");
        } else {
            System.out.println("�û������������");
        }
    }

    /**
     * ������ʹ��PrepareStatement���Է�ֹsqlע������
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
            //1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            //4.ִ��
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
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
