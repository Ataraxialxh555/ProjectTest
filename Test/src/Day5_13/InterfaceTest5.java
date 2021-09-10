package Day5_13;

public class InterfaceTest5 {
    public static void main(String[] args) {

    }
}
interface StudentManger{
//    int NO;  //必须初始化
    public void addStudent(int id,String name);
    public abstract void delStudent(int id,String name );
}