package exam01;

public class Ex04 {
    public static void main(String[] args) {
        // 리터럴 상수
        // 데이터 영역에 10이라는 값 하나가 존재
        // num1 과 num2는 같은 10이라는 수를 참조함
        int num1 = 10;
        int num2 = 10;

        System.out.println(num1 == num2);
        System.out.println("num1 = " + System.identityHashCode(num1));
        System.out.println("num2 = " + System.identityHashCode(num2));
    }
}
