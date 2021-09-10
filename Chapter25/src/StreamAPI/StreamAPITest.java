package StreamAPI;

import java1.Employee;
import java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * 1.Stream关注的是对数据的运算，和CPU打交道
 *      集合关注的是数据的存储，和内存打交道
 * 2. Stream自己不会存储元素
 *      Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
 *      Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * 3.Stream执行流程
 *  Stream的实例化
 *  一系列的中间操作（过滤、映射...）
 *  终止操作
 * 4.说明：
 *      一个中间操作链，对数据源的数据进行处理
 *      一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会在被使用
 *
 */
public class StreamAPITest {
    /**
     * 方式一：通过集合 创建Stream
     */
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();

//        default Stream<E> parallelStream(): 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    /**
     * 方式二：通过数组：Arrays.stream(数组对象)
     */
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,6,55};
        IntStream intStream = Arrays.stream(arr);

        Employee employee = new Employee(10, "王者", 230, 6660);
        Employee[] list = new Employee[]{employee};

        Stream<Employee> employeeStream = Arrays.stream(list);

    }

    /**
     * 方式三：通过Stream.of
     */
    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

    }

    /**
     * 创建无限流
     * Stream的静态方法iterate
     * 静态方法generate
     */
    @Test
    public void test4(){
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out :: println);

        Stream.generate(Math::random).limit(10).forEach(System.out :: println);
    }
}
