package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());
        //appleBox.setItem(new Pear());
        // 다른거 넣으면 오류 발생함.
        Apple apple = appleBox.getItem();
        // 자동형변환
        apple.print();

        Box<Pear> pearBox = new Box<>();
        pearBox.setItem(new Pear());

    }
}
