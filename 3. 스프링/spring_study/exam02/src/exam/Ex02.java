package exam;

public class Ex02 {

    public static void main(String[] args) {
        C c = new C();
        A a = new D();

        // 문제 있을 수 있음. 강제 형변환 해줘야함
        if(a instanceof C){
            C c2 = (C)a;
        }
    }
}
