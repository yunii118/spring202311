package exam01;

public class Ex06 {
    public static void main(String[] args) {
        Buy buy = new Buy();
        buy.setBudget(10000);
        buy.buy(new Americano());
        buy.buy(new Latte());
    }
}
