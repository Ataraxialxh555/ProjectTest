package java1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {


    public static List<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"马云",35,6000.0));
        employees.add(new Employee(2,"马化腾",39,6850.0));
        employees.add(new Employee(3,"任正非",40,60022.22));
        employees.add(new Employee(4,"李白",10000,602000.00));
        employees.add(new Employee(5,"李飞可",20,10000.00));
        employees.add(new Employee(6,"李子奇",15,3000.00));
        employees.add(new Employee(6,"王浩然",33,6300.00));
        return employees;
    }
}
