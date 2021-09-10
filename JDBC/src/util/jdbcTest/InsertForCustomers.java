package util.jdbcTest;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertForCustomers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("??????????:");
        String name = scanner.next();
        System.out.print("??????????:");
        String email = scanner.next();
        System.out.print("?????????????:");
        String birthday = scanner.next();
        String sql="insert into customers(name,email,birth) values(?,?,?)";
        int insertCount = update(sql, name, email, birthday);
        if (insertCount>0){
            System.out.println("??????");
        }else{
            System.out.println("??????");
        }
    }

    /**
     * ??examstudent???????????
     */


    @Test
    public void testInsert(){
        //sql????????����
        String sql="insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int insertCount = update(sql, 5, "232656126502", "23202561312", "???", "????", 99);
        if(insertCount>0){
            System.out.println("????????");
        }else{
            System.out.println("?????????");
        }
    }


    /**
     * ????????????
     * @param sql
     * @param args
     * @throws Exception
     */
    public static int  update(String sql,Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.????????????
            conn = JDBCUtils.getConnection();
            //2.?????sql???
            pre = conn.prepareStatement(sql);
            //3.????��??
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //?????????????i+1
            }
            //4.??��???
//            pre.execute();
            //?????��????????????��?????????????????true
            //?????��???????????????��?????????????????false

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.??????
            JDBCUtils.closeResource(conn,pre);
        }
        return 0;

    }
    /**
     * ????????????
     * @param sql
     * @param args
     * @throws Exception
     */
    public static void  update1(String sql,Object ...args)  {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1.????????????
            conn = JDBCUtils.getConnection();
            //2.?????sql???
            pre = conn.prepareStatement(sql);
            //3.????��??
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);  //?????????????i+1
            }
            //4.??��???
            pre.execute();
            //?????��????????????��?????????????????true
            //?????��???????????????��?????????????????false

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.??????
            JDBCUtils.closeResource(conn,pre);
        }
    }
}