package exam01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ex05 {
    public static void main(String[] args) {
        byte[] buffer = new byte[5]; // 버퍼 담기

        try(FileInputStream fis = new FileInputStream("test2.txt")){
            while(fis.available() > 0){
                int ch = fis.read(buffer);
                for(int i = 0;i<buffer.length;i++){
                    System.out.print((char)buffer[i]);
                }
                System.out.println();
                // buffer 배열 덮어씌우기, 꽉찬다고 비우는게 아님

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
