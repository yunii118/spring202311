package exam03;

import exam02.Fruit;

public class Pear extends Fruit {
    public void print(){
        System.out.println("배");
    }
    @Override
    public String toString(){
        return "배";
    }
}
