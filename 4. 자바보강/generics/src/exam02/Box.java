package exam02;

public class Box<T extends Fruit> {
    // T는 Fruit의 하위 클래스로 한정시켜줌
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void printItem(){
        // T는 현재 Object
        // 객체를 만드는 시점에 투입된 타입으로 형변환됨
        // T-> Fruit, 객체를 만드는 시점에 투입된 타입으로 형변환됨
        item.print();
    }
}
