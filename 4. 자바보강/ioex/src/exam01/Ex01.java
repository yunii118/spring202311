package exam01;

import java.io.FileInputStream;

public class Ex01 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt")){
           /* char ch = (char)fis.read(); // 1byte 읽기 char(2, 3)

            System.out.println(ch);
            ch = (char)fis.read();
            System.out.println(ch);
            ch = (char)fis.read();
            System.out.println(ch);
            ch = (char)fis.read();
            System.out.println(ch);

            int ch2 = fis.read();
            System.out.println(ch2);*/

            int ch3 = 0;
            while((ch3 = fis.read()) != -1){
                System.out.print((char)ch3);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
