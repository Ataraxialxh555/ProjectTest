package Day7_21_IO;

import java.io.*;

public class FileOutputStreamTest04 {
    //文件复制
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\Java学习视频\\Java核心技术学习视频\\00500028_MLDN-魔乐科技-李兴华【Java核心技术】_Java简介.avi");
            fos = new FileOutputStream("C:\\Users\\12431\\00500028_MLDN-魔乐科技-李兴华【Java核心技术】_Java简介.avi");
            byte[] bytes = new byte[1024*1024]; //1MB
            int countRead = 0;
            while((countRead = fis.read(bytes))!=-1) {
                fos.write(bytes,0,countRead);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
