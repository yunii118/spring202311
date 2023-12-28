package exam01;

public class Buy {

    private int budget;

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void buy(Coffee coffee){
        if(budget>coffee.getPrice()){
            budget -= coffee.getPrice();
            System.out.println(coffee.toString() + " 구입");
        }
        else{
            System.out.println("잔액부족");
        }
    }
}
