package Day7_25_IOfile;

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) throws Exception{
        File file = new File("E:\\Java学习视频");
        System.out.println(file.exists()); //true
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.isFile()); // false
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        String s = file.getAbsolutePath();
        System.out.println(s);
        String[] s1 = file.list();
        for (String data:s1){
            System.out.println(data);
        }
    }
}
