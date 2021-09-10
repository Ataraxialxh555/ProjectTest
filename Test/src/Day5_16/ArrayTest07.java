package Day5_16;

public class ArrayTest07 {
    public static void main(String[] args) {
        //模拟用户的登录。
        if(args.length != 2){
            System.out.println("请输入正确的用户名和密码，例如：zhangsan 123");
            return;
        }
        String userName = args[0];
        String password = args[1];
//        if(userName.equals("admin") && password.equals("123"))
        if("admin".equals(userName) && "123".equals(password)){
            System.out.println("欢迎"+userName+"回来！");
            System.out.println("请继续使用系统");
        }else{
            System.out.println("用户名或者账号密码错误！");
        }
    }
}
