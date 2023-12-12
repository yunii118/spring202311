package exam03;

import exam02.Fruit;

public class Juicier {
    // 아직 객체가 안만들어짐 -> <>안에 apple 사용 불가능
    // 대신 와일드카드(?) 로 바꿔줘야함

    // 뒤에 명시
    public static void make(FruitBox<?> fruitBox) {
        System.out.println(fruitBox.getItems());

    }

    // 앞에 명시
    public static <T extends Fruit> void make2(FruitBox<T> fruitBox){
        System.out.println(fruitBox.getItems());
    }




}
