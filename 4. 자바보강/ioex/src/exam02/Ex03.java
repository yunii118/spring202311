package exam02;

import java.io.FileOutputStream;

public class Ex03 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("text3.txt")){
            fos.write('안');
            fos.write('녕');
            fos.write('하');
            fos.write('세');
            fos.write('요');
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
