package exam01;
// 람다식에서 사용하려면 메소드가 하나만 존재해야함
// 이를 위해서 메소드를 하나만 정의하도록
// 애노테이션으로 메소드 하나 이상 만들지 못하도록
// 강제
@FunctionalInterface
public interface Calculator {
    int square(int num);
    // int root(int num);
}
