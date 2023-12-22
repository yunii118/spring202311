package exam02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex02 {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream("specs.zip");
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("specs_copied2.zip");
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            while(bis.available() > 0){
                bos.write(bis.read());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        long etime = System.currentTimeMillis();
        System.out.printf("걸린시간 : %d%n", etime - stime);
    }
}
