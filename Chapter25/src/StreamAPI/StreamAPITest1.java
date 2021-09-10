package StreamAPI;

import java1.Employee;
import java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPITest1 {
    //ɸѡ����Ƭ
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        // filter(Predicate p) ����lambda���������ų�ĳЩԪ��
        Stream<Employee> stream = employees.stream();
        //��ѯEmployee����н�ʴ���7000��Ա����Ϣ
        stream.filter(e -> e.getSalary()>7000).forEach(System.out :: println);

        System.out.println();
        //limit(n) �ض��� ʹ��Ԫ�ز�������������
        employees.stream().limit(3).forEach(System.out:: println);

        System.out.println();

        //skip(n) ����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص���
        //������Ԫ�ز���n�����򷵻�һ������
        employees.stream().skip(3).forEach(System.out:: println);
        System.out.println();
        //distinct() ȥ���ظ�������
        employees.add(new Employee(20,"��ǿ��",40,20000.56));
        employees.add(new Employee(20,"��ǿ��",42,20000.56));
        employees.add(new Employee(20,"��ǿ��",40,20000.56));
        employees.add(new Employee(20,"��ǿ��",40,20000.56));
        employees.stream().distinct().forEach(System.out::println);


    }


    //ӳ��
    // map(Function f)
    // flatMap(Function f)
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("aa", "bb", "cc");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }


    //����
    @Test
    public void test2(){
        List<Integer> integerList = Arrays.asList(21, 12, 3, 26, 989, -26, 32);
        integerList.stream().sorted().forEach(System.out::println);
    }
}
