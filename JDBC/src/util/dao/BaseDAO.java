package util.dao;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {


    /**
     *      ͨ�õĲ�ѯһ��sql����д�����ڲ�ͬ�ı�
     *      ͨ�õĲ�ѯ���������ڷ������ݱ��һ����¼
     *     �� ��������
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
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.ִ��,�õ������rs
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
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
     *      �������ݿ�����
     *      ͨ�õ���ɾ�Ĳ���
     *      Version2.0
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement pre = null;
        try {
            //1.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //2.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);  //ע���һ��������i+1
            }
            //3.ִ�в���
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.�ر���Դ
            JDBCUtils.closeResource(null, pre);
        }
        return 0;
    }

    /**
     * ��ѯsql���еĶ�������  ����������
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
            //2.Ԥ����sql���
            pre = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            //4.ִ��
            rs = pre.executeQuery();
            //��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //ͨ��ResultSetMetaData��ȡ������е�����
            //getColumnCount ���ش� ResultSet �����е�������
            int columnCount = rsmd.getColumnCount();
            //����List����
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()) {
                //ͨ��������ƴ�������
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

    //���ڲ�ѯ����ֵ��ͨ�õķ���
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
