package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Integer num1 = new Integer(10);
        //Integer num2 = new Integer(10);

        Integer num1 = Integer.valueOf(10);
        Integer num2 = Integer.valueOf(10);

        System.out.println(num1 == num2);
        System.out.println("num1 = " + System.identityHashCode(num1));
        System.out.println("num2 = " + System.identityHashCode(num2));
    }
}
