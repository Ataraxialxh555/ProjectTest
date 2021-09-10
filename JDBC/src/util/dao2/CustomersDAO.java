package util.dao2;

import util.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomersDAO {
    /**
     * ��cust������ӵ����ݿ���
     * @param conn
     * @param cust
     */
    void insert(Connection conn, Customer cust);

    /**
     * ���ָ����id��ɾ�����е�һ����¼
     * @param conn
     * @param id
     */
    void deleteById(Connection conn,int id);

    /**
     * ����ڴ��е�cust����ȥ�޸����ݱ���ָ���ļ�¼
     * @param conn
     * @param cust
     */
    void update(Connection conn,Customer cust);

    /**
     * ���ָ����id��ѯ�õ���Ӧ��Customer����
     * @param conn
     * @param id
     * @return
     */
    Customer getCustomerById(Connection conn,int id );

    /**
     * ��ѯ���е����м�¼���ɵļ���
     * @param conn
     * @return
     */
    List<Customer> getAll(Connection conn);

    /**
     * �������ݱ��е����ݵ���Ŀ��
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * �������ݱ��е���������
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);

}
