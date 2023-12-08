package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Apple());

        Object obj = box.getItem(); // 형변환의 번거로움
        if (obj instanceof Pear) {
            // 타입 안정성이 떨어짐
            // 정말 pard인지 확인 해줘야함
            Pear pear = (Pear) box.getItem();
        }
    }
}
