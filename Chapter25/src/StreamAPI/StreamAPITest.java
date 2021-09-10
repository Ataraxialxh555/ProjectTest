package StreamAPI;

import java1.Employee;
import java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * 1.Stream��ע���Ƕ����ݵ����㣬��CPU�򽻵�
 *      ���Ϲ�ע�������ݵĴ洢�����ڴ�򽻵�
 * 2. Stream�Լ�����洢Ԫ��
 *      Stream����ı�Դ�����෴�����ǻ᷵��һ�����н������Stream
 *      Stream�������ӳ�ִ�еġ�����ζ�����ǻ�ȵ���Ҫ�����ʱ���ִ��
 * 3.Streamִ������
 *  Stream��ʵ����
 *  һϵ�е��м���������ˡ�ӳ��...��
 *  ��ֹ����
 * 4.˵����
 *      һ���м��������������Դ�����ݽ��д���
 *      һ��ִ����ֹ��������ִ���м�������������������֮�󣬲����ڱ�ʹ��
 *
 */
public class StreamAPITest {
    /**
     * ��ʽһ��ͨ������ ����Stream
     */
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        default Stream<E> stream():����һ��˳����
        Stream<Employee> stream = employees.stream();

//        default Stream<E> parallelStream(): ����һ��������
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    /**
     * ��ʽ����ͨ�����飺Arrays.stream(�������)
     */
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,6,55};
        IntStream intStream = Arrays.stream(arr);

        Employee employee = new Employee(10, "����", 230, 6660);
        Employee[] list = new Employee[]{employee};

        Stream<Employee> employeeStream = Arrays.stream(list);

    }

    /**
     * ��ʽ����ͨ��Stream.of
     */
    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

    }

    /**
     * ����������
     * Stream�ľ�̬����iterate
     * ��̬����generate
     */
    @Test
    public void test4(){
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out :: println);

        Stream.generate(Math::random).limit(10).forEach(System.out :: println);
    }
}
