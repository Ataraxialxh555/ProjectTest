package java1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {


    public static List<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"����",35,6000.0));
        employees.add(new Employee(2,"����",39,6850.0));
        employees.add(new Employee(3,"������",40,60022.22));
        employees.add(new Employee(4,"���",10000,602000.00));
        employees.add(new Employee(5,"��ɿ�",20,10000.00));
        employees.add(new Employee(6,"������",15,3000.00));
        employees.add(new Employee(6,"����Ȼ",33,6300.00));
        return employees;
    }
}
