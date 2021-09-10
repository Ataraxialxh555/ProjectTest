package StreamAPI;

import java1.Employee;
import java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class StreamAPITest2 {
    /**
     * ²âÊÔStreamµÄÖÕÖ¹²Ù×÷
     *
     */

    // Æ¥ÅäÓë²éÕÒ
    @Test
    public void test(){

        List<Employee> employeeList = EmployeeData.getEmployees();
        boolean b = employeeList.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
    }

}
