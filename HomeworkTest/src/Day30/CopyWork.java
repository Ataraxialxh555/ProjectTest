package Day30;

import java.io.*;


public class CopyWork {
    public static void main(String[] args) throws Exception{
        File sourceFile = new File("E:\\EEG论文");
        File targetFile = new File("D:\\");

        copyFile(sourceFile,targetFile);

    }

    private static void copyFile(File sourceFile, File targetFile) {
        if(sourceFile.isFile()){

            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(sourceFile);
                String srcFile = (targetFile.getAbsolutePath().endsWith("\\")?targetFile.getAbsolutePath():targetFile.getAbsolutePath()+"\\")+sourceFile.getAbsolutePath().substring(3);
                fos = new FileOutputStream(srcFile);
                byte[] bytes = new byte[1024*1024];
                int countRead = 0;
                while((countRead = fis.read(bytes)) != -1){
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

            return;
        }

        File[] files = sourceFile.listFiles();
//        System.out.println(files.length);
        for (File file :files){
//            System.out.println(file);
            if(sourceFile.isDirectory()){
//            System.out.println(sourceFile);
            String  sourcePath = sourceFile.getAbsolutePath();
//            System.out.println(sourcePath);
            String targetPath = (targetFile.getAbsolutePath().endsWith("\\")?targetFile.getAbsolutePath():targetFile.getAbsolutePath()+"\\")+sourcePath.substring(3);
//            System.out.println(targetPath);
            File file1 = new File(targetPath);
            if(!file1.exists()){
                file1.mkdir();
            }
            }
            copyFile(file,targetFile);
        }

    }
}
