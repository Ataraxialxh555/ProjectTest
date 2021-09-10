package Reflect;

public class ReflectTest05 {
    public static void main(String[] args) {
        // 以下方式可以获取绝对路径
        // Thread.currentThread() 当前线程对象
        // getContextClassLoader() 是线程对象的方法,可以获取到当前线程的类加载器对象
        // getResource() [获取资源]这是类加载器对象的方法,当前线程的类加载器默认从类的根路径下加载资源

        // 这个有个重点:getResource("") 里面的文件必须是src路径下
        // 从类的根路径src作为起点开始
        // 获取文件的绝对路径,前提是文件需要在类路径src下,才能使用这种方式.
        String path = Thread.currentThread().
                getContextClassLoader().getResource("Reflect//classInformation.properties").getPath();

        System.out.println(path);

    }
}
