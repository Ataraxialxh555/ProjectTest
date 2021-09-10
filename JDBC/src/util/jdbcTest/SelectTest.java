package util.jdbcTest;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class SelectTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("��ѡ����Ҫ���������:");
        System.out.println("a:׼��֤��");
        System.out.println("b:���֤��");
        String selectString = s.next();

        if("a".equals(selectString)){
            System.out.println("������׼��֤��:");
            String examCard = s.next();
            String sql="select FlowID id,Type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade" +
                    " from examstudent where ExamCard = ?";
            Examstudent examstudent = queryForCommon(Examstudent.class, sql, examCard);
            if(examstudent != null){
                System.out.println("==========��ѯ���==============");
                System.out.println(examstudent);
            }else{
                System.out.println("���޴��ˣ����������룡");
            }

        }else if ("b".equals(selectString)){
            System.out.println("���������֤��:");
            String idCard = s.next();
            String sql="select FlowID id,Type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade" +
                    " from examstudent where IDCard = ?";
            Examstudent examstudent = queryForCommon(Examstudent.class, sql, idCard);
            if(examstudent != null){
                System.out.println("==========��ѯ���==============");
                System.out.println(examstudent);
            }else{
                System.out.println("���޴��ˣ����������룡");
            }

        }else{
            System.out.println("������������!,�����½������");
        }

    }


    /**
     * ͨ�õĲ�ѯһ��sql����д�����ڲ�ͬ�ı�
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T queryForCommon(Class<T> clazz,String sql,Object...args){
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
