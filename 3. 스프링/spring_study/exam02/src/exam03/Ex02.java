package exam03;

public class Ex02 {
    public static void main(String[] args) {
        // 같은 자료형만 가능함
        Animal[] animals = new Animal[3];
        animals[0] = new Human();
        animals[1] = new Dog();
        animals[2] = new Bird();

       for(Animal animal : animals){

           animal.move();

           if(animal instanceof Human){
               Human human = (Human)animal;
               human.readBook();
           }
       }
    }
}
