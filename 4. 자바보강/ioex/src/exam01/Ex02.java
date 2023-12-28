package exam01;

import java.io.FileInputStream;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt")){
            while(fis.available() > 0){
                System.out.print((char)fis.read());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
