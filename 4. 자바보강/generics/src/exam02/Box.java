package exam02;

public class Box<T extends Fruit> {
    // T는 Fruit의 하위 클래스로 한정시켜줌
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    } // generic 클래스 - 객체가 만들어질 때 타입 결정됨

    public void printItem(){
        // T는 현재 Object
        // 객체를 만드는 시점에 투입된 타입으로 형변환됨
        // T-> Fruit, 객체를 만드는 시점에 투입된 타입으로 형변환됨
        item.print();
    }

    public <T> void testMethod(T t){
        // generic 메서드 - 메서드가 호출될 때 타입이 결정됨
    }
}
