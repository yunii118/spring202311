package exam03;

public class Human extends Animal{
    @Override
    public void move() {
        System.out.println("두발로 직립 보행");
    }

    public void readBook(){
        System.out.println("책을 읽는다.");
    }
}
