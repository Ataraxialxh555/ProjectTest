public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("lixianghuan",24,30,"1212");
        Student s2 = new Student("lixianghuan",24,30,"1212");
        System.out.println(s1.equals(s2));
    }
}
