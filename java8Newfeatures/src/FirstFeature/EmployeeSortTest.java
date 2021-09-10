package FirstFeature;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[]  staff = new Employee[3];
        staff[0] = new Employee("lixianghuan",80000);
        staff[1] = new Employee("zhangfei",8000);
        staff[2] = new Employee("liubei",15000);
        Arrays.sort(staff);
        for(Employee e : staff){
            System.out.println(e);
        }
    }
}
