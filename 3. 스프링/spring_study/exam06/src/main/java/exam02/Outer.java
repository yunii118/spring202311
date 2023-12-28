package exam02;

public class Outer {
    Calculator method(int num3){
        // 지역 내부 클래스
//        class Inner{
//            void innerMethod(){
//                System.out.println("지역 내부 클래스!!");
//            }
//        }
//
//        Inner in = new Inner();
//        in.innerMethod();
        return new Calculator() {
            // 익명 내부 클래스
            @Override
            public int add(int num1, int num2) {
                return num1 + num2 + num3;
            }
        };


    }
}
