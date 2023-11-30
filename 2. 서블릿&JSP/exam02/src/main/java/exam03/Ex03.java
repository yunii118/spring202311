package exam03;

public class Ex03 {
    public static void main(String[] args) {
        A a1 = new C();
        A a2 = new D();
        // C() -> super() : B() -> super() : A()
        // 참조변수 instanceof 부모
        if(a2 instanceof C){
            C c1 = (C)a2;
        }


    }
}
