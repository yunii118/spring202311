package exam01;

import java.io.FileOutputStream;

public class Ex03 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("test2.txt")){
            for(char ch='A';ch<='Z';ch++){
                fos.write(ch);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
