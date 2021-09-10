package Day27;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        System.out.println("请输入用户名:");
        Scanner s = new Scanner(System.in);
        String userName = s.next();
        System.out.println("请输入用户密码信息:");
        Scanner s1 = new Scanner(System.in);
        String password = s1.next();

        Homework hm = new Homework();
        try {
            hm.register(userName,password);
        } catch (OtherException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

    }
    public void register(String userName,String password) throws OtherException{
        // userName == null 这个做判断的时候最好放到所有条件的最前面
        // null == userName
        if (userName == null || userName.length() < 6 || userName.length() > 14){
             throw new OtherException("用户名长度不在[6 14]之内，长度异常！！");
        }else{
            System.out.println("注册成功！"+"欢迎["+userName+"]");
        }
    }
}
class OtherException extends Exception{
    public OtherException(){}
    public OtherException(String s){
        super(s);
    }
}
