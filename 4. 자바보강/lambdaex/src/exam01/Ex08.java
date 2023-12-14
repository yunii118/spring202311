package exam01;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Ex08 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length();
        Function<Integer, Integer> func2 = x -> x * x * x;

        Function<String, Integer> func3 = func1.andThen(func2);

        System.out.println(func3.apply("ABC"));

        Function<Integer, Integer> func4 = x -> x;
        Function<Integer, Integer> func5 = Function.identity();
    }
}
