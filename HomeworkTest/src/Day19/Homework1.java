package Day19;

public class Homework1 {
    public static void main(String[] args) {
    User u = new User();
    u.setId(2112004135);
    u.setEmail("1243195389@qq.com");
    u.setPassword("61451313213");

    u.showInfo();
    }
}
class User{
    private int id;
    private String password;
    private String email;

    public User() {
    }

    public User(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void showInfo(){
        System.out.println("用户ID："+id +"\n用户密码："+password+"\nemail地址："+email);
    }
}