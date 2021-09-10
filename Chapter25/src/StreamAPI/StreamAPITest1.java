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
    //筛选和切片
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        // filter(Predicate p) 接受lambda，从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        //查询Employee表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary()>7000).forEach(System.out :: println);

        System.out.println();
        //limit(n) 截断流 使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out:: println);

        System.out.println();

        //skip(n) 跳过元素，返回一个扔掉了前n个元素的流
        //若流中元素不足n个，则返回一个空流
        employees.stream().skip(3).forEach(System.out:: println);
        System.out.println();
        //distinct() 去除重复的数据
        employees.add(new Employee(20,"刘强东",40,20000.56));
        employees.add(new Employee(20,"刘强东",42,20000.56));
        employees.add(new Employee(20,"刘强东",40,20000.56));
        employees.add(new Employee(20,"刘强东",40,20000.56));
        employees.stream().distinct().forEach(System.out::println);


    }


    //映射
    // map(Function f)
    // flatMap(Function f)
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("aa", "bb", "cc");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }


    //排序
    @Test
    public void test2(){
        List<Integer> integerList = Arrays.asList(21, 12, 3, 26, 989, -26, 32);
        integerList.stream().sorted().forEach(System.out::println);
    }
}
