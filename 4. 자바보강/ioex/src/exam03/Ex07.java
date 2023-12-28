package exam03;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("score.dat");
            DataInputStream dis = new DataInputStream(fis)){
            int total = 0;
            double count = 0;
            try {
                while(true){
                    int score = dis.readInt();
                    total += score;
                    count++;
                    System.out.println(score);
                    // EOF exception : 파일의 끝. 더이상 읽어올게 없을때 발생
                }
            }catch (EOFException e){
                // 파일의 끝에 도달한 경우
                System.out.printf("합계 : %d, 평균 : %.2f%n", total, total / count);;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
