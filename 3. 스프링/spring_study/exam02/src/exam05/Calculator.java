package exam05;

public interface Calculator {
    int add(int num1, int num2); // default - public abstact
    default int minus(int num1, int num2){
        return num1 - num2;
    }

}
