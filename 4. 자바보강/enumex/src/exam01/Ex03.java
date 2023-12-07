package exam01;

public class Ex03 {
    public static void main(String[] args) {
        // BUS도 객체라는 의미
        System.out.println(Transportation.BUS instanceof Transportation);


        // 생성자 private으로 이루어짐
        // 상수는 하나만
        //Transportation trans = new Transportation();

        int totalFare = Transportation.BUS.getTotal(10);
        System.out.println(totalFare);
    }


}
