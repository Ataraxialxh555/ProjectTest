package util.DAOjuint;

import org.junit.jupiter.api.Test;
import util.Customer;

import util.JDBCUtils;
import util.dao.CustomersDAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public class CustomersDAOImplTest {

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse("1997-02-02");
            Customer customer = new Customer(1,"lixiang","x@qq.com", new Date(31321313L));
            cd.insert(conn,customer);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testDeleteById(){
        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            int id = 25;
            cd.deleteById(conn,id);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }


    @Test
    public void testUpdate(){
        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            Customer customer = new Customer(23,"wangzha","wangzhe@qq.com",new Date(1315215451L));
            cd.update(conn,customer);
            System.out.println("update成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetCustomerById(){
        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            Customer c = cd.getCustomerById(conn, 23);
            System.out.println(c);
            System.out.println("GetCustomerById成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetAll(){
        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            List<Customer> allList = cd.getAll(conn);
            for(Customer list:allList){
                System.out.println(list);
            }
            System.out.println("GetAll成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetCount(){

        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            Long count = cd.getCount(conn);
            System.out.println(count);
            System.out.println("GetCount成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }


    @Test
    public void testGetMaxBirth(){

        Connection conn = null;
        try {
            CustomersDAOImpl cd = new CustomersDAOImpl();
            conn = JDBCUtils.getConnection();
            Date maxBirth = cd.getMaxBirth(conn);
            System.out.println(maxBirth);
            System.out.println("GetMaxBirth成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
