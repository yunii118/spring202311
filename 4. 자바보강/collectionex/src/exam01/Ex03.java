package exam01;

import java.util.Stack;

public class Ex03 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("이름1");
        names.push("이름2");
        names.push("이름3");

        while(!names.empty()){
            System.out.println(names.pop());
        }
    }
}
