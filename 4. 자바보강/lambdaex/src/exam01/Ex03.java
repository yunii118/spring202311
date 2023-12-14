package exam01;

public class Ex03 {

    public static void main(String[] args) {
        Calculator cal = x -> x * x;
        // 굳이 매개변수 타입, 리턴타입 명시하지 않아도
        // 컴파일하는데 이상 없음

        int result = cal.square(10);
        System.out.println(result);




    }
}
